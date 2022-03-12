package it.unibo.radarSystem22.domain;

import org.junit.Test;

import it.unibo.radarSystem22.domain.mock.SonarMock;
import it.unibo.radarSystem22.domain.utils.Distance;

public class testSonarMock {
	
	@Test
	public void testSonarMock1() {
		SonarMock sm = new SonarMock();
		sm.activate();
		Distance d0 = new Distance(0);
		assert(sm.getDistance().getVal() == d0.getVal());
	}

	@Test
	public void testIsActiveTrue() {
		SonarMock sm = new SonarMock();
		sm.activate();
		assert(sm.isActive());
	}

	@Test
	public void testIsActiveFalse() {
		SonarMock sm = new SonarMock();
		sm.activate();
		sm.deactivate();
		assert(!sm.isActive());
	}

}
