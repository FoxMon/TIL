package baekMath.mathPrime;

public class Main {
    public static void isPrime(int number) { // 에라토스테네스 체
        boolean[] target = new boolean[number + 1];
        target[0] = target[1] = true; // 0, 1 소수 ㄴㄴ

        for(int i = 2; i * i <= number; i++) { // 2부터 배수인 놈들 확인
            if(!target[i]) {
                for(int j = i * i; j <= number; j += i) { // 약수 가진 놈들은 아님
                    target[j] = true;
                }
            }
        }
    }
}
