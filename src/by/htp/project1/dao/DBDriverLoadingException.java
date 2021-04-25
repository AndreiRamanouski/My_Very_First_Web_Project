package by.htp.project1.dao;

public class DBDriverLoadingException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public DBDriverLoadingException(String message, Exception e) {
		super(message,e);
	}
	public DBDriverLoadingException(String message) {
		super(message);
	}
	public DBDriverLoadingException(Exception e) {
		super(e);
	}
	public DBDriverLoadingException() {
		super();
	}

}
