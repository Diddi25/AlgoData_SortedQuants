public class EvenBetterAlgorithm {

    public static boolean findDuplicatesInTwo(int[] array1, int[] array2) {
        int min_array1 = 0;
        int min_array2 = 0;
        int max_array1 = array1.length - 1;
        int max_array2 = array2.length - 1;

        while(min_array1 <= max_array1 && min_array2 <= max_array2) {
            int mid_array1 = (min_array1 + max_array1) / 2;
            int mid_array2 = (min_array2 + max_array2) / 2;

            if (array2[mid_array2] == array1[mid_array1]) {
                return true;
            } else if (array2[mid_array2] < array1[mid_array1]) {
                min_array2 = mid_array2 + 1;
            } else {
                min_array1 = mid_array1 + 1;
            }
        }

        return false;
    }
}
