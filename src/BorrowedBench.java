import java.util.Random;

class BorrowedBench {

    private static float tries = 1000;
    private static float min = Float.POSITIVE_INFINITY;

    public static void main(String[] arg) {
        benchmark();
    }

    private static void linear(int[] array, int[] searchObjects) {
        for (int i = 0; i < searchObjects.length ; i++) {
            Linear.search(array, searchObjects[i]);
        }
    }

    private static void binary(int[] array, int[] searchObjects) {
        for (int i = 0; i < searchObjects.length ; i++) {
            BinarySearch.search(array, searchObjects[i]);
        }
    }

    private static boolean evenBetter(int[] array1, int[] array2) {
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
    public static int[] unsorted(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = new Random().nextInt(10);
        }
        return array;
    }

    public static int[] generateSearchObjects(int loop, int n) {
        Random random = new Random();
        int[] generateSearchObjects = new int[loop];
        for (int i = 0; i < loop ; i++) {
            generateSearchObjects[i] = random.nextInt(n*5);
        }
        return generateSearchObjects;
    }
    
    private static void benchmark() {
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%18s%18s%8s%8s%14s\n", "n", "linear sorted", "linear unsorted", "binary", "even-better");

        for (int n : sizes) {
            int loop = 10000;
            int[] array1 = sorted(n);
            int[] array2 = sorted(n);
            int[] array3 = unsorted(n);
            int[] searchObjects = generateSearchObjects(loop, n);

            System.out.printf("%8d", n);
            restoreMin();
            float min1 = benchmarkLinearSorted(array1, searchObjects);
            System.out.printf("%8.0f", (min1/loop));
            restoreMin();
            float min4 = benchmarkLinearUnsorted(array3, searchObjects);
            System.out.printf("%8.0f", (min4/loop));
            restoreMin();
            float min2 = benchmarkBinary(array1, searchObjects);
            System.out.printf("%8.0f", (min2/loop));
            restoreMin();
            float min3 = benchmarkEvenBetter(array1, array2);
            float result = (min3);
            //System.out.printf("%8.0f\n", result);
            System.out.println("    " + result);
        }
    }
    private static long takeTimer() {
        return System.nanoTime();
    }
    private static float benchmarkLinearSorted(int[] array, int[] searchObjects) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            linear(array, searchObjects);
            long t1 = takeTimer();
            float t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }
    private static float benchmarkLinearUnsorted(int[] array, int[] searchObjects) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            linear(array, searchObjects);
            long t1 = takeTimer();
            float t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }
    private static float benchmarkBinary(int[] array1, int[] searchObjects) {
        for (int i = 0; i < tries; i++) {
            long t0 = takeTimer();
            binary(array1, searchObjects);
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
            boolean hej = evenBetter(array1, array2);
            long t1 = takeTimer();
            //if (!hej)
                //min = -1;
            float t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }

    private static void restoreMin() {
        min = Float.POSITIVE_INFINITY;
    }
}
