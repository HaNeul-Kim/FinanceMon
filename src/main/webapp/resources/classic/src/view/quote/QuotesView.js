Ext.define('FinanceMon.view.quote.QuotesView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.quotesList',

    requires: [
        'FinanceMon.view.quote.QuotesController',
        'FinanceMon.view.quote.QuotesModel'
    ],

    title: 'Quotes',
    controller: 'quotesController',
    viewModel: 'quotesModel',

    bind: {
        store: '{quotes}'
    },

    columns: [
        {text: 'Code', dataIndex: 'code', align: 'center', width: 100},
        {text: 'Date', dataIndex: 'date', align: 'center', width: 100},
        {text: '시가', dataIndex: 'start', align: 'center', flex: 1},
        {text: '최고', dataIndex: 'high', align: 'center', flex: 1},
        {text: '최저', dataIndex: 'low', align: 'center', flex: 1},
        {text: '종가', dataIndex: 'finish', align: 'center', flex: 1},
        {text: '거래량', dataIndex: 'quantity', align: 'center', flex: 1}
    ],

    listeners: {
        afterrender: 'onAfterrender'
    }
});
