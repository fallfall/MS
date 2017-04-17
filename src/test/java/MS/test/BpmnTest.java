package MS.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiTestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 




import MS.util.OverFunction;

import com.sun.corba.se.spi.activation.Repository;


public class BpmnTest extends ActivitiTestCase{



	@Test
	public void testDeploy(){
		  //加载配置文件activiti.cfg.xml，创建引擎，如果出现null，多半是加载路径不是根目录。

	    //获取配置文件后，引擎开始创建数据库。

	        ProcessEngine engine=ProcessEngines.getDefaultProcessEngine();

	    //获取流程储存服务组件

	        RepositoryService rs=engine.getRepositoryService();

	    //获取运行时服务组件

	        RuntimeService rse=engine.getRuntimeService();

	    //获取流程中的任务TASK组件

	        TaskService ts=engine.getTaskService();

	     
	        
	        

	    //部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署

	        rs.createDeployment().addClasspathResource("insert.bpmn").deploy();

	     

//	    //开启流程，myprocess是流程的ID 
//
	        rse.startProcessInstanceByKey("insert");
//
//	    //利用taskservice进行任务查询，查询第一个任务，查询后完成
//
//	        Task task=ts.createTaskQuery().singleResult();
//
//	        System.out.println("第一个流程任务完成前"+task.getName());
//
//	        ts.complete(task.getId());

	        OverFunction.println(taskService.createTaskQuery().taskCandidateUser(1+"").list().toString());
	        
	     
//	    //完成第一个任务后再次查询，出现第二个任务名称，完成第二个任务   
//
//	        task=ts.createTaskQuery().singleResult();
//
//	        System.out.println("第二个流程任务完成前"+task.getName());
//
//	        ts.complete(task.getId());
//
//	     
//
//	    //再次查询，TASK是NULL   
//
//	        task=ts.createTaskQuery().singleResult();
//
//	        System.out.println("结束后"+task);

	    }

	}

