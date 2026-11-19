# Strategy Pattern: Healthcare Data Processing

Code template for CS 1530 Individual Homework 4. You can find the instructions on Gradescope.

All data-processing logic currently lives in `DataEntryProcessor.process(type, input)`. Refactor it into three
`DataProcessingStrategy` implementations (`PatientDataStrategy`, `PhysicianNotesStrategy`,
`AppointmentScheduleStrategy`) without changing the behavior.

## Setup

Requires Java 17+ & Maven (or an IDE with Maven support, e.g. IntelliJ or VS Code with the Java extensions).

```
mvn test        # run the characterization tests (they pass on the starter code)
mvn compile exec:java   # run StrategyPatternDemo
```

## Automatic checks

If you push your work to your own GitHub repository, the **Actions** tab runs the tests plus a few
refactoring checks on every push (strategies implement the interface, `process(type, input)` is removed,
tests use `setStrategy` + `run`). All green means the refactoring is complete.
