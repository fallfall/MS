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
import unit.SoftwareBase;
import unit.User;
import unit.softwareExtension;
import MS.Service.Imp.SoftWareServicesimpl;


/*
 * @author lynn.lqp
 */

@RestController
public class SoftWareControler {
	
	@Autowired
	SoftWareServicesimpl softWareServices;

    Gson gson=new Gson();
		  
	  @RequestMapping(value="/api/v0.1/getsoftwareExtensionList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwareExtensionList(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getAllsoftware_info_extension();
			return gson.toJson(result);
		}
		
		
	}
	  @RequestMapping(value="/api/v0.1/getsoftwareCategoryList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwareCategoryList(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getAllsoftware_category();
			return gson.toJson(result);
		}
		
		
	}
	  @RequestMapping(value="/api/v0.1/getsoftwareBasicList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwarebasicList(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getAllsoftware_info_basic();
			return gson.toJson(result);
		}
		
		
	}
		
	  @RequestMapping(value="/api/v0.1/getsoftwaresoftwareModulesList",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwaresoftwareModulesList(HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getAllsoftware_modules();
			return gson.toJson(result);
		}
		
		
	}
	
	  @RequestMapping(value="/api/v0.1/getsoftwareBaseById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwareBaseById(@Param int id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getsoftwareBaseById(id);
			return gson.toJson(result);
		}
	}
	  @RequestMapping(value="/api/v0.1/getsoftWareCategoryById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftWareCategoryById(@Param int id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getsoftWareCategoryById(id);
			return gson.toJson(result);
		}
	}
	  @RequestMapping(value="/api/v0.1/getsoftwareExtensionById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftwareExtensionById(@Param int id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getsoftwareExtensionById(id);
			return gson.toJson(result);
		}
	}
	  
	  @RequestMapping(value="/api/v0.1/getsoftWareModuleById",method=RequestMethod.GET)
	  @ResponseBody
	  public String getsoftWareModuleById(@Param int id,HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			Result result=softWareServices.getsoftWareModuleById(id);
			return gson.toJson(result);
		}
	}
	  
	  @RequestMapping(value="/api/v0.1/addsoftwareBase",method=RequestMethod.POST)
	  @ResponseBody
	  public String addsoftwareBase(
			  @Param String name,@Param Integer category_id,@Param Integer  type,
			  @Param String usage,@Param String remark,@Param String appendix,
			  HttpServletRequest request) {
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("User");
		  if (user==null) {
			  return  gson.toJson(new Result(1002, "请您重新登录"));
		 }else {
			SoftwareBase softwareBase=new SoftwareBase();
			softwareBase.setCategory_id(category_id);
			softwareBase.setName(name);
			softwareBase.setAppendix(appendix);
			softwareBase.setCreate_user_id(user.getId());
			softwareBase.setRemark(remark);
			softwareBase.setType(type);
			softwareBase.setUsage(usage);
			Result result=softWareServices.add(softwareBase);
			return gson.toJson(result);
		}
	}

//	  @RequestMapping(value="/api/v0.1/addsoftwareBase",method=RequestMethod.POST)
//	  @ResponseBody
//	  public String addsoftwareBase(
//			  @Param String name,@Param Integer category_id,@Param Integer  type,
//			  @Param String usage,@Param String remark,@Param String appendix,
//			  HttpServletRequest request) {
//		  HttpSession session=request.getSession();
//		  User user=(User) session.getAttribute("User");
//		  if (user==null) {
//			  return  gson.toJson(new Result(1002, "请您重新登录"));
//		 }else {
//			softwareExtension softwareExtension=new softwareExtension();
//			softwareBase.setCategory_id(category_id);
//			softwareBase.setName(name);
//			softwareBase.setAppendix(appendix);
//			softwareBase.setCreate_user_id(user.getId());
//			softwareBase.setRemark(remark);
//			softwareBase.setType(type);
//			softwareBase.setUsage(usage);
//			Result result=softWareServices.add(softwareBase);
//			return gson.toJson(result);
//		}
//	}

	  
//	  @RequestMapping(value="/api/v0.1/updateOrganization",method=RequestMethod.POST)
//	  @ResponseBody
//	  public String updateOrganization(
//			  @Param String name,@Param Integer parent_id,@Param Integer  department_type,
//			  @Param String description,@Param String address,@Param Integer id,@Param Integer status,
//			  HttpServletRequest request) {
//		  HttpSession session=request.getSession();
//		  User user=(User) session.getAttribute("User");
//		  if (user==null) {
//			  return  gson.toJson(new Result(1002, "请您重新登录"));
//		 }else {
//			 Organization organization=new Organization();
//			 organization.setId(id);
//			 organization.setName(name);
//			 organization.setDepartment_type(department_type);
//			 organization.setUpdate_user(user.getId());
//			 organization.setAddress(address);
//			 organization.setParent_id(parent_id);
//			 organization.setStatus(status);
//			Result result=OrganizationService.update(organization);
//			return gson.toJson(result);
//		}
//	}
}
