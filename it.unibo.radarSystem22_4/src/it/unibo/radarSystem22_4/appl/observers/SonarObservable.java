package it.unibo.radarSystem22_4.appl.observers;

import java.util.LinkedList;
import it.unibo.radarSystem22.domain.interfaces.IDistance;

/*Il SonarObservable deve inviare informazioni 
 * a tutti componenti software interessati alla rilevazione dei valori di distanza;
 * il SonarObservable deve fornire valori di distanza 
 * solo quando questi si modificano in modo significativo;
 * 
 * I componenti interessati ai valori di distanza prodotti dal SonarObservable 
 * sono denominati Observer e possono risiedere 
 * sullo stesso nodo del SonarObservable (cioè sul RaspberryPi) 
 * o su un nodo remoto (ad esempio sul PC);
 * 
 * Il funzionamento del SonarObservable deve essere testato in modo automatizzato 
 * ponendo un ostacolo a distanza fissa DTESTING1 davanti ad esso, 
 * controllando che tutti gli Observers ricevano il valore DTESTING1. 
 * Dopo un qualche tempo, 
 * si modifica la posizione dell’ostacolo a una nuova distanza DTESTING2 
 * e si controlla che gli tutti gli Observers ricevano il valore DTESTING2
*/
public class SonarObservable implements Observable{
	private LinkedList<Observer> subscribers;
	
	@Override
	public void publish(Object content) {
		int i=0;
		for(i=0; i<subscribers.size();i++) {
			subscribers.get(i).receive((IDistance)content);
		}	
	}

	@Override
	public void addSubscriber(Observer ob) {
		subscribers.add(ob);	
	}

	@Override
	public void removeSubscriber(Observer ob) {
		subscribers.remove(ob);		
	}
}
