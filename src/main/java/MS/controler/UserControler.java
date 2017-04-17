package MS.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import unit.Result;
import unit.UpdatePwd;
import unit.User;
import unit.request.loginUser;
import MS.Dao.impl.UserDaoImpl;
import MS.Service.UserService;
import MS.Service.Imp.UserServiceImp;
import MS.util.OverFunction;

/*
 * @author lynn.lqp
 */

@RestController
public class UserControler {

	@Autowired
	private UserService UserService;

	Gson gson = new Gson();

	@RequestMapping("/")
	public @ResponseBody String index() {
		return "你好，软件运维平台";
	}

	// 登录
	@RequestMapping(value = "/api/v0.1/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody loginUser loginUser, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		if (!(user == null)) {
			return gson.toJson(new Result(1002, "已经登录"));
		}
		if ((loginUser.getUsername() == null) || (loginUser.getPassword() == null)) {
			return gson.toJson(new Result(1000, "用户名或密码为空"));
		}
		Result result = UserService.login(loginUser.getUsername(), OverFunction.GetMD5Code(loginUser.getPassword()));
		if (result.getCode() == 1000) {
			session.setAttribute("User", result.getUser());
		}
		return gson.toJson(result);

	}

	// 添加用户
	@RequestMapping(value = "/api/v0.1/add_user", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userlogin = (User) session.getAttribute("User");
		if (userlogin == null) {
			return gson.toJson(new Result(1003, "请您重新登录"));
		} else {
			user.setPassword(OverFunction.GetMD5Code(user.getPassword()));
			user.setCreate_user_id(userlogin.getId());
			Result result = UserService.addUser(user);
			return gson.toJson(result);
		}

	}

	// 查询当前用户信息
	@RequestMapping(value = "/api/v0.1/get_userinfo", method = RequestMethod.GET)
	@ResponseBody
	public String getUserinfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			return gson.toJson(new Result(1003, "请您重新登录"));
		} else {
			Result result = UserService.getUserByID(user.getId());
			if (result.getData()!=null) {
				session.setAttribute("User", result.getData().get(0));
			}
			return gson.toJson(result);
		}

	}

	// 修改当前用户信息
	@RequestMapping(value = "/api/v0.1/edit_userinfo", method = RequestMethod.POST)
	@ResponseBody
	public String upDateUserinfo(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userloginUser = (User) session.getAttribute("User");
		if (userloginUser == null) {
			return gson.toJson(new Result(1002, "请您重新登录"));
		} else {
			user.setUpdate_user(userloginUser.getId());
			user.setPassword(userloginUser.getPassword());
			Result result = UserService.upDateUser(user);
			return gson.toJson(result);
		}

	}
	
	// 修改当前用户信息
	@RequestMapping(value = "/api/v0.1/edit_userinfo", method = RequestMethod.POST)
	@ResponseBody
	public String upDateUserPassword(@RequestBody UpdatePwd  updatepwd, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userloginUser = (User) session.getAttribute("User");
		if (userloginUser == null) {
			return gson.toJson(new Result(1002, "请您重新登录"));
		} else {
			if (OverFunction.GetMD5Code(updatepwd.getOldPwd()).equals(userloginUser.getPassword())) {
				userloginUser.setPassword(updatepwd.getNewPwd());
				Result result = UserService.upDateUser(userloginUser);
				return gson.toJson(result);
			} else {
				return gson.toJson(new Result(1002, "密码错误"));
			}
		
		}

	}

	// 查询用户列表
	@RequestMapping(value = "/api/v0.1/get_userList", method = RequestMethod.GET)
	@ResponseBody
	public String getUserlist(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			return gson.toJson(new Result(1002, "请您重新登录"));
		} else {
			Result result = UserService.getUserList();
			return gson.toJson(result);
		}

	}

	// 根据ID查询用户信息
	@RequestMapping(value = "/api/v0.1/get_userinfoByid", method = RequestMethod.GET)
	@ResponseBody
	public String getUserinfoById(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userlogin = (User) session.getAttribute("User");
		if (user == null) {
			return gson.toJson(new Result(1002, "请您重新登录"));
		} else {
			Result result = UserService.getUserByID(user.getId());
			return gson.toJson(result);
		}
	}

}
