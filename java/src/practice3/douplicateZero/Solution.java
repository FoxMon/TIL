package practice3.douplicateZero;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int zero = 0;

        for(int number : arr) {
            if(number == 0) {
                zero++;
            }
        }

        for(int i = length - 1; i >= 0; i--) {
            int j = i + zero;

            if(arr[i] == 0) {
                if(j < length) {
                    arr[j] = 0;
                }

                zero--;
                j--;
            }

            if(j < length) {
                arr[j] = arr[i];
            }
        }
    }
}
