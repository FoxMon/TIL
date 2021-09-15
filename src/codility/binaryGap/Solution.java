package codility.binaryGap;

public class Solution {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        char[] binaryCharacter = binaryString.toCharArray();
        int gapMaxCount = 0;
        int gapLength = 0;

        for(char character : binaryCharacter) {
            if(character == '1') {
                if(gapLength > gapMaxCount) {
                    gapMaxCount = gapLength;
                    gapLength = 0;
                }
            } else {
                gapLength++;
            }
        }

        return gapMaxCount;
    }
}
