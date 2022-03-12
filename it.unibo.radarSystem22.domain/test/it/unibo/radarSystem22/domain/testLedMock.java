package it.unibo.radarSystem22.domain;

import org.junit.Before;
import org.junit.Test;
import it.unibo.radarSystem22.domain.mock.LedMock;

public class testLedMock {
	@Before
	public void init() {
//		System.out.println("prova");
	}
	
	@Test
	public void testLedMock1() {
		LedMock ld = new LedMock();
		assert(ld.getState()==false);
	}
	
	@Test
	public void testLedMockON() {
		LedMock ld = new LedMock();
		ld.turnOn();
		assert(ld.getState()==true);
	}
	
	@Test
	public void testLedMockONErrato() {
		LedMock ld = new LedMock();
		ld.turnOn();
		assert(ld.getState()==false);
	}
	
	@Test
	public void testLedMockOFF() {
		LedMock ld = new LedMock();
		ld.turnOn();
		assert(ld.getState()==true);
		ld.turnOff();
		assert(ld.getState()==false);
	}
	

}
