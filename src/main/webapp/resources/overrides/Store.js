Ext.define('FinanceMon.override.data.Store', {
    override : 'Ext.data.Store',
    records2Json : function(records) {
        var result = [];

        for (var j = 0; j < records.length; j++) {
            var models = {};
            var items = records[j].fields.items;
            for (var i = 0; i < items.length; i++) {
                var name = items[i].name;
                models[name] = records[j].get(name);
            }
            result.push(models);
        }

        return result;

    },
    getAllJson : function() {
        var jsons = {
            newRecords: this.records2Json(this.getNewRecords()),
            updatedRecords: this.records2Json(this.getUpdatedRecords()),
            removedRecords: this.records2Json(this.getRemovedRecords())
        };

        return jsons;
    },

    getNewJson : function() {
        return this.records2Json(this.getNewRecords());
    },
    getUpdatedJson : function() {
        return this.records2Json(this.getUpdatedRecords());
    },
    getRemovedJson : function() {
        return this.records2Json(this.getRemovedRecords());
    },
    isValid : function() {
        var i;
        var me = this;

        for ( i = 0; i < me.getCount(); i++) {
            if (me.getAt(i).isValid() == false) {
                var errors = me.getAt(i).validate();
                Ext.Msg.alert("확인", String(i + 1) + '행에 ' + errors.items[0].message);
                return false;
            };
        }

        return true;
    }
});