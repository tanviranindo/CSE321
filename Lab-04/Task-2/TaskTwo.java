/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class TaskTwo {
    public static void main(String[] args) {
        long startTime, endTime;

        //SingleThread
        startTime = System.currentTimeMillis();

        Threading singleThread = new Threading(1, 100000);
        singleThread.run();
        try {
            singleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();

        System.out.println("Single Thread - ");
        System.out.println("Time: " + (endTime - startTime) + " milliseconds ");
        System.out.println("Divisors Count: " + singleThread.getNumberOfDivisors());
        System.out.println("Largest Number Of Divisors:  " + singleThread.getNumber());
        System.out.println();

        //MultiThread
        startTime = System.currentTimeMillis();

        int length = 10;
        Threading[] multiThread = new Threading[length];
        for (int i = 0, j = 1; i < length; i++, j++) {
            multiThread[i] = new Threading(j, (j += 10000));
        }

        for (Threading thread : multiThread) {
            thread.start();
        }

        try {
            for (Threading thread : multiThread) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();

        System.out.println("Multi Thread - ");
        System.out.println("Time: " + (endTime - startTime) + " milliseconds ");
        System.out.println("Divisors Count: " + multiThread[multiThread.length - 1].getNumberOfDivisors());
        System.out.println("Largest Number Of Divisors:  " + multiThread[multiThread.length - 1].getNumber());
        System.out.println();
    }
}
