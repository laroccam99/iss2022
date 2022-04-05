package it.unibo.radarSystem22_4.appl.observers;

public interface Observable {
	
	void publish(Object content);
	
	public void addSubscriber(Observer ob);
	
	public void removeSubscriber(Observer ob);
}