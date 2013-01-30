package net.b0n541.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class SkatGameProcessTest extends PluggableActivitiTestCase {

	@Test
	@Deployment(resources = { "diagrams/SkatGame.bpmn" })
	public void testSingleProcess() {
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put(SkatProcessVariable.GAME_NUMBER.name(), 1);
		runtimeService.startProcessInstanceByKey("skatGame", processVariables);
		waitForJobExecutorToProcessAllJobs(1000, 100);
	}

	@Test
	@Deployment(resources = { "diagrams/SkatGame.bpmn" })
	public void testMultipleProcesses() throws InterruptedException {

		runMultipleJobs(1000);
		runMultipleJobs(1000);
		runMultipleJobs(1000);
		runMultipleJobs(1000);
		runMultipleJobs(1000);
	}

	private void runMultipleJobs(int jobCount) throws InterruptedException {

		long start = System.currentTimeMillis();

		for (int i = 0; i < jobCount; i++) {
			Map<String, Object> processVariables = new HashMap<String, Object>();
			processVariables.put(SkatProcessVariable.GAME_NUMBER.name(), i);
			runtimeService.startProcessInstanceByKey("skatGame",
					processVariables);
		}

		waitForJobExecutorToProcessAllJobs(100000, 100);

		System.out.println((System.currentTimeMillis() - start)
				+ " milliseconds");
	}
}
