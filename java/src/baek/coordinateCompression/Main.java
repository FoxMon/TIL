package baek.coordinateCompression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        int numberCount = scanner.nextInt();
        int index = 0;
        int[] numbers = new int[numberCount];
        int[] sortNumbers = new int[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        sortNumbers = numbers.clone();
        Arrays.sort(sortNumbers);

        for(int number : sortNumbers) {
            if(!numberMap.containsKey(number)) {
                numberMap.put(number, index++);
            }
        }

        for(int number : numbers) {
            stringBuilder.append(numberMap.get(number) + " ");
        }

        System.out.println(stringBuilder.toString());
    }
}
