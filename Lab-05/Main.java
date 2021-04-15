/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. SJF Scheduling\n2. Priority Scheduling\n3. Round Robin\n4. End Program");
            System.out.print("Select Scheduling Type: ");
            int type = input.nextInt();
            int timeQuantum = 0;
            if (type == 4) break;
            else if (type == 1 || type == 2 || type == 3) {
                System.out.print("Enter number of processes: ");
                int jobCount = input.nextInt();
                if (type == 3) {
                    System.out.print("Enter time quantum: ");
                    timeQuantum = input.nextInt();
                }
                System.out.println();
                Process[] process = new Process[jobCount];
                for (int i = 0; i < jobCount; i++) {
                    process[i] = new Process();
                    process[i].setId(i + 1);

                    if (type != 3) {
                        System.out.print("Enter arrival time of process " + process[i].getId() + ": ");
                        process[i].setArrivalTime(input.nextInt());
                    }

                    System.out.print("Enter burst time of process " + process[i].getId() + ": ");
                    int temp = input.nextInt();
                    process[i].setBurstTime(temp);
                    process[i].setDuplicateBurstTime(temp);
                    if (type == 2) {
                        System.out.print("Enter priority of process " + process[i].getId() + ": ");
                        process[i].setPriority(input.nextInt());
                    }
                }

                ScheduleType function = new ScheduleType();
                if (type == 1) {
                    function.calculateSJFP(process, jobCount);
                } else if (type == 2) {
                    function.prioritySchedule(process, jobCount);
                } else {
                    function.timeQuantum = timeQuantum;
                    function.roundRobin(process, jobCount);
                }

                TableGenerator table = new TableGenerator();
                table.generateTable(process, jobCount, type);

                System.out.println("Average Turn Around Time: " + (function.totalTurnAroundTime / jobCount));
                System.out.println("Average Waiting Time: " + (function.totalWaitingTime / jobCount));
                System.out.print("\n1. Choose Another\n2. End the program\nEnter option: ");
                int end = input.nextInt();
                while (end != 1 && end != 2) {
                    System.out.print("\n1. Choose Another\n2. End the program\nEnter option: ");
                    end = input.nextInt();
                }
                if (end == 2) break;
                System.out.println();
            } else {
                System.out.println("\nWrong type selected. Please try again!\n");
            }
        }
    }
}

