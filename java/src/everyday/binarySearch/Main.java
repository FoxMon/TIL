package everyday.binarySearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[arrSize];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(arr[binarySearch(arr, target)] + "는 " + binarySearch(arr, target) + " index 에 있습니다.");
    }

    public static int binarySearch(int[] arr, int target) {
        int mid;
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;

            if(target == arr[mid]) {
                return mid;
            }

            if(target < arr[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1; // fail
    }
}
