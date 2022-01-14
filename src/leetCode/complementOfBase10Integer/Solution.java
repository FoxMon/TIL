package leetCode.complementOfBase10Integer;

public class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        char[] ch = binary.toCharArray(); // 1 0 1
        int result = 0;
        int index = 0;

        for(int i = ch.length - 1; i >= 0; i--) {
            if(ch[i] == '1') {
                result += 0;
            } else {
                result = result + (int)Math.pow(2, index);
            }
            index++;
        }

        return result;
    }
}
