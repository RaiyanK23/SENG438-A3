package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class getLengthTest {
	
    Range maxUpperRange;
    Range minLowerRange;
    Range zeroRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception { }

    @Before
    public void setUp() throws Exception {
    	System.out.println("Setting up...");
    	maxUpperRange = new Range(0, Double.MAX_VALUE);
    	minLowerRange = new Range(-Double.MAX_VALUE, 0);
    	zeroRange = new Range(0, 0);
    }

	@Test
	public void lengthShouldBeMaxDoubleValue() {
    	assertEquals("getLength() should have returned the maximum value of a double",
    			Double.MAX_VALUE,
    			maxUpperRange.getLength(),
    			.000000001d);
    }
	
	@Test
	public void lengthShouldBeMinDoubleValue() {
    	assertEquals("getLength() should have returned the maximum value of a double",
    			Double.MAX_VALUE,
    			minLowerRange.getLength(),
    			.000000001d);
    }
	
	@Test
	public void lengthShouldBeZero() {
    	assertEquals("getLength() should have returned 0",
    			0,
    			zeroRange.getLength(),
    			.000000001d);
    }
    
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("Tearing down...");
    	maxUpperRange = null;
    	minLowerRange = null;
    	zeroRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
