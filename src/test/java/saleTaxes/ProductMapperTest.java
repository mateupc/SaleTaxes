package saleTaxes;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.PatternSyntaxException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import saleTaxes.helper.ProductMapper;
import saleTaxes.model.ProductOrder;

class ProductMapperTest {
	
	ProductMapper mapper;
	
	@BeforeClass
	public void setup() {
		
	}
	
	@Test
	void getProducFromStringTestSuccess() {
		mapper = new ProductMapper();
		ProductOrder order =mapper.getProductFromString("1 book at 12.49");
		assertEquals("Not expected value",order.getAmount(), new BigInteger("1"));
		assertEquals("Not expected value",order.getName().trim(), "book");
		assertEquals("Not expected value",order.getPrice(), new BigDecimal("12.49"));
	}
	
	@Test
	void getProducFromStringtestFailNotFollowThePathern() {
		mapper = new ProductMapper();
		try {
			mapper.getProductFromString("1 book 12.49");
		} 
		catch(PatternSyntaxException ex) {
			assertThat(ex.getMessage(),containsString( "Function not mach the expression"));
		}
	}
	
	@Test
	void getProducFromStringtestFailArgumentNotPresent() {
		mapper = new ProductMapper();
		try {
			mapper.getProductFromString(null);
		} 
		catch(IllegalArgumentException ex) {
			assertThat(ex.getMessage(),containsString( "Input must not be null"));
		}
	}

}
