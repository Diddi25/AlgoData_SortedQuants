public class EvenEvenBetterAlgorithm {
    public static long linearDuplicatesSearch(int[] array1, int[] array2) {
        int pointer_1 = 0;
        int pointer_2 = 0;

        long t0 = System.nanoTime();
        while(pointer_1 < (array1.length) && pointer_2  < (array2.length) ){
            if(array1[pointer_1] == array2[pointer_2]) {
                long t2 = System.nanoTime();
                return t2 - t0;
            } else if (array1[pointer_1] < array2[pointer_2]){
                pointer_1++;
            } else {
                pointer_2++;
            }
        }
        long t1 = System.nanoTime();

        return t1 - t0;
    }
}
