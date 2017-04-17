package MS.test;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class InitTest {
	/**
	 * @author lynn.lqp
	 * 用于activiti 数据库初始化
	 */

	@Test
	public void test() {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		//定义连接数据库
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUrl("jdbc:oracle:thin:@114.215.30.227:1521:orcl");
		configuration.setJdbcUsername("Software");
		configuration.setJdbcPassword("Zhoushanshan1988");
		configuration.setDatabaseSchema("ACTIVITI");
		/**
		 * 	  public static final String DB_SCHEMA_UPDATE_FALSE = "false";操作activiti23张表的时候，如果表不存在，就抛出异常，不能自动创建23张表
  
			  public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";每次操作，都会先删除表，再创建表
			
			  public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，就创建表，如果表存在，就直接操作
		 */
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		//activiti核心对象（流程引擎）
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println("processEngine："+processEngine);
	}

}
