package genericClasses;

public class MySpecialDictionary extends MyDictionary<String, String>{

	
	public MySpecialDictionary(String key, String value) {
		super(key, value);
	}
	
	@Override
	public String getKey() {
		return super.getKey();
	}
	@Override
	public String getValue(String key) {
		return super.getValue(key);
	}

}
