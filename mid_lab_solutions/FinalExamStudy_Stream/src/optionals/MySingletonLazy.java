package optionals;

import java.util.Optional;

public class MySingletonLazy {

	private static MySingletonLazy instance = null;
	
	private MySingletonLazy() {}
	
	public static MySingletonLazy getInstance() {
		/*
		if(instance == null) {
			return new MySingletonLazy();
		}
		return instance;
		*/
		return Optional.ofNullable(instance).orElseGet(() -> new MySingletonLazy());
	}
}