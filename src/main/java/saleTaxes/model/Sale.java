package saleTaxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Sale {

	List<ProductOrder> orders;
	BigDecimal totalTaxes;
	BigDecimal totalSale;
	
	public Sale() {
		this.orders = new ArrayList<ProductOrder>();
	}
	public List<ProductOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ProductOrder> orders) {
		this.orders = orders;
	}
	public BigDecimal getTotalTaxes() {
		return totalTaxes;
	}
	public void setTotalTaxes(BigDecimal totalTaxes) {
		this.totalTaxes = totalTaxes;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}
	
}
