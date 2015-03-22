package a3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.UnsupportedOperationException;

@SuppressWarnings("unused")
public class HashTable<K, V> implements java.util.Map<K, V> {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) { return true; } else { return false; }
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public V get(Object key) {
		return null;
	}

	@Override
	public V put(K key, V value) {
		return null;
	}

	@Override
	public V remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public Set<K> keySet() {
		return null;
	}

	
	/**
	 * It is not required that you implement the values() or entrySet() operations
	 **/
	@Override
	public Collection<V> values() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

}
