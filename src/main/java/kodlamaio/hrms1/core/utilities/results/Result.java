package kodlamaio.hrms1.core.utilities.results;

public class Result {

	private boolean success;
	private String Message;
	
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success, String Message) {
		this(success);
		this.Message = Message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.Message;
	}
}
