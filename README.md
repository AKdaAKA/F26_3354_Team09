F26_3354_Team09
Team 9: Prakrit Chauhan, Aakash Bhagavathi, Parinita Chilukuri, William Turner, Hector Lopez, Aamir Khan, Shayaan Rahim

A mobile application allowing UT Dallas students to interact with one another through events, common interests, and messages. CE/CS/SE 3354 Software Engineering Fall 2026.

Project Scope.pdf: Project proposal and scope. inal_Project_Report_Template_3.pdf: Final project report containing the SRS, design, project plan, and test plan. Team_09_SE3354_F26_Project_Class_Presentation.pdf: Presentation Slides. unit-test/: Includes an example unit that handles Event RSVP logic (FR-4) and JUnit 4.13.2 test cases. Refer to unit-test/README.md for details on how to run.

# Unit Test - Event RSVP Logic (FR-4 / UC-2)

An example of a unit from deliverable #2. This includes Event.addRSVP(), Event.isFull(), Event.getRSVPCount() and RSVP.cancel(). The unit was tested using JUnit 4.13.2 and Java 21.

## Source Files
src/edu/utd/studentlife/Event.java - Unit being tested.
src/edu/utd/studentlife/RSVP.java
src/edu/utd/studentlife/EventFullException.java
test/edu/utd/studentlife/EventRSVPTest.java - JUnit test cases including 5 test cases (TC-1 - TC-5).
test/edu/utd/studentlife/VerboseRunner.java - Outputs PASS/FAIL messages for each test.
lib/ - JUnit 4.13.2 and Hamcrest 1.3 jars.

## How to Run (Mac OS/Linux)
```
javac -d out -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/edu/utd/studentlife/.java test/edu/utd/studentlife/.java
java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.utd.studentlife.EventRSVPTest
java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar edu.utd.studentlife.VerboseRunner
```
(Replace : with ; for windows.)
## Outcome

5 tests passed with 0 failures.
