package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;

public class NumberArrayTest {

    // Set-up
    double[] testDataOne = { 0.0 };
    double[] testMultipleData = { 2.4, -3.5, -1.1 };
    double[] testNull = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up...");
    }

    // Test Cases

    @Test
    public void TestSizeOfNumberArrayForOneElement() {
        Number[] result = DataUtilities.createNumberArray(testDataOne);
        boolean res = result.equals(result);
        assertEquals(true, res);
        assertEquals(1, result.length);
    }

    @Test
    public void TestNumberArrCreatedIsEqualToInput() {
        Number[] result = DataUtilities.createNumberArray(testMultipleData);
        boolean res = result.equals(result);
        assertEquals(true, res);
    }

    // Teardown
    @After
    public void tearDown() throws Exception {
        testDataOne = null;
        testMultipleData = null;
        System.out.println("Tearing down...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}