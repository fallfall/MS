package MS.Service.Imp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import unit.Organization;
import unit.Result;
import MS.Dao.impl.BaseImpl;
import MS.Dao.impl.OrganizationImpl;
import MS.Dao.impl.SoftWareCategoryimpl;
import MS.Dao.impl.SoftWareModuleimpl;
import MS.Dao.impl.SoftwareBaseImpl;
import MS.Dao.impl.softwareExtensionImpl;
@Component
public class SoftWareServicesimpl extends BaseImpl {
	
	
	@Autowired
	private softwareExtensionImpl softwareExtension;
	@Autowired
	private SoftwareBaseImpl softwareBase;
	@Autowired
	private SoftWareCategoryimpl softWareCategory;
	@Autowired
	private SoftWareModuleimpl softWareModule;
	

	public Result getAllsoftware_category() {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softWareCategory.querrylist();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result getAllsoftware_info_basic() {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softwareBase.querrylist();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result getAllsoftware_info_extension() {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softwareExtension.querrylist();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result getAllsoftware_modules() {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softWareModule.querrylist();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result getsoftWareCategoryById(int id) {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softWareCategory.querryByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}

	
	public Result getsoftwareBaseById(int id) {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softwareBase.querryByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	public Result getsoftWareModuleById(int id) {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softWareModule.querryByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result getsoftwareExtensionById(int id) {
		java.util.List<Map<String, Object>> list = null;
		try {
			list = softwareExtension.querryByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常", list);
		}
		return new Result(1000, "查询成功", list);
	}
	
	public Result add(unit.softwareExtension t) {
		try {
			softwareExtension.add(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(2000, "插入成功");
	}

	public Result add(unit.SoftwareModules t) {
		try {
			softWareModule.add(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(2000, "插入成功");
	}
	public Result add(unit.SoftwareBase t) {
		try {
			softwareBase.add(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(2000, "插入成功");
	}
	public Result add(unit.SoftwareCategory t) {
		try {
			softWareCategory.add(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(2000, "插入成功");
	}
	public Result update(unit.softwareExtension t) {
		try {
			softwareExtension.update(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(3000, "更新成功");
	}
	public Result update(unit.SoftwareModules t) {
		try {
			softWareModule.update(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(3000, "更新成功");
	}
	public Result update(unit.SoftwareBase t) {
		try {
			softwareBase.update(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(3000, "更新成功");
	}
	public Result update(unit.SoftwareCategory t) {
		try {
			softWareCategory.update(t);
			;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(5000, "异常");
		}
		return new Result(3000, "更新成功");
	}
}
