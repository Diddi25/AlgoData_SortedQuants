
public class Main {

    public static void main(String[] args) {

        int n = 1;
        int k = 5;

        int[] testArray = BorrowedBench.keys(k, n);

        for (int i = 0; i < k; i++) {
            System.out.println(testArray[i]);
        }

    }

}