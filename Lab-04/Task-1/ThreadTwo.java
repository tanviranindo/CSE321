/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class ThreadTwo extends Thread {
    @Override
    public void run() {
        super.run();

        System.out.println("Thread Two: ");

        for (int i = 11; i <= 20; i++) {
            System.out.print(i == 20 ? i + "\n" : i + " ");
        }
    }
}
