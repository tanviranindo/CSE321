/**
 * @Name: Tanvir Rahman
 * @StudentID: 19101268
 */

import java.util.Scanner;

public class TaskThree {
    public static int[] manualInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = input.nextInt();
        int[] arr = new int[length];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = manualInput();
        int[] arr = {5, 4, 6, 8, 4, 1, 8, 2, 8, 2, 8, 4, 21, 5, 41, 51, 51, 5, 1, 54, 54, 51};
        //Given Array
        System.out.print("Given Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] + "\n" : arr[i] + " ");
        }
        QuickSort quickSort = new QuickSort(arr, 0, arr.length - 1);
        quickSort.start();
        try {
            quickSort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Sorted Array
        System.out.print("Multi-threaded quick-sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] + "\n" : arr[i] + " ");
        }
    }

}
