package ie.ucd.csnl.comp47500;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ie.ucd.csnl.comp47500.api.Job;
import ie.ucd.csnl.comp47500.constant.Message;
import ie.ucd.csnl.comp47500.impl.HeapPriorityQueue;
import ie.ucd.csnl.comp47500.impl.SortedSeqPriorityQueue;
import ie.ucd.csnl.comp47500.impl.UnsortedSeqPriorityQueue;

public class Main {


  public List<Job> readOrdersFromFile(String filePath) {
        
		List<Job> jobs = new ArrayList<>();
		Integer orderNbr, priority;
        String[] jobData;
		String station, task, assignedTo;

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
					jobData = line.split(",");
					station = jobData[0];
                    task = jobData[1];
					orderNbr = Integer.parseInt(jobData[2]);
                    assignedTo = jobData[3];
                    priority = Integer.parseInt(jobData[4]);
					
					Job order = new Job(station, task, orderNbr, assignedTo, priority);

					jobs.add(order);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return jobs;
	}

    // Main function
    public static void main(String[] args) {
        Main ob = new Main();
        

        String[] files = { "order_input_1.txt", "order_input_2.txt", "order_input_3.txt", "order_input_4.txt",
                "order_input_5.txt"};
        String[] stations = { "clothing", "card printing", "photo making", "mug building", "pens printing" };
        // Test heapPQ


        System.out.println("--------------------Executing for Heaps-------------------------");
        for (int i = 0; i < files.length; i++) {
            
            long startTime = System.currentTimeMillis();
            HeapPriorityQueue<Integer, Job> heapPQ = new HeapPriorityQueue<>();
            List<Job> jobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + files[i]);
            long orderLength = 0l;
            orderLength = jobs.size();

            for (Job job : jobs) {
				heapPQ.insert(job.getPriority(), job);
			}
            
            System.out.println("\nInitial Size: " + heapPQ.size());
            //System.out.println("Min: " + "Key" +heapPQ.min().getKey() + " value" + heapPQ.min().getValue());
            //remove top 8 elements
            for (int j = 0; j < 9; j++) {
                heapPQ.removeMin();
            }
            System.out.println("Size After Removal: " + heapPQ.size());
            // get min
            System.out.println("Min - " + "Key: " +heapPQ.min().getKey() + " value: " + heapPQ.min().getValue());

            //insert 10 more elements
            List<Job> randomjobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + "order_input_random.txt");

            long randomStartTime = System.currentTimeMillis();
            for (Job job : randomjobs) {
				heapPQ.insert(job.getPriority(), job);
			}
            long randomEndTime = System.currentTimeMillis();
            System.out.println("Time taken to insert 10 random elements in " + orderLength + " dataset " + (randomEndTime - randomStartTime) + "ms");

            //remoeve min
            heapPQ.removeMin();
            long endTime = System.currentTimeMillis();
            System.out.println("total execution Time taken for length " + jobs.size() + " is " + (endTime - startTime) + "ms");
        }

        System.out.println("\n--------------------Executing for SortedSeq-------------------------");
        for (int i = 0; i < files.length; i++) {
            
            long startTime = System.currentTimeMillis();
            SortedSeqPriorityQueue<Integer, Job> sortedSeqPQ = new SortedSeqPriorityQueue<>();
            List<Job> jobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + files[i]);
            long orderLength = 0l;
            orderLength = jobs.size();

            for (Job job : jobs) {
                sortedSeqPQ.insert(job.getPriority(), job);
            }

            System.out.println("\nInitial Size: " + sortedSeqPQ.size());
            //System.out.println("Min: " + "Key" +heapPQ.min().getKey() + " value" + heapPQ.min().getValue());
            //remove top 8 elements
            for (int j = 0; j < 9; j++) {
                sortedSeqPQ.removeMin();
            }
            System.out.println("Size After Removal: " + sortedSeqPQ.size());
            // get min
            System.out.println("Min- " + "Key: " +sortedSeqPQ.min().getKey() + " value: " + sortedSeqPQ.min().getValue());

            //insert 10 more elements
            List<Job> randomjobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + "order_input_random.txt");

            long randomStartTime = System.currentTimeMillis();
            for (Job job : randomjobs) {
				sortedSeqPQ.insert(job.getPriority(), job);
			}
            long randomEndTime = System.currentTimeMillis();
            System.out.println("Time taken to insert 10 random elements in " + orderLength + " dataset " + (randomEndTime - randomStartTime) + "ms");


            //remoeve min
            sortedSeqPQ.removeMin();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for length " + jobs.size() + " is " + (endTime - startTime) + "ms");
        }

        System.out.println("--------------------Executing for UnsortedSeq-------------------------");
        for (int i = 0; i < files.length; i++) {
            
            long startTime = System.currentTimeMillis();
            UnsortedSeqPriorityQueue<Integer, Job> unsortedSeqPQ = new UnsortedSeqPriorityQueue<>();
            List<Job> jobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + files[i]);
            long orderLength = 0l;
            orderLength = jobs.size();

            for (Job job : jobs) {
                unsortedSeqPQ.insert(job.getPriority(), job);
            }

            System.out.println("\nInitial Size: " + unsortedSeqPQ.size());
            //System.out.println("Min: " + "Key" +heapPQ.min().getKey() + " value" + heapPQ.min().getValue());
            //remove top 8 elements
            for (int j = 0; j < 9; j++) {
                unsortedSeqPQ.removeMin();
            }
            System.out.println("Size After Removal: " + unsortedSeqPQ.size());
            // get min
            System.out.println("Min- " + "Key: " +unsortedSeqPQ.min().getKey() + " value: " + unsortedSeqPQ.min().getValue());

            //insert 10 more elements
            List<Job> randomjobs = ob.readOrdersFromFile(Message.RESOURCE_PATH + "order_input_random.txt");

            long randomStartTime = System.currentTimeMillis();
            for (Job job : randomjobs) {
				unsortedSeqPQ.insert(job.getPriority(), job);
			}
            long randomEndTime = System.currentTimeMillis();
            System.out.println("Time taken to insert 10 random elements in " + orderLength + " dataset " + (randomEndTime - randomStartTime) + "ms");
            

            //remoeve min
            unsortedSeqPQ.removeMin();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for length " + jobs.size() + " is " + (endTime - startTime) + "ms");
        }

       
    }
}


