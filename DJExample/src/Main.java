import java.util.ArrayList;
import transit.Bus;
import transit.BusRoute;
import transit.BusStop;
import transit.Person;
import edu.neu.ccs.demeter.dj.ClassGraph;
import edu.neu.ccs.demeter.dj.Strategy;
import edu.neu.ccs.demeter.dj.TraversalGraph;
import edu.neu.ccs.demeter.dj.Visitor;

public class Main {
	public static void main(String[] args) {
		int id=0;
		ArrayList<Person> persons;
		ArrayList<Bus> buses=new ArrayList<Bus>();
		ArrayList<BusStop>stops=new ArrayList<BusStop>();
		char busStopName='A';
		ClassGraph cg = new ClassGraph("transit"); // constructed by reflection from
												   // the classes in the "transit" package
		// Constructing some objects
		for(int i=0;i<5;i++){
			// Creation of List of people waiting 
			persons=new ArrayList<Person>();		
			for (int j=0;j<5;j++){
				id++;
				Person p= new Person("Person "+(id));
				persons.add(p);
			}

			// Creation of Bus stop 
			busStopName+=i;
			BusStop stop= new BusStop("Bus stop "+ String.valueOf(busStopName), persons);
			stops.add(stop);
		}
		
		// Creation of Buses
		for(int k=0;k<4;k++){
			buses.add(new Bus(k, "Bus numero "+k, 60));
		}
		
		// Creation of Bus Route
		BusRoute route=new BusRoute("One bus route", stops, buses);
		
		// Specifying the strategy to traverse the ClassGraph object
		Strategy sg = new Strategy(
				"from transit.BusRoute through transit.BusStop to transit.Person");
		TraversalGraph tg = new TraversalGraph(sg, cg);

		// Implementing the Visitor object and its methods
		tg.traverse(route, new Visitor() {
			// methods to be executed when the traversal is about to start and when is finished
			public void start() { System.out.println("Scanning the state of a bus route");}
			public void finish() { System.out.println("end of the route scanning"); }
			
			// methods to be executed when(before/after) a BusStop instance is reached
			public void before(BusStop b) { System.out.println("On "+ b.getName()); }
			public void after(BusStop b)  { System.out.println("going to next bus stop"); }

			// methods to be executed when(before/after) a Person instance is reached
			public void after(Person p)  { System.out.println(p.getName()); }
		}); 
 
	}
}
