public class BinarySearch {

    public static boolean binarySearch(int[] array, int key) {
        int min = 0;
        int mid = array.length / 2;
        int max = array.length - 1;

        for (int i = 0; i < max + 1; i++) {
            if(array[mid] == key) {
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
