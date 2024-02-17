package vw.mohak.vwF2_micro_currencyconversion.entity;

import java.math.BigDecimal;

//It's not an actual entity......
//This has the same fields as CurrencyExchange + some additional fields
public class CurrencyConversion {
	
	//Fields same as CurrencyExchange
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String port;

	
	//new added fields 
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	
	//===============================================================================================
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, String port,
			BigDecimal quantity, BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	//====================================================================================================

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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	//=================================================================================================

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", port=" + port + ", quantity=" + quantity + ", totalCalculatedAmount="
				+ totalCalculatedAmount + "]";
	}
	
	//=========================================================================================================
	
	

}
