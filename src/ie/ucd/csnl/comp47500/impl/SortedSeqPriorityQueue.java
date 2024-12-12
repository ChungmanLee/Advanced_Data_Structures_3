package ie.ucd.csnl.comp47500.impl;

import java.util.ArrayList;
import java.util.List;

import ie.ucd.csnl.comp47500.api.Entry;

public class SortedSeqPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	
	private List<Entry<K, V>> sortedQueue = new ArrayList<>();
	
	public SortedSeqPriorityQueue() {
		super();
	}
	
	public SortedSeqPriorityQueue(List<Entry<K, V>> inputList) {
		super();
		for(Entry<K, V> entry: inputList) {
			insert(entry.getKey(), entry.getValue());
		}
		
	}

	@Override
	public int size() {
		return sortedQueue.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
	    PQEntry<K, V> newEntry = new PQEntry<>(key, value);
	    
	    // If the sortedQueue is empty, simply add the new entry
	    if (sortedQueue.isEmpty()) {
	        sortedQueue.add(newEntry);
	        return newEntry;
	    }
	    
	    // Iterate through the sortedQueue to find the correct position to insert the new entry
	    int index = 0;
	    while (index < sortedQueue.size() && compare(newEntry, sortedQueue.get(index)) > 0) {
	        index++;
	    }
	    
	    // Insert the new entry at the correct position
	    sortedQueue.add(index, newEntry);
	    
	    return newEntry;
	}


	@Override
	public Entry<K, V> min() {
		return this.sortedQueue.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		return this.sortedQueue.remove(0);
	}

	public void clear() {
		sortedQueue.clear();
	}
	
	public void print() {
		for(Entry<K, V> entry: sortedQueue) {
			System.out.println(entry.getKey()+" :"+entry.getValue());
		}
	}

}
