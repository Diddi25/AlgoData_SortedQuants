public class BinarySearch {

    public static boolean binarySearch(int[] array, int key) {

        int mid = array.length / 2;

        for (int i = 0; i < array.length; i++) {
            if (mid > array.length || mid < 0) {
                return false;
            }
            if (key == array[mid]) {
                return true;
            } else if (key < array[mid]){
                mid = mid/2;
            } else {
                mid += mid/2;
            }
        }
        return false;
    }
}
