Ext.define("wms.app.model.users.MaterialKeeperModel", {
    extend : "wms.app.model.users.AbstractUserModel",
    proxy : {
        type : 'rest',
        url : ctx+'/materialKeeper',
        reader : {
            type : "json",
            root : "data",
            successProperty : 'success',
            totalProperty : 'total'
        },
        writer : {
            type : "json"
        },
        listeners : {
            exception : function(proxy, response, operation) {
                Ext.MessageBox.show({
                    title : '系统出现异常',
                    msg : operation.getError(),
                    icon : Ext.MessageBox.ERROR,
                    buttons : Ext.Msg.OK
                });
            }
        }
    }
});