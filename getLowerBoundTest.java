package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class getLowerBoundTest {
	
    Range maxLowerRange;
    Range minLowerRange;
    Range maxInfLowerRange;
    Range minInfLowerRange;
    Range nanLowerRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception { }

    @Before
    public void setUp() throws Exception {
    	System.out.println("Setting up...");
    	maxLowerRange = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
    	minLowerRange = new Range(-Double.MAX_VALUE, 0);
    	maxInfLowerRange = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    	minInfLowerRange = new Range(Double.NEGATIVE_INFINITY, 0);
    	nanLowerRange = new Range(Double.NaN, 0);
    }

	@Test
	public void lowerBoundGetterShouldReturnMaxDoubleValue() {
    	assertEquals("The getter should have returned the maximum value of a double",
    			Double.MAX_VALUE,
    			maxLowerRange.getLowerBound(),
    			.000000001d);
    }
    
    @Test
    public void lowerBoundGetterShouldReturnMinDoubleValue() {
    	assertEquals("The getter should have returned the minimum value of a double",
    			-Double.MAX_VALUE, minLowerRange.getLowerBound(),
    			.000000001d);
    }
    
    @Test
    public void lowerBoundGetterShouldReturnPositiveInfty() {
    	assertEquals("The getter should have returned positive infinity",
    			Double.POSITIVE_INFINITY, maxInfLowerRange.getLowerBound(),
    			.000000001d);
    }
    
    @Test
    public void lowerBoundGetterShouldReturnNegativeInfty() {
    	assertEquals("The getter should have returned negative infinity",
    			Double.NEGATIVE_INFINITY,
    			minInfLowerRange.getLowerBound(),
    			.000000001d);
    }
    
    @Test
    public void lowerBoundGetterShouldReturnNaN() {
    	assertEquals("The getter should have returned NaN",
    			Double.NaN,
    			maxLowerRange.getLowerBound(),
    			.000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("Tearing down...");
    	maxLowerRange = null;
    	minLowerRange = null;
    	maxInfLowerRange = null;
    	minInfLowerRange = null;
    	nanLowerRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
