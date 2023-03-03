package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

import org.junit.*;

public class RangeGetCentralValueTest {

	  private Range exampleRange;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception { }

	  @Before
	  public void setUp() throws Exception {
	    exampleRange = new Range(-1, 1);
	  }

	  @Test
	  public void testPositiveCentralValue() {
	    exampleRange = new Range(3, 7);
	    System.out.println(exampleRange.getCentralValue());
	    assertEquals("The central value of 3 and 7 should be 5", 5, exampleRange.getCentralValue(), .000000001d);
	  }

	  @Test
	  public void testNegativeCentralValue() {
	    exampleRange = new Range(-7, -3);
	    System.out.println(exampleRange.getCentralValue());
	    assertEquals("The central value of -3 and -7 should be -5", -5, exampleRange.getCentralValue(), .000000001d);
	  }

	  @Test
	  public void testZerosCentralValue() {
	    exampleRange = new Range(0, 0);
	    System.out.println(exampleRange.getCentralValue());
	    assertEquals("The central value of 0 and 0 should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	  }

	  @Test
	  public void testMixedCentralValue() {
	    exampleRange = new Range(-3, 7);
	    System.out.println(exampleRange.getCentralValue());
	    assertEquals("The central value of -3 and 7 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
	  }

	  @After
	  public void tearDown() throws Exception {
	  }

	  @AfterClass
	  public static void tearDownAfterClass() throws Exception {
	  }
	}