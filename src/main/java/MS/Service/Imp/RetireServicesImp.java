package MS.Service.Imp;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import MS.Service.RetireServices;
import MS.util.ActivitiUtil;
import MS.util.Config;
@Component
public class RetireServicesImp {

	 @Autowired
	 private ActivitiservicesIpm activity;


	
	public void retire(String  id){
		//数据入库
		//开启流程
		activity.startProcess(Config.processRetire, Config.processRetire+id);
	}
	
	   public void retireAp(String taskId){
	   	activity.CompleteTask(taskId);
	   }
	   
	   public void retireRecode(String taskId){
		   	activity.CompleteTask(taskId);
		   }
	   public void retireDo(String taskId){
		   	activity.CompleteTask(taskId);
		   }
}
