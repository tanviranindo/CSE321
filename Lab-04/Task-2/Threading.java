/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class Threading extends Thread {
    public static int divisorCount = 0;
    public static int largestNumber = 0;
    int start;
    int end;

    public Threading(int start, int finish) {
        this.start = start;
        end = finish;
    }

    public int divisorCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        return count;
    }

    public int getNumber() {
        return largestNumber;
    }

    public int getNumberOfDivisors() {
        return divisorCount;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            int tempDivisorCount = divisorCount(i);
            if (divisorCount < tempDivisorCount) {
                largestNumber = i;
                divisorCount = tempDivisorCount;
            }
        }
    }
}