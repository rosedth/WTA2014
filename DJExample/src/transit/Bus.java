package transit;

import java.util.ArrayList;

public class Bus {
	private int number;
	private String desc;
	private int capacity;
	private ArrayList<Person> passengers;
	
	public Bus(int number, String desc, int capacity, ArrayList<Person> passengers) {
		super();
		this.number = number;
		this.desc = desc;
		this.capacity = capacity;
		this.passengers = passengers;
	}

	public Bus(int number, String desc, int capacity) {
		super();
		this.number = number;
		this.desc = desc;
		this.capacity = capacity;
		this.passengers = new ArrayList<Person>();
	}
	
	public void addPassenger(Person p){
		this.passengers.add(p);
	}
	
	public void addAllPassengers(ArrayList<Person> p){
		this.passengers.addAll(p);
	}

}
