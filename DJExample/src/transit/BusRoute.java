package transit;

import java.util.ArrayList;

public class BusRoute {
	private String name;
	private ArrayList<BusStop> busStops;
	private ArrayList<Bus> buses;
	
	public BusRoute(String name){
		this.name=name;
		this.busStops=new ArrayList<BusStop>();
		this.buses= new ArrayList<Bus>();
	}
	
	public BusRoute(String name, ArrayList<BusStop> stops, ArrayList<Bus> buses){
		this.name=name;
		this.busStops=stops;
		this.buses=buses;
	}
	
	public void addBusStop(BusStop b){
		this.busStops.add(b);
	}
	
	public void addAllBusStops(ArrayList<BusStop> b){
		this.busStops.addAll(b);
	}
}
