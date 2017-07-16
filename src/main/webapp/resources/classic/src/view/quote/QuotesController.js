Ext.define('FinanceMon.view.quote.QuotesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.quotesController',

    onAfterrender: function (grid) {
        grid.getStore().reload();
    }
});