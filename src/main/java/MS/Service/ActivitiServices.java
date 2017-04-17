package MS.Service;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.task.Task;

import unit.TaskResult;

public interface ActivitiServices {

   
	public TaskResult getTaskByRole(String role);


	void startProcess(String processtype, String id);

	
}
