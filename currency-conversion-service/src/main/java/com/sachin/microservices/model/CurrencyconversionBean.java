package com.sachin.microservices.model;

import java.math.BigDecimal;

public class CurrencyconversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private int port;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }
    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
    public BigDecimal getquantity() {
        return quantity;
    }
    public void setquantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public CurrencyconversionBean(){
	
    }
    public CurrencyconversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
	    BigDecimal totalAmount, int port) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.conversionMultiple = conversionMultiple;
	this.quantity = quantity;
	this.totalAmount = totalAmount;
	this.port = port;
    }
    
}
