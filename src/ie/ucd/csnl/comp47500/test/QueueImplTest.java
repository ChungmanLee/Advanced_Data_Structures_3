package ie.ucd.csnl.comp47500.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;



import ie.ucd.csnl.comp47500.api.Entry;
import ie.ucd.csnl.comp47500.impl.UnsortedSeqPriorityQueue;
import ie.ucd.csnl.comp47500.impl.AbstractPriorityQueue.PQEntry;
import ie.ucd.csnl.comp47500.impl.HeapPriorityQueue;
import ie.ucd.csnl.comp47500.impl.SortedSeqPriorityQueue;

class QueueImplTest {

	@Test
    public void testSortedSeqPriorityQueue() {
        // Creating a priority queue of integers
        SortedSeqPriorityQueue<Integer, String> intPriorityQueue = new SortedSeqPriorityQueue<>();
        intPriorityQueue.insert(5, "Five");
        intPriorityQueue.insert(2, "Two");
        intPriorityQueue.insert(8, "Eight");
        
        // Testing min() and removeMin()
        assertEquals("Minimum element", "Two", intPriorityQueue.min().getValue());
        assertEquals("Removing minimum element", "Two", intPriorityQueue.removeMin().getValue());
        assertEquals("Minimum element after removal", "Five", intPriorityQueue.min().getValue());
        
        // Creating a priority queue of strings
        SortedSeqPriorityQueue<String, Integer> stringPriorityQueue = new SortedSeqPriorityQueue<>();
        stringPriorityQueue.insert("apple", 5);
        stringPriorityQueue.insert("banana", 2);
        stringPriorityQueue.insert("orange", 8);
        
        // Testing min() and removeMin()
        assertEquals("Minimum element", "apple", stringPriorityQueue.min().getKey());
        assertEquals("Removing minimum element", "apple", stringPriorityQueue.removeMin().getKey());
        assertEquals("Minimum element after removal", "banana", stringPriorityQueue.min().getKey());
        
        // Creating a priority queue from a list of entries
        List<Entry<String, Integer>> entryList = Arrays.asList(
            new PQEntry<>("one", 1),
            new PQEntry<>("two", 2),
            new PQEntry<>("three", 3)
        );
        SortedSeqPriorityQueue<String, Integer> entryPriorityQueue = new SortedSeqPriorityQueue<>(entryList);
        
        // Testing size() and insert()
        assertEquals("Size of entryPriorityQueue", 3, entryPriorityQueue.size());
        entryPriorityQueue.insert("four", 4);
        assertEquals("Size of entryPriorityQueue after insertion", 4, entryPriorityQueue.size());
    }
	
	
	@Test
    public void testHeapPriorityQueue() {
        // Creating a priority queue of integers
        HeapPriorityQueue<Integer, String> intPriorityQueue = new HeapPriorityQueue<>();
        intPriorityQueue.insert(5, "Five");
        intPriorityQueue.insert(2, "Two");
        intPriorityQueue.insert(8, "Eight");
        
        // Testing min() and removeMin()
        assertEquals("Minimum element", "Two", intPriorityQueue.min().getValue());
        assertEquals("Removing minimum element", "Two", intPriorityQueue.removeMin().getValue());
        assertEquals("Minimum element after removal", "Five", intPriorityQueue.min().getValue());
        
        // Creating a priority queue of strings
        HeapPriorityQueue<String, Integer> stringPriorityQueue = new HeapPriorityQueue<>();
        stringPriorityQueue.insert("apple", 5);
        stringPriorityQueue.insert("banana", 2);
        stringPriorityQueue.insert("orange", 8);
        
        // Testing min() and removeMin()
        assertEquals("Minimum element", "apple", stringPriorityQueue.min().getKey());
        assertEquals("Removing minimum element", "apple", stringPriorityQueue.removeMin().getKey());
        assertEquals("Minimum element after removal", "banana", stringPriorityQueue.min().getKey());
        
        String[] keys= {"two", "four", "eight"};
        Integer[] values= {2, 4, 8};
        HeapPriorityQueue<String, Integer> entryPriorityQueue = new HeapPriorityQueue<>(keys, values);
        
        // Testing size() and insert()
        assertEquals("Size of entryPriorityQueue", 3, entryPriorityQueue.size());
        entryPriorityQueue.insert("six", 6);
        assertEquals("Size of entryPriorityQueue after insertion", 4, entryPriorityQueue.size());
        
        
        // Testing min() and removeMin()
        assertEquals("Minimum element", "eight", entryPriorityQueue.min().getKey());
        assertEquals("Removing minimum element", "eight", entryPriorityQueue.removeMin().getKey());
        assertEquals("Minimum element after removal", "four", entryPriorityQueue.min().getKey());
    }
	
	
	@Test
    public void testUnsortedSeqPriorityQueueIntegers() {
        UnsortedSeqPriorityQueue<Integer, String> intPriorityQueue = new UnsortedSeqPriorityQueue<>();
        intPriorityQueue.insert(5, "Five");
        intPriorityQueue.insert(2, "Two");
        intPriorityQueue.insert(8, "Eight");
        
        assertEquals("Minimum element", "Two", intPriorityQueue.min().getValue());
        assertEquals("Removing minimum element", "Two", intPriorityQueue.removeMin().getValue());
        assertEquals("Minimum element after removal", "Five", intPriorityQueue.min().getValue());
    }

    @Test
    public void testUnsortedSeqPriorityQueueStrings() {
        UnsortedSeqPriorityQueue<String, Integer> stringPriorityQueue = new UnsortedSeqPriorityQueue<>();
        stringPriorityQueue.insert("apple", 5);
        stringPriorityQueue.insert("banana", 2);
        stringPriorityQueue.insert("orange", 8);
        
        assertEquals("Minimum element", "apple", stringPriorityQueue.min().getKey());
        assertEquals("Removing minimum element", "apple", stringPriorityQueue.removeMin().getKey());
        assertEquals("Minimum element after removal", "banana", stringPriorityQueue.min().getKey());
    }

    @Test
    public void testUnsortedSeqPriorityQueueEntries() {
        List<Entry<String, Integer>> entryList = Arrays.asList(
            new PQEntry<>("one", 1),
            new PQEntry<>("two", 2),
            new PQEntry<>("three", 3)
        );
        UnsortedSeqPriorityQueue<String, Integer> entryPriorityQueue = new UnsortedSeqPriorityQueue<>(entryList);
        
        assertEquals("Size of entryPriorityQueue", 3, entryPriorityQueue.size());
        entryPriorityQueue.insert("four", 4);
        assertEquals("Size of entryPriorityQueue after insertion", 4, entryPriorityQueue.size());
    }
    
    
    

}
