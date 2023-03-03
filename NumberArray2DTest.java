package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;

public class NumberArray2DTest {

    // Set-up
    double[][] testDataOne = new double[1][1];
    double[][] testMultipleData = new double[10][10];
    double[][] testNull = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up...");
        testDataOne[0][0] = 1;
    }

    // Test Cases

    @Test
    public void TestSizeOfNumberArrayForOneElement2D() {
        Number[][] result = DataUtilities.createNumberArray2D(testDataOne);
        boolean res = result.equals(result);
        assertEquals(true, res);
        assertEquals(1, result.length);
    }

    @Test
    public void TestNumberArrCreatedIsEqualToInput() {
        Number[][] result = DataUtilities.createNumberArray2D(testMultipleData);
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