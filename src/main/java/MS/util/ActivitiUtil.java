package MS.util;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.stereotype.Component;

@Component
public class ActivitiUtil {
	
	
	//static	ProcessEngine processEngine=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();  	
	static	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	public TaskService getTaskService() {
		return processEngine.getTaskService();
	}

	public RuntimeService getRuntimeService() {
		return processEngine.getRuntimeService();
	}
   
	static{
	//	RepositoryService rs=processEngine.getRepositoryService();
	//	rs.createDeployment().addClasspathResource("insert.bpmn").deploy();
	//	rs.createDeployment().addClasspathResource("Retire.bpmn").deploy();
	//	rs.createDeployment().addClasspathResource("outPut.bpmn").deploy();
		
	}
	
	
}
