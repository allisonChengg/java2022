import java.util.*;

public class practice {
	
	public static void main(String[] args) {
		
		public static final double UNIT_PRICE = 0.35;
		Scanner scanner = new Scanner(System.in);
		
		int quantity;
		String response;
	
		do {

			do {
				System.out.println("Enter quantity: ");
				quantity = scanner.nextInt();
			
				if (quantity % 25 != 0) {
					System.out.println("Stocks can be bought only in packs of 25.");
				}
			
			} while(quantity % 25 != 0);
		
			double total = UNIT_PRICE * quantity;
			System.out.println("You have ordered " + quantity + " stocks -- $" + total);
		
		
			System.out.println("Next Customer (y/n): ");
			response = scanner.nextLine();
		
		} while(response.equals("y"));
		
			System.out.println("Transactions Complete.");
	}

}
