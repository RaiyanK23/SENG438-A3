**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:  20    |     |
| -------------- | --- |
| Jacob |     |
| Mohammed               |     |
| Kundai             |     |
| Markosch               |     |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for DataUtilities.calculateColumnTotal and Range.contains methods

**calculateColumnTotal**:

Data flow graph: 

```
`+---------------+
 | mockingContext|
 +---------------+
         |
         V
 +---------------+
 |    values     |
 +---------------+
         |
 +---------+--------+
 |                  |
 V                  V
+---------------+  +---------------+
| setUp()       |  | setUp()       |
| (initializes  |  | (initializes  |
| mockingContext|  | values)       |
+---------------+  +---------------+
         |
         V
 +---------------+
 | calculate-    |
 | ColumnTotal() |
 +---------------+
         |
         V
 +---------------+
 |  assertEquals |
 +---------------+
         |
         V
 +---------------+
 | NullPointerException |
 +---------------+
         |
         V
 +---------------+
 | tearDown()    |
 +---------------+

```


Def-use sets per statement:

Mockery mockingContext = new Mockery();  // def: mockingContext, use: none
Values2D values;                        // def: values, use: none

System.out.println("Setting up...");   // def: none, use: none
values = mockingContext.mock(Values2D.class); // def: values, use: mockingContext

double result = DataUtilities.calculateColumnTotal(values, 0); // def: result, use: values

assertEquals(result, 0.0, .000000001d);  // def: none, use: result

values = null;                          // def: values, use: none
double result = DataUtilities.calculateColumnTotal(values, 0); // def: result, use: values

assertNull("Should throw a Nullptr exception", values); // def: none, use: values

mockingContext = null;                  // def: mockingContext, use: none
values = null;                          // def: values, use: none
System.out.println("Tearing down...");  // def: none, use: none

List of DU-Pairs:

mockingContext:
  (mockingContext, none)

values:
  (values, none)
  (values, mockingContext)
  (values, result)
  (values, null)

result:
  (result, values)
  (result, none)

Note: (x, none) means that variable x is defined but not used in the statement.

For the calculateColumnTotalForNoRows() test case, the following DU-pairs are covered:

(values, mockingContext)
(result, values)
(result, none)
For the checkInvalidInput() test case, the following DU-pairs are covered:

(values, mockingContext)
(values, null)
For the calculateColumnTotalForTwoValues() test case, the following DU-pairs are covered:

(values, mockingContext)
(result, values)
(result, none)
All the DU-pairs were covered by at least one test case, so the DU-Pair coverage is 100%.

**contains**:

Data flow graph:

         +---------+        +--------------+
         |         |        |              |
         | exampleRange | <----| new Range()  |
         |         |        |              |
         +---------+        +--------------+
               |
               | 
      +--------+--------+
      |                 |
      |  assertEquals() |
      |                 |
      +--------+--------+
               |
               |
      +--------+--------+
      |                 |
      |    assertTrue() |
      |                 |
      +--------+--------+
               |
               |
     +---------+---------+
     |                   |
     |    assertFalse()  |
     |                   |
     +---------+---------+


Def-user sets per statement:

Line 11: exampleRange is defined
Line 22-26: exampleRange is used as input for contains() method
Line 28-32: exampleRange is used as input for contains() method
Line 34-38: exampleRange is used as input for contains() method
Line 40-44: exampleRange is used as input for contains() method
Line 46-50: exampleRange is used as input for contains() method

DU-Pairs Per variable:

exampleRange:
Def: Line 11
Use: Line 22, 28, 34, 40, 46

Coverage for each test case:

testLowerBoundaryContains: covers DU-pair (exampleRange, Line 22)
testUpperBoundaryForContains: covers DU-pair (exampleRange, Line 28)
testValueWithinRangeForContains: covers DU-pair (exampleRange, Line 34)
testValueBelowLowerBoundaryForContains: covers DU-pair (exampleRange, Line 40)
testValueAboveThanUpperBoundaryForContains: covers DU-pair (exampleRange, Line 46)

DU-pair coverage:

There are a total of 5 DU-pairs for the exampleRange variable and all of them are covered by the test cases, so the DU-pair coverage is 100%.


# 3 A detailed description of the testing strategy for the new unit test

Fortunately our team created very effiecient units tests in the previous assignments so we didn't have to develop an elaborate test plan for this assignment. The first step in our testing plan was to run all our previous code using with artifacts provided in the assignment outline. After running the code we will then employ a coverage tool that satisfies all the metrics required. After running the tool to determine the test coverage we will note down the values and make adjustmnents as needed. In our case, we decided to go with EclEmma in eclipse since it was easy to install and had all the coverage metrics we needed. 
Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

As mentioned in the previous section of the report, the previous tests we created were very efficient and this result in really good values for the required coverage metrics. Using EclEmma, we determined all ten of our tests had at least 95% line coverage. This resulted in us not having to add or remove tests cases from the tests initially. To improve any tests with covergae below 100%, we mainly formatted the suite(e.g deleting spaces between brackets). This change resulted in improving all tests to have 97.5% or higher line coverage. Afterwards, we checked the method coverage and 4 of our tests had 87.5% coverage. The coverage tool selected, EclEmma, had the capabilites of highlighting the exact method that affected the coverage percentage. When the highlighted test cases were removed, the method coverage improved to 100% for all tests. The test cases removed in all 4 tests was throwing an exception and beacuse it was not relevant to the methods we were testing, the coverage tool suggested we removed it. 
Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
