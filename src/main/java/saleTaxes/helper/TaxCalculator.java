package saleTaxes.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import saleTaxes.model.ProductOrder;

public class TaxCalculator {
	
	private static final String ADDITIONAL_TAX_KEY = "imported";
	private static final String[] NO_TAX_KEY = {"book","books","chocolate","chocolates","pill","pills"};
	
	
	/**
	 * @param ProductOrder to be taxed
	 * This method receives a productOrder object and following 
	 * the rules described in the problem calculate the tax of that order 
	 * */
	public BigDecimal calculateTax(ProductOrder order) {
		BigDecimal tax = BigDecimal.ZERO;
		if(order.getName().contains(ADDITIONAL_TAX_KEY)) {
			tax = tax.add(order.getPrice().multiply(new BigDecimal("0.05")));
		}
		if(stringContainsItemFromList(order.getName(), NO_TAX_KEY)) {
			return tax;
		}
		return tax.add(order.getPrice().multiply(new BigDecimal("0.1")));
	}
	/**
	 * @param toTax is the number to be taxed, 
	 * @param tax is the tax to be applied in the number
	 * This method apply a given tax to a number and round the result up to the nearest 0.05
	 * @return the taxed number rounded up to the nearest 0.05
	 * */
	public BigDecimal addRoundedBigDecimal(BigDecimal toTax, BigDecimal tax) {
		return round(toTax.add(tax),new BigDecimal("0.005"),RoundingMode.HALF_UP);
	}
	
	
	private static boolean stringContainsItemFromList(String inputStr, String[] items) {
	    return Arrays.stream(items).parallel().anyMatch(inputStr::contains);
	}
	
	private static BigDecimal round(BigDecimal value, BigDecimal rounding,
            RoundingMode roundingMode) {
		return rounding.signum()==0 ? value :
	        (value.divide(rounding,0,roundingMode)).multiply(rounding).setScale(2);
	}
}
