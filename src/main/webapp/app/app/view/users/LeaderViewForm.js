Ext.define("wms.app.view.users.LeaderViewForm", {
    extend : 'Ext.panel.Panel',
    alias : 'widget.leaderviewform',
    author : '100%',
    autoScroll : true,
    items : [{
        xtype : 'form',
        items : [{
            xtype : 'textfield',
            hidden : true,
            name : 'id'
        }, {
            xtype : 'textfield',
            anchor : '60%',
            margin : '5 0 0 5',
            name : 'name',
            allowBlank : false,
            fieldLabel : '名称<font color="red">*</font>'
        }, {
            xtype : 'textfield',
            anchor : '60%',
            margin : '5 0 0 5',
            name : 'code',
            allowBlank : false,
            fieldLabel : '编号<font color="red">*</font>'
        }, {
            xtype : 'radiogroup',
            anchor : '75%',
            margin : '5 0 0 5',
            allowBlank : false,
            fieldLabel : '性别<font color="red">*</font>',
            items : [{
                xtype: 'radiofield',
                name : 'gender',
                inputValue: 'MALE',
                itemId : 'genderMale_leader_rf',
                boxLabel: '男'
            }, {
                xtype: 'radiofield',
                name : 'gender',
                inputValue: 'FEMALE',
                boxLabel: '女'
            }],
            listeners : {
            	afterrender : function(radiogroup){
            		if(radiogroup.getChecked().length==0){
            			radiogroup.down('#genderMale_leader_rf').setValue('MALE');
            		}
            	}
            }
        }, {
            xtype : 'textfield',
            anchor : '75%',
            margin : '5 0 0 5',
            name : 'phone',
            allowBlank : false,
            fieldLabel : '联系电话<font color="red">*</font>'
        }, {
            xtype : 'textfield',
            anchor : '75%',
            margin : '5 0 0 5',
            name : 'address',
            fieldLabel : '地址'
        }, {
            xtype : 'textfield',
            anchor : '75%',
            margin : '5 0 0 5',
            name : 'email',
            fieldLabel : '电子邮件'
        }, {
            xtype : 'radiogroup',
            anchor : '75%',
            margin : '5 0 0 5',
            allowBlank : false,
            fieldLabel : '状态<font color="red">*</font>',
            items : [{
                xtype: 'radiofield',
                name : 'status',
                inputValue: 'ACTIVE',
                boxLabel: '可用'
            }, {
                xtype: 'radiofield',
                name : 'status',
                inputValue: 'INACTIVE',
                boxLabel: '不可用'
            }]
        }, {
            xtype : 'fieldcontainer',
            height : 30,
            anchor : '95%',
            margin : '5 0 10 5',
            style : 'text-align:center',
            items : [{
                xtype : 'button',
                margin : '5 0 0 5',
                action : 'submitLeaderForm',
                width: 80,
                text : '确认'
            }, {
                xtype : 'button',
                margin : '5 0 0 5',
                action : 'closeLeaderForm',
                width: 80,
                text : '取消'
            }]
        }]
    }]
});
