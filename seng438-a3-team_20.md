**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:  20    |     |
| -------------- | --- |
| Jacob |     |
| Mohammed               |     |
| Kundai             |     |
| Markosch Saure | 30088690   |

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

For the new set of unit test we have aimed to improve the code by performing appropriate unit tests which will allow us to get 100% code coverage.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

![image](https://user-images.githubusercontent.com/25757265/222871797-865d4d43-94b8-495f-8856-9594506adfc6.png)

![image](https://user-images.githubusercontent.com/25757265/222871812-ce6ec4bd-604d-481c-8775-2d29f41dd918.png)

![image](https://user-images.githubusercontent.com/25757265/222871834-f251fcba-7c77-4fa9-9bd8-b4ff09d664f0.png)


# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text… 

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

This lab allowed us to practically use and visualize the other important component of software testing being white box testing. In the previous lab we understood the importance of black box testing which is based on implementing tests without the knowledge of how the code is working. With that testing method we were able to locate a certain amount of bugs, but potentially not all of the bugs present. However, this lab showed us how to completely and fully find all of the bug present in the software, by looking inside and testing the code itself. The white box testing procedures that we performed, were done with the aim to reach 100% code coverage. When testing software in future situations it will be mandatory that both the white box and black box testing methods are exercised in order to make sure nothing is missed and asure for the saftey of the users. 
