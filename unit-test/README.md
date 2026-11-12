# Unit Test – Event RSVP Logic (FR-4 / UC-2)

Sample unit for Deliverable #2: `Event.addRSVP()`, `Event.isFull()`, `Event.getRSVPCount()` and `RSVP.cancel()`, tested with JUnit 4.13.2 on Java 21.

## Files
- `src/edu/utd/studentlife/Event.java` – unit under test
- `src/edu/utd/studentlife/RSVP.java`
- `src/edu/utd/studentlife/EventFullException.java`
- `test/edu/utd/studentlife/EventRSVPTest.java` – 5 JUnit test cases (TC-1 to TC-5)
- `test/edu/utd/studentlife/VerboseRunner.java` – prints PASS/FAIL for each test
- `lib/` – JUnit 4.13.2 and Hamcrest 1.3 jars

## Run (macOS / Linux)
```
javac -d out -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/edu/utd/studentlife/*.java test/edu/utd/studentlife/*.java
java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.utd.studentlife.EventRSVPTest
java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar edu.utd.studentlife.VerboseRunner
```
On Windows, replace `:` with `;` in the classpath.

## Result
5 tests run, 0 failures.
