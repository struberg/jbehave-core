package org.jbehave.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.jbehave.core.embedder.Embedder;

/**
 * Mojo to run stories which are written as tests as Embeddables
 * 
 * @goal run-test-stories-as-embeddables
 * @requiresDependencyResolution test
 */
public class RunTestStoriesAsEmbeddables extends AbstractEmbedderMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        Embedder embedder = newEmbedder();
        getLog().info("Running stories as embeddable Tests using embedder " + embedder);
        try {
            embedder.runAsEmbeddables(classNames());
        } catch (RuntimeException e) {
            throw new MojoFailureException("Failed to run stories as embeddables", e);
        }
    }

}
