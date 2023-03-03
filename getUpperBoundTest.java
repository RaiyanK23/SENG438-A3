package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class getUpperBoundTest {
	
    Range maxUpperRange;
    Range minUpperRange;
    Range maxInfUpperRange;
    Range minInfUpperRange;
    Range nanUpperRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception { }

    @Before
    public void setUp() throws Exception {
    	System.out.println("Setting up...");
    	maxUpperRange = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
    	minUpperRange = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE);
    	maxInfUpperRange = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    	minInfUpperRange = new Range(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    	nanUpperRange = new Range(0, Double.NaN);
    }

	@Test
	public void upperBoundGetterShouldReturnMaxDoubleValue() {
    	assertEquals("The getter should have returned the maximum value of a double",
    			Double.MAX_VALUE,
    			maxUpperRange.getUpperBound(),
    			.000000001d);
    }
    
    @Test
    public void upperBoundGetterShouldReturnMinDoubleValue() {
    	assertEquals("The getter should have returned the minimum value of a double",
    			-Double.MAX_VALUE, minUpperRange.getUpperBound(),
    			.000000001d);
    }
    
    @Test
    public void upperBoundGetterShouldReturnPositiveInfty() {
    	assertEquals("The getter should have returned positive infinity",
    			Double.POSITIVE_INFINITY, maxInfUpperRange.getUpperBound(),
    			.000000001d);
    }
    
    @Test
    public void upperBoundGetterShouldReturnNegativeInfty() {
    	assertEquals("The getter should have returned negative infinity",
    			Double.NEGATIVE_INFINITY,
    			minInfUpperRange.getUpperBound(),
    			.000000001d);
    }
    
    @Test
    public void upperBoundGetterShouldReturnNaN() {
    	assertEquals("The getter should have returned NaN",
    			Double.NaN,
    			maxUpperRange.getUpperBound(),
    			.000000001d);
    	
    	/*boolean isNan = Double.isNaN(maxUpperRange.getUpperBound());
    	assertTrue("The getter should have returned NaN", isNan);*/
    }
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("Tearing down...");
    	maxUpperRange = null;
    	minUpperRange = null;
    	maxInfUpperRange = null;
    	minInfUpperRange = null;
    	nanUpperRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}