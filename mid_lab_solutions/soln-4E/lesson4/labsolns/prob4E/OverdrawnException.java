package lesson4.labsolns.prob4E;

@SuppressWarnings("serial")
public class OverdrawnException extends Exception {
	public OverdrawnException() {
		super();
	}
	public OverdrawnException(String s) {
		super(s);
	}
	public OverdrawnException(Throwable t) {
		super(t);
	}
}
