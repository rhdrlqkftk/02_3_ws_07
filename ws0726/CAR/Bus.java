package hw;

public class Bus extends Car {

	private int seat;  

	public Bus() {
		this("", "", 0 ,0);
	}

	public Bus(String num, String model, int price, int seat) 
	{
		super(num, model , price);
		this.seat= seat; 
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return  "¹ö½º " + super.toString() + " ÁÂ¼®¼ö : "+seat + "]";
	}


}
