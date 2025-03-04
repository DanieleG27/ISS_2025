package conway;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

//import conway.devices.ConwayInputMock;

//By default, JUnit comes with a bundled copy of hamcrest-core

public class conway25JavaTest {
//private static ConwayInputMock cim;
private Life life;

	@BeforeClass
	public static void setup() {
		System.out.println("setup");
    	//configureTheSystem
        //Life life           = new Life( 3,3 );
        //LifeController cc   = new LifeController(life);   
        //cim = new ConwayInputMock(cc,life);		
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
	//Verifica che all’inizio tutte le celle siano morte, assicura che il reset funzioni.
	public void testGridInitialization() {
	    Life life = new Life(4, 4);
	    
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            assertTrue("La cella deve essere inizialmente morta", life.getCellState(i, j) == 0);
	        }
	    }
	}

	
	@Test
	//Controlla che tutte le celle tornino morte dopo un reset.
	public void testGridReset() {
	    Life life = new Life(4, 4);
	    life.switchCellState(2, 2);
	    
	    assertTrue("La cella (2,2) deve essere viva", life.getCellState(2, 2) == 1);
	    
	    life.resetGrids();
	    
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            assertTrue("Dopo il reset tutte le celle devono essere morte", life.getCellState(i, j) == 0);
	        }
	    }
	}

	
	
	@Test
	//Una cella viva con meno di 2 vicini deve morire.
	public void testUnderpopulation() {
	    Life life = new Life(3, 3);
	    life.switchCellState(1, 1); // Singola cella viva
	    
	    life.computeNextGen();
	    
	    assertTrue("Una cella sola deve morire per sottopopolazione", life.getCellState(1, 1) == 0);
	}

	
	
	
	@Test
	//Una cella viva con 2 o 3 vicini deve sopravvivere.
	public void testSurvival() {
	    Life life = new Life(3, 3);
	    life.switchCellState(1, 1);
	    life.switchCellState(0, 1);
	    life.switchCellState(2, 1);
	    
	    life.computeNextGen();
	    
	    assertTrue("La cella (1,1) deve sopravvivere con 2 vicini", life.getCellState(1, 1) == 1);
	}

	
	
	@Test
	//Una cella viva con più di 3 vicini deve morire.
	public void testOverpopulation() {
	    Life life = new Life(3, 3);
	    life.switchCellState(1, 1);
	    life.switchCellState(0, 1);
	    life.switchCellState(2, 1);
	    life.switchCellState(1, 0);
	    life.switchCellState(1, 2);
	    
	    life.computeNextGen();
	    
	    assertTrue("La cella (1,1) deve morire per sovrappopolazione", life.getCellState(1, 1) == 0);
	}

	
	
	
	@Test
	//Una cella morta con esattamente 3 vicini deve rinascere.
	public void testReproduction() {
	    Life life = new Life(3, 3);
	    life.switchCellState(0, 1);
	    life.switchCellState(1, 0);
	    life.switchCellState(1, 2);
	    
	    life.computeNextGen();
	    
	    assertTrue("La cella (1,1) deve nascere con 3 vicini", life.getCellState(1, 1) == 1);
	}
	
	
	


}

//Con gradlew test, controllare - logs/apptest.log - build/reports/tests/test/index.html

