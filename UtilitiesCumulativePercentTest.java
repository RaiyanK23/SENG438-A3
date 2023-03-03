package org.jfree.data.test;

import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;


public class UtilitiesCumulativePercentTest {
	Mockery mockingContext = new Mockery();
    KeyedValues values;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	values = mockingContext.mock(KeyedValues.class);
    }


    @Test // bug found!
    public void testCumulativePercentageForThreeKeys() {
    	mockingContext.checking(new Expectations() {
            {
            	allowing(values).getItemCount();
            	will(returnValue(3));
                allowing(values).getKey(0);
                will(returnValue(1));
                allowing(values).getValue(0);
                will(returnValue(2));
                allowing(values).getKey(1);
                will(returnValue(2));
                allowing(values).getValue(1);
                will(returnValue(2));
                allowing(values).getKey(2);
                will(returnValue(3));
                allowing(values).getValue(2);
                will(returnValue(2));
            }
        });
         KeyedValues result = DataUtilities.getCumulativePercentages(values);
        assertEquals(result.getValue(0).doubleValue(), 0.5, .000000001d);
    }
    
    @Test // bug found!
    public void testCumulativePercentageForTwoNegativeKeys() {
    	mockingContext.checking(new Expectations() {
            {
            	allowing(values).getItemCount();
            	will(returnValue(2));
            	allowing(values).getKey(0);
                will(returnValue(0));
                allowing(values).getValue(0);
                will(returnValue(-10));
                allowing(values).getKey(1);
                will(returnValue(1));
                allowing(values).getValue(1);
                will(returnValue(-2));
            }
        });
        KeyedValues result = DataUtilities.getCumulativePercentages(values);
        assertEquals(result.getValue(1).doubleValue(), 6.0, .000000001d);
    }
    
    @Test // No bugs found
    public void testCumulativePercentageForNoKeys() {
    	mockingContext.checking(new Expectations() {
            {
            	allowing(values).getItemCount();
            	will(returnValue(0));
            	allowing(values).getKey(0);
                will(returnValue(0));
                allowing(values).getValue(1);
                will(returnValue(4));
                allowing(values).getKey(1);
                will(returnValue(1));
                allowing(values).getValue(1);
                will(returnValue(5));
            }
        });
        KeyedValues result = DataUtilities.getCumulativePercentages(values);
        assertEquals(result.getItemCount(), 0, .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    	mockingContext = null;
    	values = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}