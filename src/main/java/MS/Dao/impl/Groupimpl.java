package MS.Dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import unit.Group;
import MS.Dao.BaseDao;
import MS.util.OverFunction;
@Component
public class Groupimpl extends BaseImpl implements BaseDao<Group> {
	
	@Autowired
	UserGroupsDaoimpl uerGroupsDaoimpl;

	@Override
	public List<Map<String, Object>> querrylist() throws Exception {
		return querrylist("\"SOFTWARE\".\"group\"");
	}

	@Override
	public List<Map<String, Object>> querryByID(int id) throws Exception {
		return querryByID(id, "\"SOFTWARE\".\"group\"");
	}
	
	
	
	@Override
	public void add(Group t) throws Exception {
		String selectSql = String.format("insert into  \"SOFTWARE\".\"group\"("
				+ "\"name\","
				+ "\"description\","
				+ "\"status\","
				+ "\"create_date\","
				+ "\"create_user_id\","
				+ "\"create_date\","
				+ ") values (?,?,?,?,?,?"
				+ ")");
		jdbctemlete.update(selectSql,new Object[]{
				t.getName(),
				t.getDescription(),
				t.getStatus(),
				t.getCreate_date(),
				t.getCreate_user_id(),
				OverFunction.getDate()
				});
		
	}

	@Override
	public void update(Group t) throws Exception {
		String selectSql = String.format("update \"SOFTWARE\".\"group\" set"
				+ "\"name\"=?,"
				+ "\"parent_id\"=?,"
				+ "\"department_type\"=?,"
				+ "\"description\"=?,"
				+ "\"address\"=?,"
				+ "\"status\"=?,"
				+ "\"create_user_id\"=?,"
				+ "\"update_date\"=?"
				+ "where id=?");
		jdbctemlete.update(selectSql,new Object[]{
				t.getName(),
				t.getDescription(),
				t.getStatus(),
				t.getCreate_date(),
				t.getCreate_user_id(),
				OverFunction.getDate(),
				t.getId()
				});
		
	}
	
	 public  List<Map<String, Object>> getGroupsByUserId(int userid) throws Exception{
		 List<Map<String, Object>> userGroup=uerGroupsDaoimpl.querryByUserID(userid);
		 List<Map<String, Object>>  groups=null;
	    for (Map<String, Object> map : userGroup) {
			groups.addAll(querryByID(Integer.valueOf(map.get("group_id").toString())));
		}
		 return groups;
	 }

}
