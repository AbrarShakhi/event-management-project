import java.util.Scanner;

public class ProcessCheckout {
	Scanner input;
	String eventType, color;
	boolean music;
	int eventFee, musicFee, helperFee, foodFee, total, waiter;

	public ProcessCheckout() {
	}

	public void Choice() {
		System.out.println("Event type (Birthday or Wedding):");
		Scanner input = new Scanner(System.in);
		eventType = input.nextLine(); // Read user input
		if (eventType == "Birthday") {
			eventFee = 30000;
		} else {
			eventFee = 100000;
		}

		System.out.println("theme color :");
		color = input.nextLine();

		System.out.println("Do you like to take music(true or false)? :");
		music = input.nextBoolean(); // Read user input
		
		if (music == true) {
			musicFee = 10000;
		} else {
			musicFee = 0;
		}

		System.out.println("How many waiters do you need? :");
		waiter = input.nextInt(); // Read user input
		helperFee = waiter * 2000;

		/*
		 * system.out.println("Enter the number of guest: ");
		 * int guest = input.nextInt();
		 * int foodItems = inside.Food; // tring to call the food to get the number of
		 * food user wants.
		 * foodFee = guest*foodItems;
		 */
	}

	public void Calculation() {
		total = eventFee + musicFee + helperFee;// + foodFee;
	}

	public void Reports() {
		System.out.println(eventType + ":          " + eventFee);
		System.out.println("Theme Color:        " + color);
		System.out.println("Took music :        " + musicFee);
		System.out.println(waiter + " waiters :      " + helperFee);
		// system.out.println("Food : " + foodFee);
		System.out.println("Subtotal :          " + total);

	}

	public static void main(String[] args) {
		ProcessCheckout call = new ProcessCheckout();
		call.Choice();
		call.Calculation();
		call.Reports();
		call.input.close();
	}
}
