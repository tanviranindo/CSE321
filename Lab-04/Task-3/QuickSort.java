/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

public class QuickSort extends Thread {
    private final int low;
    private final int high;
    private final int[] arr;

    public QuickSort(int[] arr, int low, int high) {
        this.low = low;
        this.high = high;
        this.arr = arr;
    }

    public int partition(int[] arr, int low, int high) {
        int max = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= max) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    @Override
    public void run() {
        if (low < high) {
            int index = partition(arr, low, high);
            QuickSort left = new QuickSort(arr, low, index - 1);
            left.start();
            QuickSort right = new QuickSort(arr, index + 1, high);
            right.start();
            try {
                left.join();
                right.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
