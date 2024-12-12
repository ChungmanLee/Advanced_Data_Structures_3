package ie.ucd.csnl.comp47500.impl;

import java.util.ArrayList;
import java.util.List;

import ie.ucd.csnl.comp47500.api.Entry;

public class UnsortedSeqPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>{
	
	private List<Entry<K, V>> unsortedQueue = new ArrayList<>();

	@Override
	public int size() {
		return unsortedQueue.size();
	}
	
	public UnsortedSeqPriorityQueue() {
		super();
	}
	
	public void clear() {
		unsortedQueue.clear();
	}
	
	public UnsortedSeqPriorityQueue(List<Entry<K,V>> inputList) {
		super();
		for(Entry<K, V> entry : inputList) {
			PQEntry<K, V> newEntry = new PQEntry<>(entry.getKey(),entry.getValue());
			unsortedQueue.add(newEntry);
		}
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		PQEntry<K, V> newEntry= new PQEntry<>(key,value);
		unsortedQueue.add(newEntry);
		return newEntry;
	}

	@Override
	public Entry<K, V> min() {
		if(isEmpty()) {
			throw new UnsupportedOperationException("Queue is Empty");
		}
		Entry<K, V> min = unsortedQueue.get(0);
		for(Entry<K, V> entry : unsortedQueue) {
			min=compare(entry, min)<0? entry:min;
		}
		return min;
	}

	@Override
	public Entry<K, V> removeMin() {
		Entry<K, V> min = min();
		unsortedQueue.remove(min);
		return min;
	}

}
