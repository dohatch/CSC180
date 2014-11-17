package two;

import java.util.LinkedList;
import java.util.Queue;

public class EventLoop {
	Queue<State> toDo = new LinkedList<State>();
	Queue<State> done = new LinkedList<State>();
	
	
	void begin() {
		init();
		while(true) {
			toDo.offer(new DefaultState());
			while(!toDo.isEmpty()) {
				execute();
			}
			switchQueues();
		}
	}
	
	public boolean execute() {
		if(!toDo.isEmpty()) {	
			State newEvent = toDo.poll();
			newEvent.run();
			toDo.offer(newEvent.next());
			done.offer(newEvent);
			return true;
		}
		return false;
	}
	
	public void switchQueues() {
		Queue<State> temp = new LinkedList<State>();
		temp = done;
		done.removeAll(done);
		toDo = temp;
		temp.removeAll(temp);
	}
	
	public void init() {		
		toDo.add(new DefaultState());
	}
}
