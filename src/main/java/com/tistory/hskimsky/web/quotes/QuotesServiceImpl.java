package com.tistory.hskimsky.web.quotes;

import com.tistory.hskimsky.model.Quote;
import org.springframework.stereotype.Service;

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

    // TODO
    /*@Autowired
    private HTable htable;*/

    @Override
    public List<Quote> getQuotes(Map<String, Object> params) {
        return dummyQuotes();// FIXME
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
