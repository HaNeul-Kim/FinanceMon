Ext.define('FinanceMon.view.quote.QuotesModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.quotesModel',

    stores: {
        quotes: {
            autoLoad: true,
            fields: [
                {mapping: 'code', name: 'code', type: 'string'},
                {mapping: 'date', name: 'date', type: 'string'},
                {mapping: 'start', name: 'start', type: 'integer'},
                {mapping: 'high', name: 'high', type: 'integer'},
                {mapping: 'low', name: 'low', type: 'integer'},
                {mapping: 'finish', name: 'finish', type: 'integer'},
                {mapping: 'quantity', name: 'quantity', type: 'integer'}
            ],

            proxy: {
                type: 'ajax',
                url: CONSTANTS.QUOTES.GET,
                method: 'GET',
                extraParams: {},
                headers: {
                    'Accept': 'application/json'
                },
                reader: {
                    type: 'json',
                    rootProperty: 'list',
                    totalProperty: 'total'
                }
            }
        }
    }
});
