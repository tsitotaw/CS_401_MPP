package business;

import java.io.Serializable;

public class SaveException extends Exception implements Serializable {

	public SaveException() {
		super();
	}
	public SaveException(String msg) {
		super(msg);
	}
	public SaveException(Throwable t) {
		super(t);
	}
	private static final long serialVersionUID = 8978723266036027364L;
	
}
