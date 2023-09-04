
public class Main {

    public static void main(String[] args) {
        int[] array1 = GenerateArrays.generateSorted(10);
        int[] array2 = GenerateArrays.generateSorted(10);
        for(int element: array1) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();
        for(int element: array2) {
            System.out.print(element + " ");
        }
        System.out.println();

        boolean response = EvenBetterAlgorithm.findDuplicatesInTwo(array1, array2);
        System.out.println(response);
    }

}