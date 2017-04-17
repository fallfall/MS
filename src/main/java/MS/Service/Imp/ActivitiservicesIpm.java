package MS.Service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cmd.CompleteTaskCmd;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import unit.Result;
import unit.TaskResult;
import MS.Service.ActivitiServices;
import MS.util.ActivitiUtil;
import MS.util.OverFunction;

@Component
public class ActivitiservicesIpm implements ActivitiServices{
	

	
	@Autowired
	ActivitiUtil activitiUtil;

	
	public void CompleteTask(String taskId){
		TaskService taskService=activitiUtil.getTaskService();
	   	taskService.complete(taskId);
	}
	

	@Override
	public TaskResult getTaskByRole(String role) {
		TaskService taskService=activitiUtil.getTaskService();
		OverFunction.println(taskService.createTaskQuery().taskCandidateUser(1+"").list().toString());
	//	List<Task> list=taskService.createTaskQuery().taskCandidateUser(role).list();
		List<Task> list=taskService.createTaskQuery().taskCandidateUser(1+"").list();
		return new TaskResult(1000, "查询成功", list.toString());
	}

	@Override
	public void startProcess(String processtype,String id) {
		RuntimeService runtimeService=activitiUtil.getRuntimeService();
		TaskService taskService=activitiUtil.getTaskService();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("processtype", processtype);
		params.put("id", id);
		runtimeService.startProcessInstanceByKey(processtype, params);	
		taskService.complete(taskService.createTaskQuery().singleResult().getId());
	}
	


}
