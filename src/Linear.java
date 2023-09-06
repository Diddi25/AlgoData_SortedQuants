public class Linear {
    public static boolean search (int[] array, float key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == (key)) {
                return true;
            }
        }
        return false;
    }
}
