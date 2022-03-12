package it.unibo.radarSystem22.domain.utils;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class Distance implements IDistance{
	int val;
		
	public Distance(int val) {
		this.val = val;
	}
	
	@Override
	public int getVal() {
		return val;
	}

}
