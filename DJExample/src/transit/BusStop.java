package transit;

import java.util.ArrayList;

public class BusStop {
	private String name;
	private ArrayList<Person> waiting;
	
	public BusStop(String name){
		this.name=name;
		this.waiting=new ArrayList<Person>();
	}
	
	public BusStop(String name, ArrayList<Person> persons){
		this.name=name;
		this.waiting=persons;
	}
	
	public void addPerson(Person p){
		this.waiting.add(p);
	}
	
	public void addAllPersons(ArrayList<Person> p){
		this.waiting.addAll(p);
	}
	
	public String getName(){
		return this.name;
	}
}
