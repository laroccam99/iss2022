package it.unibo.radarSystem22_4.appl.observers;

import java.io.PrintStream;
import java.util.HashMap;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class LedObserver implements Observer{
	private HashMap<String, Observable> subToList;

	@Override
	public void subscribe(Observable obs) {
		subToList.put(obs.toString(), obs);
		obs.addSubscriber(this);
	}

	@Override
	public void unsubscribe(Observable obs) {
		subToList.remove(obs.toString(), obs);
		obs.removeSubscriber(this);	
	}

	@Override
	public void receive(Object content) {
		PrintStream ps = System.out;
		IDistance dist = (IDistance) content;	
		ps.println(dist.getVal());	
	}
	
}
