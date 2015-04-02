package a3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.UnsupportedOperationException;

@SuppressWarnings("unused")
public class HashTable<K, V> implements java.util.Map<K, V> {

	private int numElements = 0;
	private Node<K, V>[] buckets;
	private int loadFactor = 2;
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		this.buckets = (Node<K,V>[]) new Node[this.loadFactor];
	}
	
	@Override
	public int size() {
		return numElements;
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

	/**
	 * Returns the previous value of the given key in this hash table or null if it did not have one
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) {
		if (key == null) { // empty case
			return null;
		}
		V result = null;
		numElements++;
		double loadFactor = numElements / buckets.length;
		if (loadFactor > this.loadFactor) { // overload case
			// resize
			HashTable<K,V> newHashTable = new HashTable<K,V>();
			newHashTable.buckets = (Node<K,V>[]) new Node[this.buckets.length * this.loadFactor];
			Node<K,V> n;
			for (int i = 0; i < this.buckets.length; i++) {
				n = this.buckets[i];
				while (n != null) {
					newHashTable.put(n.key, n.value);
					n = n.next;
				}
			}
		} else { // normal case
			int i = key.hashCode();
			int j = i % this.buckets.length;
			Node<K,V> a = new Node<K,V>(key, value);
			result = this.get(key);
			a.next = this.buckets[j];
			this.buckets[j] = a;
		}
		return result;
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
