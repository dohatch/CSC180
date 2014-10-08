package one;



import java.util.LinkedList;
import java.util.Queue;

public class EventLoop {
	Queue<Event> toDo = new LinkedList<Event>();
	Queue<Event> done = new LinkedList<Event>();
	
	
	void begin() {
		init();
		while(true) {
			
			while(!toDo.isEmpty()) {
				execute();
			}
			
			switchQueues();
		}
	}
	
	public boolean execute() {
		if(!toDo.isEmpty()) {	
			Event newEvent = toDo.poll();
			newEvent.run();
			toDo.offer(newEvent.next());
			done.offer(newEvent);
			return true;
		}
		return false;
	}
	
	public void switchQueues() {
		Queue<Event> temp = new LinkedList<Event>();
		temp = done;
		done.removeAll(done);
		toDo = temp;
		temp.removeAll(temp);
	}
	
	public void init() {		
		toDo.add(new DefaultState());
		toDo.add(new DefaultState());
		toDo.add(new DefaultState());
	}
}
