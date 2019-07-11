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
		processSale(sale, mapper, calculator, words);
		
	}

	public static void processSale(Sale sale, ProductMapper mapper, TaxCalculator calculator, List<String> words) {
		words.forEach(word ->{
			ProductOrder order = mapper.getProductFromString(word);
			BigDecimal taxes = calculator.calculateTax(order);
			order.setPrice(calculator.addRoundedBigDecimal(order.getPrice(), taxes));
			sale.setTotalTaxes(calculator.addRoundedBigDecimal(sale.getTotalTaxes(), taxes));
			sale.setTotalSale(calculator.addRoundedBigDecimal(sale.getTotalSale(), order.getPrice()));
			sale.getOrders().add(order);
			System.out.printf("%d %s: %.2f\n",order.getAmount(), order.getName(), order.getPrice());
		});
		System.out.printf("Sales Taxes: %.2f\n", sale.getTotalTaxes());
		System.out.printf("Total: %.2f", sale.getTotalSale());
	}
	
	
}
