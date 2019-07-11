package saleTaxes.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import saleTaxes.model.Sale;

public class CustomWriter {

	private static void write(Path path, String toWrite) throws IOException {
		if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS))
		    Files.createFile(path);
		Files.write(path, toWrite.getBytes(),StandardOpenOption.APPEND);
	}
	
	public static void writeOutput(Path outPath, Sale sale) throws IOException {
		sale.getOrders().stream().forEach(order ->{
			try {
				write(outPath, String.format("%d %s: %.2f\n",order.getAmount(), order.getName(), order.getPrice()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		write(outPath, String.format("Sales Taxes: %.2f\n", sale.getTotalTaxes()));
		write(outPath, String.format("Total: %.2f", sale.getTotalSale()));
	}
}
