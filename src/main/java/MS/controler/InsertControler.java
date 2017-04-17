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
import MS.Service.Imp.InsertServicesImp;
import MS.Service.Imp.RoleServiceimpl;
import MS.util.OverFunction;

/*
 * @author lynn.lqp
 */

@RestController
public class InsertControler {
	
	@Autowired
	private InsertServicesImp insert;
    Gson gson=new Gson();

	  //查询Organization列表
	  @RequestMapping(value="/api/v0.1/insert",method=RequestMethod.GET)
	  @ResponseBody
	  public String insert(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 insert.Insert(user.getId()+"");
			 return  gson.toJson(new Result(3000, "完成审批"));
		}
		
		
	}
	  
	  @RequestMapping(value="/api/v0.1/insertAP",method=RequestMethod.GET)
	  @ResponseBody
	  public String insertAP(@Param String taskId,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 insert.InsertApproval(taskId);
			 return  gson.toJson(new Result(3000, "完成审批"));
		}
		
		
	}
	


}
