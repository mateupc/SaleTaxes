package saleTaxes;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.List;

import saleTaxes.helper.ProductMapper;
import saleTaxes.helper.CustomReader;
import saleTaxes.helper.CustomWriter;
import saleTaxes.helper.TaxCalculator;
import saleTaxes.model.ProductOrder;
import saleTaxes.model.Sale;

public class MainApplication {

	public static void main(String[] args) { 
		Sale sale = new Sale();
		String inputFilePath = "config/Input 1.txt";
		String outFilePath = "config/Output 1.txt";
		ProductMapper mapper = new ProductMapper();
		TaxCalculator calculator = new TaxCalculator();
		List<String> words;
		try {
			words = CustomReader.readLines(Paths.get(inputFilePath));
			processSale(sale, mapper, calculator, words);
			CustomWriter.writeOutput(Paths.get(outFilePath),sale);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void processSale(Sale sale, ProductMapper mapper, TaxCalculator calculator, List<String> words) {
		words.forEach(word ->{
			ProductOrder order = mapper.getProductFromString(word);
			BigDecimal taxes = calculator.calculateTax(order);
			order.setPrice(calculator.addRoundedBigDecimal(order.getPrice(), taxes));
			sale.setTotalTaxes(calculator.addRoundedBigDecimal(sale.getTotalTaxes(), taxes));
			sale.setTotalSale(calculator.addRoundedBigDecimal(sale.getTotalSale(), order.getPrice()));
			sale.getOrders().add(order);
		});
	}
	

	
}
