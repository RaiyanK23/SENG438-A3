package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;


public class UtilitiesRowCountTest {
	Mockery mockingContext = new Mockery();
    Values2D values;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	values = mockingContext.mock(Values2D.class);
    }


    @Test // bug found!
    public void testCalculateRowTotalForTwoValues() {
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, 7.5, .000000001d);
    }
    
    @Test
    public void testCalculateRowTotalForNoColumns() {
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, 0, .000000001d);
    }
    
    @Test // bug found!
    public void testCalculateRowNegativeTotalFourValues() {
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(5));
                one(values).getValue(0, 0);
                will(returnValue(-6));
                one(values).getValue(0, 1);
                will(returnValue(-2));
                one(values).getValue(0, 2);
                will(returnValue(3));
                one(values).getValue(0, 3);
                will(returnValue(4));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, -1, .000000001d);
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