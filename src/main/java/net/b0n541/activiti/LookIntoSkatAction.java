package net.b0n541.activiti;

import java.util.Random;

import org.activiti.engine.delegate.DelegateExecution;

public class LookIntoSkatAction extends NullAction {

	private static Random random = new Random();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		super.execute(execution);
		Boolean isLookedIntoSkat = Boolean.valueOf(random.nextBoolean());

		if (isLookedIntoSkat) {
			System.out.println("                     Looked into skat...");
		}

		execution.setVariable(SkatProcessVariable.LOOKED_INTO_SKAT.name(),
				isLookedIntoSkat);
	}
}
