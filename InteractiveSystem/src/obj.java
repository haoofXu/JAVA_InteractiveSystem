
public class obj {
	private String name;
}

class Event implements Comparable<Event>  {
	
	private String name;
	private int totalTicket;
	private int leftTicket;
	
	public Event(String name, int all, int left){
		this.name = name;
		this.totalTicket = all;
		this.leftTicket = left;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getTotal(){
		return this.totalTicket;
	}
	
	public int getLeft(){
		return this.leftTicket;
	}
	

	public boolean buyTicket(String name, int num){
		if(this.name.equals(name) && num <= this.leftTicket){
			this.leftTicket -= num;
			return true;
		}
		return false;
	}
	
	@Override
    public int compareTo(Event event) {
        if(this.name.equals(event.getName()))
            return this.name.compareTo(event.getName());
        
        return 0;
    }
	
	public String toString(){
		String name = this.name
				+ "  \tTicket: " + Integer.toString(this.totalTicket)
				+ "\tRemain:" + Integer.toString(this.leftTicket);
		return name;
	}
}


class Guest implements Comparable<Event>  {
	
	private String name;
	private String event1 = null;
	private String event2 = null;
	private String event3 = null;
	private int ticket1;
	private int ticket2;
	private int ticket3;
	
	public Guest(String name){
		this.name = name;
		this.event1 = null;
		this.event2 = null;
		this.event3 = null;
		this.ticket1 = 0;
		this.ticket2 = 0;
		this.ticket3 = 0;
	}

	public Guest(String name, String e1, String e2, String e3,
			int t1, int t2, int t3){
		this.name = name;
		this.event1 = e1;
		this.event2 = e2;
		this.event3 = e3;
		this.ticket1 = t1;
		this.ticket2 = t2;
		this.ticket3 = t3;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String[][] getEvents(){
		String[][] events = new String[3][2];
		events[0][0] = this.event1;
		events[1][0] = this.event2;
		events[2][0] = this.event3;
		events[0][1] = Integer.toString(this.ticket1);
		events[1][1] = Integer.toString(this.ticket2);
		events[2][1] = Integer.toString(this.ticket3);
		
		return events;
	}
	
	public void buyTicket(String name, int ticket){
//		System.out.print(this.event1);
		
		if(this.event1 == null){
//			System.out.println("2");
			this.event1 = name;
			this.ticket1 = ticket;
		}
		else if(this.event2 == null){
			this.event2 = name;
			this.ticket2 = ticket;
		}
		else if(this.event3 == null){
			this.event3 = name;
			this.ticket3 = ticket;
		}
	}
	
	public void returnTicket(String name, int ticket){
		System.out.print(this.event1);
		
		if(this.event1.equals(name)){
			this.ticket1 -= ticket;
		}
		else if(this.event2.equals(name)){
			this.ticket2 -= ticket;
		}
		else if(this.event3.equals(name)){
			this.ticket3 -= ticket;
		}
	}
	
	@Override
    public int compareTo(Event event) {
        if(this.name.equals(event.getName()))
            return this.name.compareTo(event.getName());
        
        return 0;
    }
	
	public String toString(){
		String name = this.name
				+ "\n\tEvent: \n\t" 
				+ this.event1 + "\t"
				+ Integer.toString(this.ticket1) + "\n\t"
				+ this.event2 + "\t"
				+ Integer.toString(this.ticket2) + "\n\t"
				+ this.event3 + "\t"
				+ Integer.toString(this.ticket3) + "\n";
		return name;
	}
}
