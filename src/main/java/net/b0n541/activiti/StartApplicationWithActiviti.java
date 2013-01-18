package net.b0n541.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class StartApplicationWithActiviti {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		// Create Activiti process engine
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration()
				.setDatabaseSchemaUpdate(
						ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
				.setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
				.setJobExecutorActivate(true).buildProcessEngine();

		// Get Activiti services
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		// Deploy the process definition
		repositoryService.createDeployment()
				.addClasspathResource("first_process.bpmn").deploy();

		// Start a process instance
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("financialReport");

		System.out.println(processInstance.getId());

		long end = System.currentTimeMillis();

		System.out.println(end - start + " milliseconds.");
	}
}
