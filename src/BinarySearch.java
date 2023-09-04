public class BinarySearch {
    public static boolean search(int[] array, int value) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int middle = (min + max) / 2;

            if (array[middle] == value) {
                return true;
            } else if (value < array[middle]) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }

        return false;
    }
}
