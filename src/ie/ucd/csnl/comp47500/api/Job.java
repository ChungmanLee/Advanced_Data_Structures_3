package ie.ucd.csnl.comp47500.api;

public class Job {
    private String workstation;
    private String task;
    private int priority;
    private String assignedTo;
    private int orderNbr;

    public Job(String workstation, String task, int priority, String assignedTo, int orderNbr) {
        this.workstation = workstation;
        this.task = task;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.orderNbr = orderNbr;
    }

    // Getters and Setters
    public String getWorkstation() {
        return workstation;
    }

  

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getorderNbr() {
        return orderNbr;
    }

    public void setorderNbr(int orderNbr) {
        this.orderNbr = orderNbr;
    }

    public int compareTo(Job other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Job{" +
                "workstation=" + workstation +
                ", task='" + task + '\'' +
                ", priority=" + priority +
                ", assignedTo='" + assignedTo + '\'' +
                ", orderNbr=" + orderNbr +
                '}';
    }
}
