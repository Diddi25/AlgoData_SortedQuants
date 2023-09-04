public class JohnsSolution {

    public static boolean binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if(array[middle] == value) {
                return true;
            }
            if(value < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return false;
    }
}
