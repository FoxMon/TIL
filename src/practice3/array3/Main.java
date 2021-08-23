package practice3.array3;

public class Main {
    public static void main(String[] args) {
        int[][][] _3d_arr = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                {{19, 20, 21}, {22, 23, 24} , {25, 26, 27}}
        };

        for(int i = 0; i < _3d_arr.length; i++) {
            for(int j = 0; j < _3d_arr[i].length; j++) {
                for(int k = 0; k < _3d_arr[i][j].length; k++) {
                    System.out.print(_3d_arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
