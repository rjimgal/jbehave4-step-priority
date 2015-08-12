package org.github.rjimgal.jbehave.tests.steps;

import org.jbehave.core.annotations.Given;
import org.springframework.stereotype.Component;

@Component
public class PrioritySteps {

    @Given("some input $input")
    public void someInput(final String input) {
        // Intentionally left blank.
    }

    @Given("some input 1")
    public void someInput1() {
        // Intentionally left blank.
    }
}