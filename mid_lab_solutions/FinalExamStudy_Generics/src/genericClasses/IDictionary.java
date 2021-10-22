package genericClasses;

public interface IDictionary<K, V> {
	public K getKey();
	public V getValue(K key);
}
