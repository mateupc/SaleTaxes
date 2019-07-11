package saleTaxes.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductOrder {
	
	private String name;
	private BigInteger amount;
	private BigDecimal price;
	
	public ProductOrder() {}
	
	public ProductOrder(String name, BigInteger amount, BigDecimal price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
