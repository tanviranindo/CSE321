/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class ThreadOne extends Thread {
    @Override
    public void run() {
        super.run();

        System.out.println("Thread One: ");

        for (int i = 1; i <= 10; i++) {
            System.out.print(i == 10 ? i + "\n" : i + " ");
        }

        System.out.println();

        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.start();

        try {
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 21; i <= 30; i++) {
            System.out.print(i == 30 ? i + "\n" : i + " ");
        }
    }
}
