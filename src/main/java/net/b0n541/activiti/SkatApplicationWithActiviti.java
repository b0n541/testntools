package net.b0n541.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

public class SkatApplicationWithActiviti {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// Create Activiti process engine
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration()
				.setDatabaseSchemaUpdate(
						ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP)
				.setJobExecutorActivate(true).buildProcessEngine();

		// Get Activiti services
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		// Deploy the process definition
		repositoryService.createDeployment()
				.addClasspathResource("SkatGame.bpmn").deploy();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {

			// Start a process instance
			ProcessInstance processInstance = runtimeService
					.startProcessInstanceByKey("process_pool1");

			System.out.println(processInstance.getId());
		}

		boolean running = true;
		while (running) {
			List<Execution> runningProcesses = runtimeService
					.createExecutionQuery()
					.processDefinitionKey("process_pool1").list();
			System.out.println(runningProcesses + " running.");

			if (runningProcesses.size() == 0) {
				running = false;
			}
			Thread.sleep(100);
		}

		long end = System.currentTimeMillis();

		System.out.println(end - start + " milliseconds.");
	}

}
