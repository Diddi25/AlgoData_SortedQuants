import java.util.Random;

public class GenerateArrays {

    public static int[] generateUnsorted(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt();
        }
        return array;
    }

    public static int[] generateSorted(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] += new Random().nextInt(10) + 1;
        }
        return array;
    }
}
