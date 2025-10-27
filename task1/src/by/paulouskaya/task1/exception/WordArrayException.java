package by.paulouskaya.task1.exception;

public class WordArrayException extends Exception {
	public WordArrayException() {
	}
	
	public WordArrayException(String message) {
		super(message);
	}
	
	public WordArrayException(Throwable cause) {
		super(cause);
	}
	
	public WordArrayException(String message, Throwable cause) {
		super(message, cause);
	}
}
