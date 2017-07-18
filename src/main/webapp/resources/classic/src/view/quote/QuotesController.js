Ext.define('FinanceMon.view.quote.QuotesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.quotesController',

    onAfterrender: function (grid) {
    },

    getButtonHandler: function (button, e) {
        var refs = this.getReferences(),
            companyCode = refs.companyCode,
            fromDate = refs.fromDate,
            toDate = refs.toDate,
            quotesGrid = button.up('grid');

        var params = {
            companyCode: companyCode.getValue(),
            fromDate: fromDate.getValue().getTime(),
            toDate: toDate.getValue().getTime()
        };

        console.log(params);

        quotesGrid.getStore().reload({
            params: params
        });
    }
});