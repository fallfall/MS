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
import MS.Service.Imp.RetireServicesImp;
import MS.Service.Imp.RoleServiceimpl;
import MS.util.OverFunction;

/*
 * @author lynn.lqp
 */

@RestController
public class RetireControler {
	
	@Autowired
	private RetireServicesImp retireServicesImp;
    Gson gson=new Gson();

	  //查询Organization列表
	  @RequestMapping(value="/api/v0.1/retire",method=RequestMethod.GET)
	  @ResponseBody
	  public String retire(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 retireServicesImp.retire(System.currentTimeMillis()+"");
			 return  gson.toJson(new Result(3000, "完成审批"));
		}
		
		
	}
	  
	  @RequestMapping(value="/api/v0.1/retireAP",method=RequestMethod.GET)
	  @ResponseBody
	  public String retireAP(@Param String taskId,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 retireServicesImp.retireAp(taskId);
			 return  gson.toJson(new Result(3000, "完成审批"));
		}
		
		
	}
	
	  @RequestMapping(value="/api/v0.1/retireRecode",method=RequestMethod.GET)
	  @ResponseBody
	  public String retireRecode(@Param String taskId,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 retireServicesImp.retireRecode(taskId);
			 return  gson.toJson(new Result(3000, "完成记录"));
		}
		
		
	}
	  
	  @RequestMapping(value="/api/v0.1/retiredo",method=RequestMethod.GET)
	  @ResponseBody
	  public String retireDo(@Param String taskId,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 retireServicesImp.retireDo(taskId);
			 return  gson.toJson(new Result(3000, "完成记录"));
		}
		
		
	}


}
