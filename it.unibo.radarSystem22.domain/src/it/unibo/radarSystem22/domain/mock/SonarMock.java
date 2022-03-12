package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.utils.Distance;

public class SonarMock implements ISonar{
	private Distance dist;
	private boolean state;
	
	public SonarMock() {
		this.dist=new Distance(0);
	}
	
	@Override
	public void activate() {
		int i=0, d=0;
		
		this.state = true;
		for(i=90; i>=0 ;i--) {
			this.dist = new Distance(i);
			System.out.println("Distance: "+this.dist.getVal());
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void deactivate() {
		this.state = false;	
	}

	@Override
	public IDistance getDistance() {
		return this.dist;
	}

	@Override
	public boolean isActive() {
		return this.state;
	}

}
