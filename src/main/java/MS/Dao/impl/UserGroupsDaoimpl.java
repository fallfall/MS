package MS.Dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sun.tools.javac.util.Name.Table;

import MS.Dao.BaseDao;
import MS.util.OverFunction;
import unit.UserGroups;

@Component
public class UserGroupsDaoimpl extends  BaseImpl implements BaseDao<UserGroups> {

	
	String table="\"SOFTWARE\".\"user_group\"";
	
	@Override
	public List<Map<String, Object>> querrylist() throws Exception {
		return null;
	}

	@Override
	public List<Map<String, Object>> querryByID(int id) throws Exception {
		return null;
	}

	public List<Map<String, Object>> querryByUserID(int userid) throws Exception {
		String selectSql = String.format("select * from "+table+" where \"user_id\" =?");
		List<Map<String, Object>> rows =jdbctemlete.queryForList(selectSql,new Object[]{userid});
		return rows;
	}
	
	
	@Override
	public void add(UserGroups t) throws Exception {
		String selectSql = String.format("insert into \"SOFTWARE\".\"user_group\"("
				+ "\"user_id\","
				+ "\"group_id\","
				+ "\"create_user_id\","
				+ "\"create_date\""
				+ ") values (?,?,?,?"
				+ ")");
		jdbctemlete.update(selectSql,new Object[]{
				t.getUser_id(),
				t.getGroup_id(),
				t.getCreate_user_id(),
				OverFunction.getDate()
				
				});
		
	}

	@Override
	public void update(UserGroups t) throws Exception {
		String selectSql = String.format("update  set  \"SOFTWARE\".\"user_group\"("
				+ "\"user_id\"=?,"
				+ "\"group_id\"=?,"
				+ "\"create_user_id\"=?,"
				+ "\"create_date\"=?"
				+ "where id =?");
		jdbctemlete.update(selectSql,new Object[]{
				t.getUser_id(),
				t.getGroup_id(),
				t.getCreate_user_id(),
				OverFunction.getDate(),
				t.getId()
				});
		
	}
       
	
	    
	
	
	
	
}
