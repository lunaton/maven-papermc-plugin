package com.gmail.lunaton.cmdexecutor;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;

@Mojo(name = "start-server")
public class MavenPlugin extends AbstractMojo {

	@Parameter(required = true)
	private String command;

	@Parameter(required = true)
	private String workingDir;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s"));
		processBuilder.directory(new File(workingDir));
		processBuilder.inheritIO();

		try {
			Process process = processBuilder.start();
			process.waitFor();

		} catch (IOException | InterruptedException e) {
			throw new MojoFailureException("a petao argo");
		}
	}
}
