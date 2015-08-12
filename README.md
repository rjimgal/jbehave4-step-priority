# jbehave4-step-priority

`PerformableTree` is adding `ExamplePerformableScenario` instances that are not allowed due to Meta Filters.

This causes a significant amount of calls to StepFinder.prioritise() method, resulting in a performance degradation, specially when using Levenshtein Distance.

## Run using JBehave 4

From a terminal, just execute:

`mvn clean test`

Output will look like:

```
Reports view generated with 0 stories (of which 0 pending) containing 0 scenarios (of which 0 pending)
*** Number of calls made to prioritise: 21 ***
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.788 sec
```

## Run using JBehave 3

From a terminal, just execute:

`mvn clean test -Pjbehave3`

Now output will look like:

```
Reports view generated with 0 stories (of which 0 pending) containing 0 scenarios (of which 0 pending)
*** Number of calls made to prioritise: 1 ***
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.864 sec
```
