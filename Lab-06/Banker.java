
import java.util.*;

class Banker {
    static int n, m;
    static int[] safe = new int[n + 10];

    public static boolean safety(int[] available, int[][] allocation, int[][] need, int n, int m, int[][] changeInAvailable) {

        boolean[] checkSafe = new boolean[n];

        for (int i = 0; i < n; i++) checkSafe[i] = false;

        int check = 0;
        int check1 = 0;
        do {
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                if (!checkSafe[i]) {
                    for (int j = 0; j < m; j++) {
                        if (available[j] < need[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = 0; j < m; j++) {
                            available[j] = available[j] + allocation[i][j];
                            changeInAvailable[check][j] = available[j];
                        }
                        safe[check] = i;
                        check++;
                        checkSafe[i] = true;
                    }
                }
            }
            check1++;
        } while (check < n && check1 < n);
        return check <= n;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\terabaka\\Documents\\GitHub\\CSE321\\Lab-06\\input.txt");
        Scanner input = new Scanner(file);

        // System.out.println("Enter no. of processes");
        n = input.nextInt();
        // System.out.println("Enter no. of resources:");
        m = input.nextInt();

        // System.out.println("Enter maximum matrix:");
        int[][] max = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                // System.out.println("Enter maximum instances of resource " + j + " for process
                // " + i);
                max[i][j] = input.nextInt();

            }

        // System.out.println("Enter allocation matrix:");
        int[][] allocation = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                // System.out.println("Enter allocated instances of resource " + j + " for
                // process " + i);
                allocation[i][j] = input.nextInt();

            }

        int[] available = new int[m];
        for (int i = 0; i < m; i++) {
            // System.out.println("Enter no. of available instances of resource " + i);
            available[i] = input.nextInt();
        }
        
        input.close();

        int[][] need = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }

        int[][] changeInAvailable = new int[n][m];
        System.out.println("Need matrix is: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.println();
        }

        if (safety(available, allocation, need, n, m, changeInAvailable)) {
            System.out.println("\nSafe sequence is :");
            for (int i = 0; i < n; i++) {
                System.out.print((char) ('A' + safe[i]) + " ");
            }
            System.out.println();
            System.out.println("Change in available resource matrix : ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(changeInAvailable[i][j] + " ");
                }
                System.out.println();
            }
        } else System.out.println("\nSystem is in unsafe state");
    }
}
