package MS.Service.Imp;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import MS.util.ActivitiUtil;
import MS.util.Config;

@Component
public class InsertServicesImp  {

	 @Autowired
	 private ActivitiservicesIpm activity;
	 @Autowired
	 ActivitiUtil activitiUtil;

	
	public void Insert(String  id){
		//数据入库
		//开启流程
		activity.startProcess(Config.processInsert, Config.processInsert+id);
		
	}
	
    public void InsertApproval(String taskId){
    	//
    	TaskService taskService=activitiUtil.getTaskService();
    	taskService.complete(taskId);
    }
}
