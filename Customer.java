public class Customer{
	private int custId;

	public Customer(){
		custId = -1;
	}

	public Customer(int id){
		custId = id;
	}

	public void setCustId(int id){
		custId = id;
	}

	public int getCustId(){
		return custId;
	}
}
