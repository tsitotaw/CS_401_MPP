package genericClasses;

public class MyDictionary<K, V> implements IDictionary<K, V> {

	private K key;
	private V value;
	
	public MyDictionary(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return this.value;
	}

}
