import static org.junit.Assert.*;

import org.junit.Test;

public class LepTest {

	@Test
	public void testSzabalyose() {
		int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
					}; 
		Lep vm = new Lep(1,2,3,3,sajat);
		assertTrue(vm.szabalyose());
		Lep vm2 = new Lep(1,2,1,2,sajat);
		assertFalse(vm2.szabalyose());
		Lep vm3 = new Lep(1,2,3,2,sajat);
		assertFalse(vm3.szabalyose());
		Lep vm4 = new Lep(1,2,2,4,sajat);
		assertTrue(vm4.szabalyose());
		Lep vm5 = new Lep(1,2,1,4,sajat);
		assertFalse(vm5.szabalyose());
	}

	@Test
	public void testTablanvan() {
		int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
					}; 
		Lep vm = new Lep(1,2,3,3,sajat);
		assertTrue(vm.tablanvan());
		Lep vm2 = new Lep(1,2,9,9,sajat);
		assertFalse(vm2.tablanvan());
	}

	@Test
	public void testNemfoglalt() {
		int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
					}; 
		Lep vm = new Lep(1,2,3,3,sajat);
		assertTrue(vm.nemfoglalt());
		Lep vm2 = new Lep(1,2,1,2,sajat);
		assertFalse(vm2.nemfoglalt());
	}

	@Test
	public void testLepes() {
		int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
				{0,0,0,0,0,0,0,0,0},	
					}; 
		Lep vm = new Lep(1,2,3,3,sajat);
		assertTrue(vm.lepes());
		Lep vm2 = new Lep(1,2,1,2,sajat);
		assertFalse(vm2.lepes());
	}

	@Test
	public void testVanemeglepes() {
		int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,9,9,9,9},	
				{0,0,0,0,0,9,9,9,9},	
				{0,0,0,0,0,9,9,9,9},	
				{0,0,0,0,0,9,9,9,0},	
					}; 
		Lep vm = new Lep(1,2,3,3,sajat);
		assertTrue(vm.vanemeglepes());
		Lep vm2 = new Lep(7,7,1,2,sajat);
		assertFalse(vm2.vanemeglepes());
		
	}

}
