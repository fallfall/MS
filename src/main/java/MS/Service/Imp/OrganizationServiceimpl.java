package MS.Service.Imp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import unit.Organization;
import unit.Result;
import MS.Dao.impl.OrganizationImpl;
import MS.Service.DataService;

@Component
public class OrganizationServiceimpl implements DataService<Organization> {

	@Autowired
	OrganizationImpl or;

	@Override
	public Result getAll() {
		java.util.List<Map<String, Object>> list=null;
		try {
			list = or.querrylist();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	@Override
	public Result getById(int id) {
		java.util.List<Map<String, Object>> list=null;
		try {
			list = or.querryByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	@Override
	public Result add(Organization t) {
		try {
			or.add(t);;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(2000, "插入成功");
	}
	@Override
	public Result update(Organization t) {
		try {
			or.add(t);;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(3000, "更新成功");
	}

	
}
