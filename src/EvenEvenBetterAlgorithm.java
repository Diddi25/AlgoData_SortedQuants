public class EvenEvenBetterAlgorithm {
    public static boolean linearDuplicatesSearch(int[] array1, int[] array2) {
        int pointer_1 = 0;
        int pointer_2 = 0;

        while(pointer_1 < (array1.length) && pointer_2  < (array2.length) ){
            if(array1[pointer_1] == array2[pointer_2]) {
                return true;
            } else if (array1[pointer_1] < array2[pointer_2]){
                pointer_1++;
            } else {
                pointer_2++;
            }
        }

        return false;
    }
}
