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

import unit.Organization;
import unit.Result;
import unit.User;
import MS.Service.Imp.OrganizationServiceimpl;
import MS.util.OverFunction;


/*
 * @author lynn.lqp
 */

@RestController
public class OrganizationControler {
	
	@Autowired
	private OrganizationServiceimpl OrganizationService;
    Gson gson=new Gson();
		  
    //查询Organization列表
	  @RequestMapping(value="/api/v0.1/getOrganizationList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getOrganizationlist(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=OrganizationService.getAll();
			return gson.toJson(result);
		}
		
		
	}
	
	  @RequestMapping(value="/api/v0.1/getOrganizationById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getOrganizationById(@Param Integer organization_id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 OverFunction.println(organization_id+"");
			Result result=OrganizationService.getById(organization_id);
			return gson.toJson(result);
		}
	}
	  
	  @RequestMapping(value="/api/v0.1/addOrganization",method=RequestMethod.POST)
	  @ResponseBody
	  public String addOrganization(
			  @Param String name,@Param Integer parent_id,@Param Integer  department_type,
			  @Param String description,@Param String address,
			  HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 Organization organization=new Organization();
			 organization.setName(name);
			 organization.setDepartment_type(department_type);
			 organization.setCreate_user_id(user.getId());
			 organization.setAddress(address);
			 organization.setParent_id(parent_id);
			Result result=OrganizationService.add(organization);
			return gson.toJson(result);
		}
	}

	  
	  
	  @RequestMapping(value="/api/v0.1/updateOrganization",method=RequestMethod.POST)
	  @ResponseBody
	  public String updateOrganization(
			  @Param String name,@Param Integer parent_id,@Param Integer department_type,
			  @Param String description,@Param String address,@Param Integer id,@Param Integer status,
			  HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			 Organization organization=new Organization();
			 organization.setId(id);
			 organization.setName(name);
			 organization.setDepartment_type(department_type);
			 organization.setUpdate_user(user.getId());
			 organization.setAddress(address);
			 organization.setParent_id(parent_id);
			 organization.setStatus(status);
			Result result=OrganizationService.update(organization);
			return gson.toJson(result);
		}
	}
}
