/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class Process {
    int id;
    int priority;
    int burstTime;
    int duplicateBurstTime;
    int startTime;
    int arrivalTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() { return priority; }

    public void setPriority(int priority) { this.priority = priority; }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setDuplicateBurstTime(int burstTime) {
        this.duplicateBurstTime = burstTime;
    }

    public int getDuplicateBurstTime() {
        return duplicateBurstTime;
    }

    public int getStartTime() { return startTime; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
