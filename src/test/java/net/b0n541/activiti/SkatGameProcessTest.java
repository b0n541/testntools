package net.b0n541.activiti;

import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.test.Deployment;

public class SkatGameProcessTest extends PluggableActivitiTestCase {

	@Deployment(resources = { "SkatGame.bpmn" })
	public void testSkatGameProcess() {

		runtimeService.startProcessInstanceByKey("process_pool1");
		waitForJobExecutorToProcessAllJobs(6000, 100);

	}
}
