import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class Banker {
    public static int processes, resources;
    public static int[][] need;
    public static int[] safeSequence = new int[processes + 5];

    public static void needMatrix(int[][] max, int[][] allocation) {
        need = new int[processes][resources];
        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }

    public static boolean isSafe(int[] available, int[][] allocation, int[][] changedAvailable) {

        boolean[] safeCheck = new boolean[processes];

        int countOne = 0;
        int countTwo = 0;
        do {
            for (int i = 0; i < processes; i++) {
                boolean flag = true;
                if (!safeCheck[i]) {
                    for (int j = 0; j < resources; j++) {
                        if (available[j] < need[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = 0; j < resources; j++) {
                            available[j] += allocation[i][j];
                            changedAvailable[countOne][j] = available[j];
                        }
                        safeSequence[countOne] = i;
                        countOne++;
                        safeCheck[i] = true;
                    }
                }
            }
            countTwo++;
        } while (countOne < processes && countTwo < processes);
        return countOne <= processes;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\terabaka\\IdeaProjects\\CSE321\\Lab-06\\input.txt");
        Scanner input = new Scanner(file);

        processes = input.nextInt();
        resources = input.nextInt();

        int[][] max = new int[processes][resources];

        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                max[i][j] = input.nextInt();
            }
        }

        int[][] allocation = new int[processes][resources];

        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                allocation[i][j] = input.nextInt();
            }
        }

        int[] available = new int[resources];

        for (int i = 0; i < resources; i++) available[i] = input.nextInt();

        input.close();

        needMatrix(max, allocation);

        System.out.println("Need Matrix :");
        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                System.out.print(need[i][j] + (j == resources - 1 ? "\n" : " "));
            }
        }

        int[][] changedAvailable = new int[processes][resources];

        if (isSafe(available, allocation, changedAvailable)) {
            System.out.println("\nSafe sequence is :");
            for (int i = 0; i < processes; i++) {
                System.out.print((char) ('A' + safeSequence[i]) + (i == processes - 1 ? "" : " "));
            }

            System.out.println("\nChange in available resource matrix :");

            for (int i = 0; i < processes; i++) {
                for (int j = 0; j < resources; j++) {
                    System.out.print(changedAvailable[i][j] + (j == resources - 1 ? "\n" : " "));
                }
            }
        } else System.out.println("\nSystem is in unsafe state");
    }
}
