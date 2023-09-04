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
        int[] index = new int[loop];
        for (int i = 0; i < loop ; i++) {
            index[i] = random.nextInt(n*5);
        }
        return index;
    }


    public static void main(String[] arg) {

        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
        for ( int n : sizes) {

            int loop = 10000;

            int[] array = sorted(n);
            int[] index = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array, index);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, index);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f\n", (min/loop));
        }
    }
}
