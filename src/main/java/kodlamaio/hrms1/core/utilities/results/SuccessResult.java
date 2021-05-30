package kodlamaio.hrms1.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String Message) {
		super(true, Message);
}}
