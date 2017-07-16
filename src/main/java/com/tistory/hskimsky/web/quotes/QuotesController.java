package com.tistory.hskimsky.web.quotes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.hskimsky.model.Quote;
import com.tistory.hskimsky.rest.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * description.
 *
 * @author Haneul, Kim
 */
@RestController
@RequestMapping("/quotes")
public class QuotesController {

    private Logger logger = LoggerFactory.getLogger(QuotesController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private QuotesService service;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response get(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        logger.debug("params = {}", params);
        Response response = new Response();

        List<Quote> quotes = service.getQuotes(params);
        logger.debug("quotes = {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(quotes));
        response.getList().addAll(quotes);
        response.setSuccess(true);
        response.setTotal(quotes.size());

        return response;
    }
}
