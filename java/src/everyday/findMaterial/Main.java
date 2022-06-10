package everyday.findMaterial;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int materialCount = scanner.nextInt();
        int[] materials = new int[materialCount];

        for(int i = 0; i < materials.length; i++) {
            materials[i] = scanner.nextInt();
        }

        int findCount = scanner.nextInt();
        int[] finds = new int[findCount];

        for(int i = 0; i < finds.length; i++) {
            finds[i] = scanner.nextInt();
        }

        Arrays.sort(materials);

        for(int i = 0; i < finds.length; i++) {
            if(findMaterial(materials, finds[i]) == -1) {
                stringBuilder.append("no ");
            } else {
                stringBuilder.append("yes ");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    public static int findMaterial(int[] materials, int target) {
        int mid;
        int startIndex = 0;
        int endIndex = materials.length - 1;

        while(startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;

            if(materials[mid] == target) { // good
                return mid;
            }

            if(target < materials[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1; // fail
    }
}
