package everyday.makeMoney;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moneyCount = scanner.nextInt();
        int target = scanner.nextInt();
        int[] money = new int[moneyCount + 1];
        int[] targets = new int[target + 1];

        for(int i = 1; i <= moneyCount; i++) {
            money[i] = scanner.nextInt();
        }

        for(int i = 1; i <= target; i++) {
            targets[i] = 10001;
        }

        Arrays.sort(money);

        for(int i = 1; i <= moneyCount; i++) {
            for(int j = money[i]; j <= target; j++) {
                if(targets[j - money[i]] != 10001) {
                    targets[j] = Math.min(targets[j], targets[j - money[i]] + 1);
                }
            }
        }

        if(targets[target] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(targets[target]);
        }
    }
}
