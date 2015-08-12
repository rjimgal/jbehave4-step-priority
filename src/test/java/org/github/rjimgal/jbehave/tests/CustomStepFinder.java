package org.github.rjimgal.jbehave.tests;

import java.util.List;

import org.jbehave.core.steps.StepCandidate;
import org.jbehave.core.steps.StepFinder;

public class CustomStepFinder extends StepFinder {

    private static int callsMade = 0;

    public CustomStepFinder() {
        super(new ByLevenshteinDistance());
    }

    @Override
    public List<StepCandidate> prioritise(String stepAsText, List<StepCandidate> candidates) {
        callsMade++;
        return super.prioritise(stepAsText, candidates);
    }

    public static int getCallsMade() {
        return callsMade;
    }

}
