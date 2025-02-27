package conway;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import conway.devices.ConwayInputMock;

//By default, JUnit comes with a bundled copy of hamcrest-core

public class conway25JavaTest {
private static ConwayInputMock cim;
private Life life;

	@BeforeClass
	public static void setup() {
		System.out.println("setup");
    	//configureTheSystem
        Life life           = new Life( 3,3 );
        LifeController cc   = new LifeController(life);   
        cim = new ConwayInputMock(cc,life);		
	}
	
	@After
	public void down() {
		System.out.println("down");
	}
	
	@Test
	public void test1() {
		System.out.println("ok test1");
		this.life= new Life(3, 3);
		
		life.switchCellState(1, 0);
		life.switchCellState(1, 1);
		life.switchCellState(1, 2);
		
		life.computeNextGen();
		
		Grid newGrid = new Grid(3, 3);
		newGrid.setCellState(0, 1, 1);
		newGrid.setCellState(1, 1, 1);
		newGrid.setCellState(2, 1, 1);
		
		assertTrue(life.getCellState(0, 1) == newGrid.getCellState(0, 1));
		assertTrue(life.getCellState(1, 1) == newGrid.getCellState(1, 1));
		assertTrue(life.getCellState(1, 1) == newGrid.getCellState(1, 1));
	}
	
	@Test
	public void yyy() {
		System.out.println("ok yyy");
	}
}

//Con gradlew test, controllare - logs/apptest.log - build/reports/tests/test/index.html

