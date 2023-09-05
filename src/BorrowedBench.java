import java.util.Random;

class BorrowedBench {

    private static void linear(int[] array, int[] index) {
        for (int i = 0; i < index.length ; i++) {
            Linear.search(array, index[i]);
        }
    }

    private static void binary(int[] array, int[] index) {
        for (int i = 0; i < index.length ; i++) {
            BinarySearch.search(array, index[i]);
        }
    }

    private static void evenBetter(int[] array1, int[] array2) {
        EvenEvenBetterAlgorithm.linearDuplicatesSearch(array1, array2);
    }

    public static int[] sorted(int n) {
        Random random = new Random();
        int[] array = new int[n];
        int next = random.nextInt(10);

        for (int i = 0; i < n ; i++) {
            array[i] = next;
            next += random.nextInt(10) + 1 ;
        }
        return array;
    }

    public static int[] keys(int loop, int n) {
        Random random = new Random();
        int[] keys = new int[loop];
        for (int i = 0; i < loop ; i++) {
            keys[i] = random.nextInt(n*5);
        }
        return keys;
    }

    public static void main(String[] arg) {

        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%14s\n", "n", "linear", "binary", "even-better");
        for ( int n : sizes) {

            int loop = 10000;

            int[] array1 = sorted(n);
            int[] array2 = sorted(n);
            int[] index = keys(loop, n);

            System.out.printf("%8d", n);

            float k = 1000;

            float min = Float.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array1, index);
                long t1 = System.nanoTime();
                float t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Float.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array1, index);
                long t1 = System.nanoTime();
                float t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Float.POSITIVE_INFINITY;

            for (int i = 0; i < 5; i++) {
                long t0 = System.nanoTime();
                evenBetter(array1, array2);
                long t1 = System.nanoTime();
                float t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            float result = (min/loop);

            System.out.printf("%8.0f\n", result);
        }
    }
}
