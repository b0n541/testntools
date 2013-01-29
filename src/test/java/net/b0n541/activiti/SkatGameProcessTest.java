package net.b0n541.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.test.Deployment;

public class SkatGameProcessTest extends PluggableActivitiTestCase {

	@Deployment(resources = { "SkatGame.bpmn" })
	public void testSkatGameProcess() {

		runtimeService.startProcessInstanceByKey("process_pool1");
		waitForJobExecutorToProcessAllJobs(6000, 100);

	}

	@Deployment(resources = { "SkatGame.bpmn" })
	public void testMultipleSkatGameProcesses() throws InterruptedException {

		long start = System.currentTimeMillis();

		for (int i = 0; i < 100; i++) {
			Map<String, Object> variables = new HashMap<String, Object>();
			runtimeService
					.startProcessInstanceByKey("process_pool1", variables);
		}
		waitForJobExecutorToProcessAllJobs(10000, 100);

		System.out.println(System.currentTimeMillis() - start
				+ " milliseconds.");
	}
}
