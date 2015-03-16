package com.originspark.drp.service.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.originspark.drp.dao.BaseDAOSupport;
import com.originspark.drp.models.users.AbstractUser;
import com.originspark.drp.models.users.AbstractUser.COLUMNS;
import com.originspark.drp.util.enums.Gender;
import com.originspark.drp.util.enums.Status;
import com.originspark.drp.util.json.FilterRequest;

@Transactional
@Service("userService")
public class UserServiceBean extends BaseDAOSupport<AbstractUser> implements UserService {

    @Override
    public List<AbstractUser> pagedDataSet(int start, int limit,List<FilterRequest> filters) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AbstractUser> dataQuery = cb.createQuery(AbstractUser.class);

        Root<AbstractUser> user = dataQuery.from(AbstractUser.class);

        dataQuery.select(user);

        Predicate[] predicates = toPredicates(cb, user, filters);

        if (predicates != null) {
            dataQuery.where(cb.and(predicates));
        }

        return em.createQuery(dataQuery).setFirstResult(start)
                .setMaxResults(limit).getResultList();
    }

    @Override
    public Long pagedDataCount(List<FilterRequest> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<AbstractUser> user = countQuery.from(AbstractUser.class);
        countQuery.select(cb.count(user));

        Predicate[] predicates = toPredicates(cb, user, filters);

        if (predicates != null) {
            countQuery.where(cb.and(predicates));
        }

        return em.createQuery(countQuery).getSingleResult();
    }

    @Override
    public Map<String, String> validate() {

        return null;
    }

    public static Predicate[] toPredicates(CriteriaBuilder cb, Root<AbstractUser> user,
            List<FilterRequest> filters) {
        List<Predicate> criteria = new ArrayList<Predicate>();

        try {
            for (FilterRequest filter : filters) {

                COLUMNS column = COLUMNS.valueOf(filter.getProperty()
                        .toUpperCase());

                String value = filter.getValue();

                switch (column) {
                    case TYPE :
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.equal(user.get("type"), value));
                        }
                        break;
                    case NAME:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.like(user.<String>get("name"), "%" + value + "%"));
                        }
                        break;
                    case CODE:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.like(user.<String>get("code"), "%" + value + "%"));
                        }
                        break;
                    case PHONE:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.like(user.<String>get("phone"), "%" + value + "%"));
                        }
                        break;
                    case ADDRESS:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.like(user.<String>get("address"), "%" + value + "%"));
                        }
                        break;
                    case EMAIL:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.like(user.<String>get("email"), "%" + value + "%"));
                        }
                        break;
                    case GENDER:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.equal(user.<Enum<Gender>>get("gender"), Gender.valueOf(value)));
                        }
                        break;
                    case STATUS:
                        if (value != null && !value.equals("")) {
                            criteria.add(cb.equal(user.<Enum<Status>>get("status"), Status.valueOf(value)));
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (criteria.size() == 0) {
            return null;
        } else {
            Predicate[] predicates = new Predicate[criteria.size()];
            predicates = criteria.toArray(predicates);
            return predicates;
        }
    }

}
