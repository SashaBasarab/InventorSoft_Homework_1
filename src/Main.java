import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 4, 5, 4, 4, 1, 3, 3};
        int counter = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayListWithoutCouples = new ArrayList<>();
        ArrayList<Integer> couplesIndexes = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            for (int j = i + 2; j < arr.length - 1; j++) {
                int reversedFirst = arr[j];
                int reversedSecond = arr[j + 1];
                if (first == reversedSecond && second == reversedFirst) {
                    System.out.println("yes");
                    counter++;
                    arrayList.add(first);
                    arrayList.add(second);
                    arrayList.add(reversedFirst);
                    arrayList.add(reversedSecond);
                    couplesIndexes.add(i);
                    couplesIndexes.add(i + 1);
                    couplesIndexes.add(j);
                    couplesIndexes.add(j + 1);
                } else {
//                    arrayList.add(reversedFirst);
//                    arrayList.add(reversedSecond);
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < couplesIndexes.size() - 1; j++) {
                if (i != couplesIndexes.get(j)) {
                    arrayListWithoutCouples.add(arr[i]);
                }
            }
        }
        System.out.println(counter);
        System.out.println(arrayListWithoutCouples.toString());
    }
}