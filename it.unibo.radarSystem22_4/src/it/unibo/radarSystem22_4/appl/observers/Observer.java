package it.unibo.radarSystem22_4.appl.observers;

public interface Observer {
	
	public void subscribe(Observable obs);
	
	public void unsubscribe(Observable obs);
	
	public void receive(Object content);
}