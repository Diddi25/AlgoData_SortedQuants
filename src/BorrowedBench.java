import java.util.Random;

class BorrowedBench {

    private static float tries = 1000;
    private static float min = Float.POSITIVE_INFINITY;

    public static void main(String[] arg) {
        benchmark();
    }

    private static void linear(int[] array, float[] index) {
        for (int i = 0; i < index.length ; i++) {
            Linear.search(array, index[i]);
        }
    }

    private static void binary(int[] array, float[] index) {
        for (int i = 0; i < index.length ; i++) {
            BinarySearch.search(array, index[i]);
        }
    }

    private static long evenBetter(int[] array1, int[] array2) {
       return EvenEvenBetterAlgorithm.linearDuplicatesSearch(array1, array2);
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

    public static float[] keys(int loop, int n) {
        Random random = new Random();
        float[] keys = new float[loop];
        for (int i = 0; i < loop ; i++) {
            keys[i] = random.nextInt(n*5);
        }
        return keys;
    }
    
    private static void benchmark() {
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%14s\n", "n", "linear", "binary", "even-better");
        for (int n : sizes) {
            float loop = 10000;
            int[] array1 = sorted(n);
            int[] array2 = sorted(n);
            float[] index = keys(10000, n);

            System.out.printf("%8d", n);
            restoreMin();
            float min1 = benchmarkLinear(array1, index);
            System.out.printf("%8.0f", (min1/loop));
            restoreMin();
            float min2 = benchmarkBinary(array1, index);
            System.out.printf("%8.0f", (min2/loop));
            restoreMin();
            float min3 = benchmarkEvenBetter(array1, array2);
            float result = (min3/loop);
            System.out.printf("%8.0f\n", result);
        }
    }
    private static long takeTimer() {
        return System.nanoTime();
    }
    private static float benchmarkLinear(int[] array, float[] keys) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            linear(array, keys);
            long t1 = takeTimer();
            float t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }
    private static float benchmarkBinary(int[] array1, float[] keys) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            binary(array1, keys);
            long t1 = takeTimer();
            float t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }
    private static float benchmarkEvenBetter(int[] array1, int[] array2) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            return evenBetter(array1, array2);
            //long t1 = takeTimer();
            //if (!hej)
                //min = -1;
            //float t = (t1 - t0);
            //if (t < min)
                //min = t;
        }
        return -1;
    }

    private static void restoreMin() {
        min = Float.POSITIVE_INFINITY;
    }
}
