package com.tistory.hskimsky.web.quotes;

import com.tistory.hskimsky.model.Quote;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description.
 *
 * @author Haneul, Kim
 */
@Service
public class QuotesServiceImpl implements QuotesService {

    private Logger logger = LoggerFactory.getLogger(QuotesServiceImpl.class);

    private static final String SEPARATOR = "^";

    @Autowired
    private Table table;

    @Override
    public List<Quote> getQuotes(Map<String, Object> params) throws IOException {
        String code = params.get("companyCode").toString();
        int dist_key = Integer.parseInt(code) % 3;
        long fromDateTimestamp = Long.parseLong(params.get("fromDate").toString());
        long toDateTimestamp = Long.parseLong(params.get("toDate").toString()) + 1;

        Get get = new Get((dist_key + SEPARATOR + code).getBytes()).
                addFamily("quote".getBytes()).
                setTimeRange(fromDateTimestamp, toDateTimestamp);

        List<Quote> quotes = new ArrayList<>();
        Quote quote = null;
        Result result = this.table.get(get);
        while (result.advance()) {
            Cell cell = result.current();
            logger.debug("cell = {}", cell);

            String date = new String(CellUtil.cloneQualifier(cell));
            // [start]^[high]^[low]^[finish]^[quantity]
            String[] values = new String(CellUtil.cloneValue(cell)).split("\\" + SEPARATOR, Integer.MAX_VALUE);

            quote = new Quote(code, date, values[0], values[1], values[2], values[3], values[4]);
            quotes.add(quote);
        }
        return quotes;
    }

    private List<Quote> dummyQuotes() {
        List<Quote> quotes = new ArrayList<>();
        Quote quote1 = new Quote("205100", "20170710", "5490", "5610", "5310", "5490", "2139551");
        Quote quote2 = new Quote("205100", "20170711", "5260", "5460", "5230", "5440", "1408792");
        Quote quote3 = new Quote("205100", "20170712", "5440", "5490", "5210", "5330", "1191494");
        Quote quote4 = new Quote("205100", "20170713", "5260", "5550", "5220", "5520", "1372054");
        Quote quote5 = new Quote("205100", "20170714", "5550", "5820", "5450", "5520", "2095064");
        quotes.add(quote1);
        quotes.add(quote2);
        quotes.add(quote3);
        quotes.add(quote4);
        quotes.add(quote5);
        return quotes;
    }
}
