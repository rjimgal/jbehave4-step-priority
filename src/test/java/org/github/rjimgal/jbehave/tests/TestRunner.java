package org.github.rjimgal.jbehave.tests;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, ignoreFailureInStories = false, ignoreFailureInView = false)
@UsingSpring(resources = { "org.github.rjimgal.jbehave.tests.TestConfig" })
public final class TestRunner extends InjectableEmbedder {

    @Test
    public void run() {
        final List<String> stories = new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                "stories/*.story", " ");

        // Ensure Delimiter Named Parameters to be true when using JBehave 3.
        final ParameterControls parameterControls = injectedEmbedder().configuration().parameterControls();
        parameterControls.useDelimiterNamedParameters(true);
        injectedEmbedder().configuration().useParameterControls(parameterControls);

        // Use CustomStepFinder
        final Configuration configuration = injectedEmbedder().configuration();
        configuration.useStepCollector(new MarkUnmatchedStepsAsPending(new CustomStepFinder()));
        injectedEmbedder().useConfiguration(configuration);

        final List<String> metaFilters = injectedEmbedder().metaFilters();
        metaFilters.add("-regression");

        injectedEmbedder().runStoriesAsPaths(stories);
    }

    @After
    public void gatherMetrics() {
        System.out.println(String.format("*** Number of calls made to prioritise: %s *** ", CustomStepFinder.getCallsMade()));
    }
}