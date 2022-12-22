import java.util.Scanner;

public class MyBank{
	public static int getChoice(){
		int choice = 20;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("\nSelect your option:");
			System.out.println("1.Add Customer To Wait Queue");
			System.out.println("2.Remove Customer From Wait Queue and Add To Serve Queue");
			System.out.println("3.Remove Customer From Serve Queue");
			System.out.println("4.Kick Customer From Wait Queue By ID");
			System.out.println("5.Kick Customer From Serve Queue By ID");
			System.out.println("6.Set Queue Time");
			System.out.println("7.Set Serve Time");
			System.out.println("8.Clear All Queues");
			System.out.println("9.Clear Wait Queue");
			System.out.println("10.Clear Serve Queue");
			System.out.println("11.Print Summary");
			System.out.println("0.Exit");

			choice = scan.nextInt();
		}while(choice < 0 && choice > 6);

		return choice;
	}

	public static void main(String[] args){
		int choice, t;
		Customer c;
		Scanner inputScanner = new Scanner(System.in);
		BankSim bank = new BankSim();

		while(true){
			bank.printWaitQueue();
			bank.printServeQueue();

			bank.timeDisplay();
			choice = getChoice();
			switch(choice){
				case 0:
					System.out.println("###YOU EXIT THIS PROGRAM###");
					System.exit(0);
				case 1:
					c = new Customer(bank.getNumberOfCustomers());
					System.out.println("Your ID is: " + c.getCustId());
					bank.addCustomerToWaitQueue(c);
					break;
				case 2:
					c = bank.getCustomerFromWaitQueue();
					if(c != null){
						bank.addCustomerToServeQueue(c);
					}else{
						System.out.println("There is no customer in the wait queue");
					}
					break;
				case 3:
					c = bank.getCustomerFromServeQueue();
					if(c == null){
						System.out.println("There is no customer in the serve queue.");
					}
					break;

				case 4:
					System.out.println("Type the ID of the Customer you want to remove from the Wait Queue: ");
					t = inputScanner.nextInt();
					if(bank.removeCustomerFromWaitQueue(t) == 0){
						System.out.println("The customer with ID: " + t + " has been removed from the Wait Queue.");
					}
					break;
				case 5:
					System.out.println("Type the ID of the Customer you want to remove from the Serve Queue: ");
					t = inputScanner.nextInt();
					if(bank.removeCustomerFromServeQueue(t) == 0){
						System.out.println("The customer with ID: " + t + " has been removed from the Serve Queue.");
					}
					break;
				case 6:
					System.out.println("Type the number of time you want to set for qeue:");
					t = inputScanner.nextInt();
					bank.setQueueTime(t);
					break;
				case 7:
					System.out.println("Type the number of time you want for the operation:");
					t = inputScanner.nextInt();
					bank.setOperationTime(t);
					break;
				case 8:
					bank.clearAllQueue();
					break;
				case 9:
					bank.clearWaitQueue();
					System.out.println("Waiting Queue is cleared!");
					break;
				case 10:
					bank.clearServeQueue();
					System.out.println("Serve Queue is cleared!");
					break;
				case 11:
					bank.printSummary();
					break;
				default:
					break;
			}
			System.out.println("##################################");
		}
	}
}
