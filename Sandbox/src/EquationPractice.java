import java.util.HashMap;
import java.util.Map;

public class EquationPractice {

	public static void main(String[] args) {

		HashMap<String, Double> sales = new HashMap<>();
		sales.put("January", 389.45);
		sales.put("February", 432.89);
		sales.put("March", 275.30);
		for (Map.Entry sale : sales.entrySet()) {
			System.out.println(sale.getKey() + ": " + sale.getValue());
		}
	}
		
	}

