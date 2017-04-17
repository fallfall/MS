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
import MS.Service.Imp.RoleServiceimpl;
import MS.util.OverFunction;

/*
 * @author lynn.lqp
 */

@RestController
public class RoleControler {
	
	@Autowired
	private RoleServiceimpl roleService;
    Gson gson=new Gson();

	  //查询Organization列表
	  @RequestMapping(value="/api/v0.1/get_roleList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getOrganizationlist(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=roleService.getAll();
			return gson.toJson(result);
		}
		
		
	}
	
	  @RequestMapping(value="/api/v0.1/getRoleById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getOrganizationById(@Param Integer organization_id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 OverFunction.println(organization_id+"");
			Result result=roleService.getById(organization_id);
			return gson.toJson(result);
		}
	}
	  
	  @RequestMapping(value="/api/v0.1/addRole",method=RequestMethod.POST)
	  @ResponseBody
	  public String addOrganization(
			  @Param String name,@Param Integer  department_type,
			  @Param String description,@Param Integer status,
			  HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Role role=new Role();
			 role.setName(name);
			 role.setDepartment_type(department_type);
			 role.setDescription(description);
			 role.setStatus(status);
			Result result=roleService.add(role);
			return gson.toJson(result);
		}
	}

	  
	  
	  @RequestMapping(value="/api/v0.1/updateRole",method=RequestMethod.POST)
	  @ResponseBody
	  public String updateOrganization(
			  @Param String name,@Param Integer  department_type,
			  @Param String description,@Param Integer status,@Param Integer id,
			  HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 Role role=new Role();
			 role.setName(name);
			 role.setDepartment_type(department_type);
			 role.setDescription(description);
			 role.setStatus(status);
			 role.setId(id);
			Result result=roleService.update(role);
			return gson.toJson(result);
		}
	}  

}
