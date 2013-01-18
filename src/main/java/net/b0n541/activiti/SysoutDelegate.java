package net.b0n541.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SysoutDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {

		System.out.println(execution.getCurrentActivityName());
	}

}
