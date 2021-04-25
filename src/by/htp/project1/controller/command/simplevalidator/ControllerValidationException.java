package by.htp.project1.controller.command.simplevalidator;

public class ControllerValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	public ControllerValidationException(String message, Exception e) {
		super(message,e);
	}
	public ControllerValidationException(String message) {
		super(message);
	}
	public ControllerValidationException(Exception e) {
		super(e);
	}
	public ControllerValidationException() {
		super();
	}
}

