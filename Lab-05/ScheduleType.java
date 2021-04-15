/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class ScheduleType {

    public int timeQuantum;
    public float totalTurnAroundTime = 0, totalWaitingTime = 0, totalIdleTime = 0;
    public int[] burstRemaining = new int[100], isCompleted = new int[100];

    public void calculateSJFP(Process[] process, int jobCount) {
        int start = 0, total = 0;
        boolean[] flag = new boolean[jobCount];
        while (true) {
            int count = jobCount, min = 999;
            if (total == jobCount) break;
            for (int i = 0; i < jobCount; i++) {
                if (process[i].getArrivalTime() <= start && !flag[i] && process[i].getDuplicateBurstTime() < min) {
                    min = process[i].getDuplicateBurstTime();
                    count = i;
                }
            }
            if (count == jobCount) start++;
            else {
                process[count].setDuplicateBurstTime(process[count].getDuplicateBurstTime() - 1);
                start++;
                if (process[count].getDuplicateBurstTime() == 0) {
                    process[count].setCompletionTime(start);
                    flag[count] = true;
                    total++;
                }
            }
        }
        for (int i = 0; i < jobCount; i++) {
            process[i].setTurnAroundTime(process[i].getCompletionTime() - process[i].getArrivalTime());
            process[i].setWaitingTime(process[i].getTurnAroundTime() - process[i].getBurstTime());
            totalTurnAroundTime += process[i].getTurnAroundTime();
            totalWaitingTime += process[i].getWaitingTime();
        }
    }

    public void prioritySchedule(Process[] process, int jobCount) {
        int start = 0;
        int completed = 0;
        int previous = 0;
        burstRemaining = new int[jobCount];
        for (int i = 0; i < jobCount; i++) {
            burstRemaining[i] = process[i].getBurstTime();
        }

        while (completed != jobCount) {
            int count = -1;
            int max = -1;
            for (int i = 0; i < jobCount; i++) {
                if (process[i].getArrivalTime() <= start && isCompleted[i] == 0) {
                    if (process[i].getPriority() > max) {
                        max = process[i].getPriority();
                        count = i;
                    }
                    if (process[i].getPriority() == max) {
                        if (process[i].getArrivalTime() < process[count].getArrivalTime()) {
                            max = process[i].getPriority();
                            count = i;
                        }
                    }
                }
            }

            if (count != -1) {
                if (burstRemaining[count] == process[count].getBurstTime()) {
                    process[count].setStartTime(start);
                    totalIdleTime += process[count].getStartTime() - previous;
                }
                burstRemaining[count] -= 1;
                start++;
                previous = start;

                if (burstRemaining[count] == 0) {
                    process[count].setCompletionTime(start);
                    process[count].setTurnAroundTime(process[count].getCompletionTime() - process[count].getArrivalTime());
                    process[count].setWaitingTime(process[count].getTurnAroundTime() - process[count].getBurstTime());

                    totalTurnAroundTime += process[count].getTurnAroundTime();
                    totalWaitingTime += process[count].getWaitingTime();
                    isCompleted[count] = 1;
                    completed++;
                }
            } else {
                start++;
            }
        }

        int minArrivalTime = 10000000;
        int maxCompletionTime = -1;
        for (int i = 0; i < jobCount; i++) {
            minArrivalTime = Integer.min(minArrivalTime, process[i].getArrivalTime());
            maxCompletionTime = Integer.max(maxCompletionTime, process[i].getCompletionTime());
        }
    }

    public void roundRobin(Process[] process, int jobCount) {
        int start = 0;
        while (true) {
            boolean done = true;
            for (int i = 0; i < jobCount; i++) {
                if (process[i].getDuplicateBurstTime() > 0) {
                    done = false;
                    if (process[i].getDuplicateBurstTime() > timeQuantum) {
                        start += timeQuantum;
                        process[i].setDuplicateBurstTime(process[i].getDuplicateBurstTime() - timeQuantum);
                    } else {
                        start += process[i].getDuplicateBurstTime();
                        process[i].setWaitingTime(start - process[i].getBurstTime());
                        process[i].setDuplicateBurstTime(0);
                    }
                }
            }
            if (done) break;
        }
        for (int i = 0; i < jobCount; i++) {
            process[i].setTurnAroundTime(process[i].getBurstTime() + process[i].getWaitingTime());
            process[i].setCompletionTime(process[i].getTurnAroundTime() - process[i].getArrivalTime());
        }
        for (int i = 0; i < jobCount; i++) {
            totalTurnAroundTime += process[i].getTurnAroundTime();
            totalWaitingTime += process[i].getWaitingTime();
        }
    }
}


