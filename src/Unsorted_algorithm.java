public class Unsorted_algorithm {

    public static boolean search_unsorted(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == (key)) {
                return true;
            }
        }
        return false;
    }

}
