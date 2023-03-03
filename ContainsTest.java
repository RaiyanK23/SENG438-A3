package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

import org.junit.*;

public class ContainsTest {

	  private Range exampleRange;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception { }

	  @Before
	  public void setUp() throws Exception {
	    exampleRange = new Range(20.0, 40.0);
	  }
	  

	  @Test
		public void testLowerBoundaryContains() {
			assertEquals("The lower bound value is in Range.", true, exampleRange.contains(20.0));
		}
	  
	  @Test
		public void testUpperBoundaryForContains() {
			assertEquals("The upper bound value is in Range.", true, exampleRange.contains(40.0));
		}
	  
	  @Test
		public void testValueWithinRangeForContains() {
			assertEquals("The value lies in Range.", true, exampleRange.contains(30.0));
		}
	  
	  @Test
		public void testValueBelowLowerBoundaryForContains() {
			assertEquals("The value is below the lower bound value and is in Range.", false, exampleRange.contains(10.0));
		}

	  @Test
		public void testValueAboveThanUpperBoundaryForContains() {
			assertEquals("The value is above upper bound value and is in Range.", false, exampleRange.contains(50.0));
		}
	  
	  
	  @After
	  public void tearDown() throws Exception {
	  }

	  @AfterClass
	  public static void tearDownAfterClass() throws Exception {
	  }
	}