import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void ShowAll(SortedArrayList event) throws IOException{
		

		for(Object obj : event){
			System.out.println(obj);
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		SortedArrayList<Event> event = new SortedArrayList();
		SortedArrayList<Guest> guest = new SortedArrayList();
		
		
		In file = new In("data.txt");
		String data[] = file.readAllStrings();
//		System.out.println(data.length);
		int numOfEvents = Integer.parseInt(data[0]);
		for (int i = 0; i < numOfEvents; i++){
			int n = i * 2 + 1;
			String eventName = data[n];
			int allTicket = Integer.parseInt(data[n+1]);
//			System.out.println(eventName);
//			System.out.println(allTicket);
			Event e = new Event(eventName, allTicket, allTicket);
			event.insert(e, event);
//			System.out.println();
//			for(int j = 0; j< event.size();j++){
//				System.out.println();
//				System.out.println(event.get(j));
//			}
		}
		int numOfGuests = Integer.parseInt(data[numOfEvents * 2 + 3]);
		
		for (int i = 0; i < numOfGuests; i++){
			int n = i * 7 + numOfEvents * 2 + 4;
			String guestName = data[n];
			String event1 = null, event2 = null, event3 = null;

			int ticket1 = 0, ticket2 = 0, ticket3 = 0;
//			System.out.println(data[n+2]);
			if(data[n+2] == "\n"){
				event1 = data[n+1];
				ticket1 = Integer.parseInt(data[n+2]);
			}
			if(data[n+4] == "\n"){
				event1 = data[n+3];
				ticket2 = Integer.parseInt(data[n+4]);
			}
			if(data[n+6] == "\n"){
				event1 = data[n+5];
				ticket3 = Integer.parseInt(data[n+6]);
			}
			Guest g = new Guest(guestName, event1, event2,
					event3, ticket1, ticket2, ticket3);
			guest.add(g);
		}
		
		
		while(true){
			System.out.println(" ========================== ");

			System.out.println(" f - to finish running the program.");
			System.out.println(" e - to display on the screen the information about all the events. ");
			System.out.println(" c - to display on the screen the information about all the clients. ");
			System.out.println(" b - to update the stored data when tickets are bought by one of the registered clients. ");
			System.out.println(" r - to update the stored data when a registered client cancels/returns tickets. ");
			
			System.out.println(" ========================== ");
			
			
			String chose = Stdin.readString();
			if (chose.equals("f")){
				break;
			}
			else if(chose.equals("e")){
				ShowAll(event);
			}
			else if(chose.equals("c")){
				ShowAll(guest);
			}
			else if(chose.equals("b")){
				Stdin.readLine();
				System.out.println("Please Input Client Name:");
				String red = Stdin.readLine();
				System.out.println("Please Input Event Name:");
				
				String yed = Stdin.readLine();
				System.out.println("How many tickets to buy:");
				int blu = Stdin.readInt();
				
				boolean find = false;
				boolean enough = true;
				for(Guest g : guest){
					
					if(red.equals(g.getName())){
						for(Event e : event){
							if (yed.equals(e.getName())){
								if(e.buyTicket(yed, blu)){
									find = true;
								}
								g.buyTicket(yed, blu);
							}
						}
						if(!find){
							System.out.println("No such Event!");
						}
					}
				}
				
				
				Out out = new Out("data.txt");
				out.println(numOfEvents);
				for(Event e : event){
					out.println(e.getName());
					out.println(e.getLeft());
				}
				
				out.println();
				out.println();
				out.println(numOfGuests);
				for(Guest g : guest){
					out.println(g.getName());
					String[][] events = g.getEvents();
					
					if(events[0][0] == null){
						out.println();
					}
					else{
						out.println(events[0][0]);	
					}
					out.println(events[0][1]);
					if(events[1][0] == null){
						out.println();
					}
					else{
						out.println(events[1][0]);	
					}
					out.println(events[1][1]);
					if(events[2][0] == null){
						out.println();
					}
					else{
						out.println(events[2][0]);	
					}
					out.println(events[2][1]);
				}
			
			}
			
			else if(chose.equals("r")){
				Stdin.readLine();
				System.out.println("Please Input Client Name:");
				String red = Stdin.readLine();
				System.out.println("Please Input Event Name:");
				
				String yed = Stdin.readLine();
				System.out.println("How many tickets to cancel:");
				int blu = Stdin.readInt();
				
				boolean find = false;
				boolean enough = true;
				for(Guest g : guest){
					
					if(red.equals(g.getName())){
						for(Event e : event){
							if (yed.equals(e.getName())){
								if(e.buyTicket(yed, 0 - blu)){
									find = true;
								}
								g.returnTicket(yed, blu);
							}
						}
						if(!find){
							System.out.println("No such Event!");
						}
					}
				}
				
				
				Out out = new Out("data.txt");
				out.println(numOfEvents);
				for(Event e : event){
					out.println(e.getName());
					out.println(e.getLeft());
				}
				
				out.println();
				out.println();
				out.println(numOfGuests);
				for(Guest g : guest){
					out.println(g.getName());
					String[][] events = g.getEvents();
					
					if(events[0][0] == null){
						out.println();
					}
					else{
						out.println(events[0][0]);	
					}
					out.println(events[0][1]);
					if(events[1][0] == null){
						out.println();
					}
					else{
						out.println(events[1][0]);	
					}
					out.println(events[1][1]);
					if(events[2][0] == null){
						out.println();
					}
					else{
						out.println(events[2][0]);	
					}
					out.println(events[2][1]);
				}
				out.println();
				out.println();
				out.println();
			
			}
			

			
			
			
		}
		
		
	}
}
