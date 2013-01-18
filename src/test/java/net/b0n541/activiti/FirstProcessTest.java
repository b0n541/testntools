package net.b0n541.activiti;

import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiTestCase;
import org.activiti.engine.test.Deployment;

public class FirstProcessTest extends ActivitiTestCase {

	@Deployment(resources = { "first_process.bpmn" })
	public void testSimpleProcess() {
		runtimeService.startProcessInstanceByKey("financialReport");

		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Write monthly financial report", task.getName());

		taskService.complete(task.getId());
		assertEquals(1, runtimeService.createProcessInstanceQuery().count());
	}
}