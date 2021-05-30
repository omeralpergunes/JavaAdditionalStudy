package kodlamaio.hrms1.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult(boolean b, String string) {
		super(false);
	}
	public ErrorResult(String Message) {
		super(false, Message);
	}
}
