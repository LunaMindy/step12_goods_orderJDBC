package kosta.mvc.exception;
/**
 * 수정할때 발생하는 예외
 * @author User
 *
 */
public class ModifyException extends Exception {
	public  ModifyException() {
	}
	
	public ModifyException(String message) {
		super(message);
	}

}
