import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
public class GradebookTester {
	
	GradeBook g1;
	GradeBook g2; 
	
	@Before
	public void setUp() throws Exception{
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(20.00);
		g2.addScore(40.00);
		g1.addScore(30.00);
		g2.addScore(60.00);
		
		
		
		
	}
	
	@After
	public void tearDown() throws Exception{
		g1 = null;
		g2 = null;
	}
	
	@Test
	public void addScoreTest() {
		g1.addScore(50.00);
		assertTrue(g1.toString().equals("20.0 30.0 50.0 "));
		assertEquals(g1.getScoreSize(),3);
		g2.addScore(70.00);
		assertTrue(g2.toString().equals("40.0 60.0 70.0 "));
		assertEquals(g2.getScoreSize(),3);
		
	}
	
	@Test
	public void sumTest() {
		g1.addScore(60.00);
		assertEquals(g1.sum(),110.00,0.001);
		g2.addScore(50.00);
		assertEquals(g2.sum(),150.00,0.001);
		
	}
	
	@Test
	public void minimumTest() {
		g1.addScore(0.001);
		assertEquals(g1.minimum(),0.0001,0.001);
		g2.addScore(50.00);
		assertEquals(g2.minimum(),40.00,0.001);
		
		
	}
	
	@Test
	public void finalScoreTest() {
		
		g1.addScore(10.00);
		assertEquals(g1.finalScore(),50.00,0.001);
		g2.addScore(100.00);
		assertEquals(g2.finalScore(),160.00,0.001);
		
	}

}
