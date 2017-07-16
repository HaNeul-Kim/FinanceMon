package com.tistory.hskimsky.web.quotes;

import com.tistory.hskimsky.model.Quote;

import java.util.List;
import java.util.Map;

/**
 * description.
 *
 * @author Haneul, Kim
 */
public interface QuotesService {

    List<Quote> getQuotes(Map<String, Object> params);
}
