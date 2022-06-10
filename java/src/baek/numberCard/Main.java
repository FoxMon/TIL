package baek.numberCard;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cardCount = scanner.nextInt();
        int[] cards = new int[cardCount];

        for(int i = 0; i < cards.length; i++) {
            cards[i] = scanner.nextInt();
        }

        Arrays.sort(cards);
        int myCardCount = scanner.nextInt();
        int[] myCards = new int[myCardCount];

        for(int i = 0; i < myCards.length; i++) {
            myCards[i] = scanner.nextInt();
        }

        for(int i = 0; i < myCards.length; i++) {
            stringBuilder.append(findCardUpper(cards, myCards[i]) - findCardLower(cards, myCards[i])).append(" ");
        }

        System.out.println(stringBuilder.toString());
    }

    public static int findCardUpper(int[] cards, int target) {
        int startIndex = 0;
        int endIndex = cards.length - 1;
        int mid;

        while(startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;

            if(target < cards[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return startIndex;
    }

    public static int findCardLower(int[] cards, int target) {
        int startIndex = 0;
        int endIndex = cards.length - 1;
        int mid;

        while(startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;

            if(target <= cards[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return startIndex;
    }
}
