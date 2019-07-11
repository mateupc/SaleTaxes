package saleTaxes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import saleTaxes.helper.ProductMapper;
import saleTaxes.helper.SystemInputReader;
import saleTaxes.helper.TaxCalculator;
import saleTaxes.model.ProductOrder;
import saleTaxes.model.Sale;

public class MainApplication {

	public static void main(String[] args) { 
		Sale sale = new Sale();
		ProductMapper mapper = new ProductMapper();
		TaxCalculator calculator = new TaxCalculator();
		List<String> words = SystemInputReader.readWords(new Scanner(System.in));
		words.forEach(word ->{
			ProductOrder order = mapper.getProductFromString(word);		
			sale.setTotalTaxes(sale.getTotalTaxes().add(calculator.calculateTax(order)));
			sale.getOrders().add(order.set);
		});
	}

}
