package com.tistory.hskimsky.model;

import com.tistory.hskimsky.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 회사
 * <p>
 * 회사명<br/>
 * 종목코드<br/>
 * 업종<br/>
 * 주요제품<br/>
 * 상장일<br/>
 * 결산월<br/>
 * 대표자명<br/>
 * 홈페이지<br/>
 * 지역
 *
 * @author Haneul, Kim
 */
public class Company {

    private String name;

    private String code;

    private String type;

    private String product;

    private String registDate;

    private String settlementMonth;

    private String ceoName;

    private String homepage;

    private String location;

    public Company() {

    }

    public Company(String name, String code, String type, String product, String registDate, String settlementMonth, String ceoName, String homepage, String location) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.product = product;
        this.registDate = registDate;
        this.settlementMonth = settlementMonth;
        this.ceoName = ceoName;
        this.homepage = homepage;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getSettlementMonth() {
        return settlementMonth;
    }

    public void setSettlementMonth(String settlementMonth) {
        this.settlementMonth = settlementMonth;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", product='" + product + '\'' +
                ", registDate='" + registDate + '\'' +
                ", settlementMonth='" + settlementMonth + '\'' +
                ", ceoName='" + ceoName + '\'' +
                ", homepage='" + homepage + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String makeString() {
        List<String> columns = new ArrayList<>();

        columns.add(this.name);
        columns.add(this.code);
        columns.add(this.type);
        columns.add(this.product);
        columns.add(this.registDate);
        columns.add(this.settlementMonth);
        columns.add(this.ceoName);
        columns.add(this.homepage);
        columns.add(this.location);

        return StringUtils.join(columns, Constants.Delimiters.HAT.getDelimiter());
    }
}
