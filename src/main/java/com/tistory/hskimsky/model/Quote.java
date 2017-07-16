package com.tistory.hskimsky.model;

import com.tistory.hskimsky.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 시세
 * <p>
 * 일자<br/>
 * 시가<br/>
 * 고가<br/>
 * 저가<br/>
 * 종가<br/>
 * 거래량
 *
 * @author Haneul, Kim
 */
public class Quote {

    private String code;

    private String date;

    private String start;

    private String high;

    private String low;

    private String finish;

    private String quantity;

    public Quote() {
    }

    public Quote(String code, String date, String start, String high, String low, String finish, String quantity) {
        this.code = code;
        this.date = date;
        this.start = start;
        this.high = high;
        this.low = low;
        this.finish = finish;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", start='" + start + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", finish='" + finish + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public String makeString() {
        List<String> columns = new ArrayList<>();

        columns.add(this.code);
        columns.add(this.date);
        columns.add(this.start);
        columns.add(this.high);
        columns.add(this.low);
        columns.add(this.finish);
        columns.add(this.quantity);

        return StringUtils.join(columns, Constants.Delimiters.HAT.getDelimiter());
    }

    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();

        map.put("code", this.code);
        map.put("date", this.date);
        map.put("start", Integer.parseInt(this.start));
        map.put("high", Integer.parseInt(this.high));
        map.put("low", Integer.parseInt(this.low));
        map.put("finish", Integer.parseInt(this.finish));
        map.put("quantity", Long.parseLong(this.quantity));

        return map;
    }
}
