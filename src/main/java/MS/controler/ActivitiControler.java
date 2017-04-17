package MS.controler;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import unit.Result;
import unit.Role;
import unit.User;
import MS.Service.Imp.ActivitiservicesIpm;
import MS.Service.Imp.RoleServiceimpl;
import MS.util.ActivitiUtil;
import MS.util.OverFunction;

/*
 * @author lynn.lqp
 */

@RestController
public class ActivitiControler {
	
	@Autowired
	private ActivitiservicesIpm activity;
	@Autowired
	private ActivitiUtil activitiUtil;
    Gson gson=new Gson();

	  //查询Organization列表
	  @RequestMapping(value="/api/v0.1/get_List",method=RequestMethod.GET)
	  @ResponseBody
	  public String getOrganizationlist(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
//			 OverFunction.println(user.getRole_id()+"jjjjjjjj");
//			 OverFunction.println(activitiUtil.getTaskService().createTaskQuery().taskCandidateUser(1+"").list().toString());
//			 OverFunction.println(activitiUtil.getTaskService().createTaskQuery().taskCandidateUser(user.getRole_id()+"").list().toString());
			return gson.toJson(activity.getTaskByRole(user.getRole_id()+""));
		}
		
		
	}
	

}
