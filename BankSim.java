import java.util.*;

public class BankSim{
	private Queue<Customer> customerWaitQueue;
	private Queue<Customer> customerServeQueue;

	private int    numberOfCustomers   ;
	private double queueTime           ;
	private double operationTime       ;
	private double totalQueueTime      ;
	private double totalOperationTime  ;

	public BankSim(){
		customerWaitQueue      = new LinkedList<Customer>();
		customerServeQueue     = new LinkedList<Customer>();

		numberOfCustomers       = 0;
		queueTime               = 1;
		operationTime           = 1;
		totalQueueTime          = 0;
		totalOperationTime      = 0;
	}

	public void timeDisplay() {
		System.out.println("Arrival time between customer: " + queueTime);
		System.out.println("Operation time for one customer: " + operationTime);
	}

	public void setQueueTime(double t){
		queueTime = t;
	}

	public void setOperationTime(double t){
		operationTime = t;
	}

	public double getQueueTime(){
		return queueTime;
	}

	public double getOperationTime(){
		return operationTime;
	}

	public double getAverageQueueTime(){
		if(numberOfCustomers > 0){
			return totalQueueTime/numberOfCustomers;
		}
		return 0;
	}

	public double getAverageOperationTime(){
		if(numberOfCustomers > 0){
			return totalOperationTime/numberOfCustomers;
		}
		return 0;
	}

	public int getNumberOfCustomers(){
		return numberOfCustomers;
	}

	public void addCustomerToWaitQueue(Customer c){
		c.setCustId(numberOfCustomers);
		customerWaitQueue.add(c);
		numberOfCustomers += 1;
		totalQueueTime += queueTime;
	}

	public Customer getCustomerFromWaitQueue(){
		return customerWaitQueue.poll();
	}

	public int removeCustomerFromWaitQueue(int id){
		for(Iterator<Customer> iter = customerWaitQueue.iterator(); iter.hasNext();){
			Customer c = iter.next();
			if(c.getCustId() == id){
				iter.remove();
				return 0;
			}
		}
		System.out.println("There is no customer with ID: " + id + " in the wait queue");
		return 1;
	}

	public void addCustomerToServeQueue(Customer c){
		customerServeQueue.add(c);
		totalOperationTime += operationTime;
	}

	public Customer getCustomerFromServeQueue(){
		return customerServeQueue.poll();
	}

	public int removeCustomerFromServeQueue(int id){
		for(Iterator<Customer> iter = customerServeQueue.iterator(); iter.hasNext();){
			Customer c = iter.next();
			if(c.getCustId() == id){
				iter.remove();
			}
			return 0;
		}
		System.out.println("There is no customer with ID: " + id + " in the serve queue.");
		return 1;
	}


	public void clearWaitQueue(){
		customerWaitQueue.clear();
	}

	public void clearServeQueue(){
		customerServeQueue.clear();
	}

	public void clearAllQueue(){
		clearWaitQueue();
		clearServeQueue();
	}

	public void printWaitQueue(){
		System.out.print("Wait Queue: [");
		for(Iterator<Customer> iter = customerWaitQueue.iterator(); iter.hasNext();){
			Customer c = iter.next();
			System.out.print(c.getCustId() + ", ");
		}
		System.out.print("]\n");
	}

	public void printServeQueue(){
		System.out.print("Serve Queue: [");
		for(Iterator<Customer> iter = customerServeQueue.iterator(); iter.hasNext();){
			Customer c = iter.next();
			System.out.print(c.getCustId() + ", ");
		}
		System.out.print("]\n");
	}

	public void printSummary(){
		System.out.format("Total Number of Customers: %d%n", numberOfCustomers);
		System.out.format("Total Queue Time Taken: %f%n", totalQueueTime);
		System.out.format("Total Operation Time Taken: %f%n", totalOperationTime);
		System.out.format("Average Queue Time: %f%n", getAverageQueueTime());
		System.out.format("Average Operation Time: %f%n", getAverageOperationTime());
	}
}
