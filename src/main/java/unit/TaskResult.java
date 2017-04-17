package unit;

import java.util.List;

import org.activiti.engine.task.Task;

public class TaskResult {
	
	public int code;
	public String message;
	public String list;
	
	
	public TaskResult(int code, String message, String list) {
		this.code = code;
		this.message = message;
		this.list = list;
	}




	public String getList() {
		return list;
	}




	public void setList(String list) {
		this.list = list;
	}


	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	

	
	
	
	

}
