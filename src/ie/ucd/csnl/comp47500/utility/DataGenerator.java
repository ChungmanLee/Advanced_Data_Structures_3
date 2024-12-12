package ie.ucd.csnl.comp47500.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class DataGenerator {
    private static final String[] STATIONS = {"clothing", "card printing", "photo making", "mug building", "pens printing"};
    private static final String[] TASKS = {
        "Assembly Line Work",
        "Quality Control Inspection",
        "Machine Operation",
        "Equipment Maintenance",
        "Material Handling",
        "Packaging",
        "Shipping and Receiving",
        "Inventory Management",
        "Safety Compliance",
        "Production Planning",
        "Product Design",
        "Process Improvement",
        "Supply Chain Management",
        "Customer Service",
        "Sales and Marketing",
        "Financial Planning and Budgeting",
        "Human Resources Management",
        "Training and Development",
        "Research and Development",
        "Environmental Compliance",
        "Waste Management",
        "Facility Management",
        "Strategic Planning",
        "Project Management",
        "IT Management and Support"
    };
    private static final String[] ASSIGNED_TO = {
        "Alex", "Taylor", "Jordan", "Morgan", "Charlie", "Sam", "Pat", "Jamie", "Casey", "Jesse",
        "Avery", "Riley", "Chris", "Dakota", "Drew", "Cameron", "Quinn", "Lee", "Skyler", "Logan",
        "Sydney", "Bailey", "Corey", "Andy", "Jay", "Sage", "Parker", "Shawn", "Kai", "Tyler",
        "Robin", "Kendall", "Reese", "Kelly", "Blake", "Hayden", "Terry", "Jessie", "Ash", "Devin",
        "Brook", "Adrian", "Jo", "Casey", "Dana", "Jamie", "Morgan", "Jean", "Jody", "Lynn",
        "Marion", "Dale", "Kim", "Shelby", "Shannon", "Courtney", "Jade", "Kerry", "Tracy", "Pat",
        "Jules", "Kris", "Frankie", "Brett", "Angel", "Sidney", "Remy", "Cody", "Joss", "Peyton",
        "Billy", "Bobby", "Danny", "Gabby", "Nicky", "Ricky", "Sammy", "Stevie", "Toby", "Tony",
        "Alexis", "Ali", "Ari", "Ashley", "Ashton", "Aubrey", "Austin", "Avery", "Bailey", "Blair",
        "Bobbie", "Brandy", "Brett", "Brooke", "Cameron", "Carmen", "Carroll", "Casey", "Cassidy", "Chandler"
    };


        /**
         * The main method is the entry point of the program.
         * It generates random data and writes it to a CSV file.
         * The generated data includes station, task, priority, assignedTo, and orderNumber.
         * The CSV file is named "output.csv" and is created in the current directory.
         * The method uses a try-with-resources block to automatically close the FileWriter.
         * If an IOException occurs, it is printed to the standard error stream.
         * After generating the data, the method prints "finished" to the standard output.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            try (FileWriter writer = new FileWriter("output.csv")) {
                Set<Integer> assignedPriorities = new HashSet<>();
                for (int i = 0; i < 1000000; i++) {
                    
                    String station = STATIONS[new Random().nextInt(STATIONS.length)]; 
                    String task = TASKS[new Random().nextInt(TASKS.length)];
                    int priority;
                    do {
                        priority = new Random().nextInt(1000000) + 1;
                    } while (assignedPriorities.contains(priority));

                    assignedPriorities.add(priority);

                    String assignedTo = ASSIGNED_TO[new Random().nextInt(ASSIGNED_TO.length)];
                    int orderNumber = new Random().nextInt(1000000) + 1;

                    writer.append(station).append(",")
                            .append(task).append(",")
                            .append(String.valueOf(priority)).append(",")
                            .append(assignedTo).append(",")
                            .append(String.valueOf(orderNumber)).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("finished");
        }
    }
