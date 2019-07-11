package saleTaxes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import saleTaxes.helper.TaxCalculator;
import saleTaxes.model.ProductOrder;

class TaxCalculatorTest {
	
	TaxCalculator calculator;
	
	@Test
	void addRoundedBigDecimalTest() {
		calculator = new TaxCalculator();
		assertEquals(new BigDecimal("1.08"), calculator.addRoundedBigDecimal(new BigDecimal("1.03"), new BigDecimal("0.05")));
		assertEquals(new BigDecimal("1.07"), calculator.addRoundedBigDecimal(new BigDecimal("1.051"), new BigDecimal("0.02")));
		assertEquals(new BigDecimal("1.05"), calculator.addRoundedBigDecimal(new BigDecimal("1.05"), new BigDecimal("0.00")));
		assertEquals(new BigDecimal("0.00"), calculator.addRoundedBigDecimal(new BigDecimal("0"), new BigDecimal("0.00")));
	}
	
	@Test
	void calculateTaxTest() {
		ProductOrder order = new ProductOrder();
		calculator = new TaxCalculator();
		order.setAmount(BigInteger.ONE);
		order.setName("book");
		order.setPrice(new BigDecimal("10"));
		assertEquals(BigDecimal.ZERO, calculator.calculateTax(order));
		order.setName("a product");
		assertEquals(new BigDecimal("1.0"), calculator.calculateTax(order));
		order.setName("a imported product");
		assertEquals(new BigDecimal("1.50"), calculator.calculateTax(order));
	}

}
