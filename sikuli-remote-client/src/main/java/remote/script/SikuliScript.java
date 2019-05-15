package remote.script;


public class SikuliScript {

	private String name;
	
	private ScriptStatus status;
	
	private Exception failure_reason;
	
	public SikuliScript(String name, ScriptStatus status, Exception failure_reason) {
		this.name = name;
		this.status = status;
		this.failure_reason = failure_reason;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScriptStatus getStatus() {
		return status;
	}

	public void setStatus(ScriptStatus status) {
		this.status = status;
	}

	public Exception getFailure_reason() {
		return failure_reason;
	}

	public void setFailure_reason(Exception failure_reason) {
		this.failure_reason = failure_reason;
	}


}
