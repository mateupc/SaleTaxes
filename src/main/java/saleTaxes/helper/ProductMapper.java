package saleTaxes.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import saleTaxes.exception.InvalidArgumentException;
import saleTaxes.model.ProductOrder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class ProductMapper {

	private static final String FUCNTION_REGEX = "^(\\d) ([a-zA-Z0-9_ ]*)at (\\d+.[0-9]{2})$";
	
	public ProductOrder getProductFromString(String input) throws InvalidArgumentException, 
	PatternSyntaxException, IllegalArgumentException{
		Pattern linePattern = Pattern.compile(FUCNTION_REGEX);

		if(Optional.ofNullable(input).isPresent()) {
			Matcher functionMatcher = linePattern.matcher(input);
			if(functionMatcher.find()) {
				ProductOrder order = new ProductOrder();
				BigInteger amount = new BigInteger(functionMatcher.group(1));
				String name = functionMatcher.group(2);
				BigDecimal price = new BigDecimal(functionMatcher.group(3));
				if(amount.signum()<=0) {
					throw new InvalidArgumentException("Amount needs to be bigger than zero");
				}
				order.setAmount(amount);
				order.setName(name);
				order.setPrice(price);
				return order;
			}
			else {
				throw new PatternSyntaxException("Function not mach the expression", FUCNTION_REGEX, -1);
			}
		}else{
			throw new IllegalArgumentException("Input must not be null");
		}
	}
	
}
