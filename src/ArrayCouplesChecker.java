import java.util.*;
import java.util.stream.Collectors;

public class ArrayCouplesChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // getting array from user

        System.out.println("Enter an array of even positive integers (comma-separated):");
        String input = scanner.nextLine();

        String[] inputArray = input.split(",");
        int[] arr = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        // using method
        String result = ArrayChallenge(arr);
        System.out.println(result);

        scanner.close();
    }

    public static String ArrayChallenge(int[] arr) {
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i += 2) {
            int num1 = arr[i];
            int num2 = arr[i + 1];
            for (int j = 2; j < arr.length; j += 2) {
                int reverseNum1 = arr[j];
                int reverseNum2 = arr[j + 1];
                if (num1 == reverseNum2 && num2 == reverseNum1) {
                    pairs.add(num1);
                    pairs.add(num2);
                    pairs.add(reverseNum2);
                    pairs.add(reverseNum1);
                }
            }
        }
        List<Integer> result = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        result.removeAll(pairs);
        if (result.isEmpty()) {
            return "yes";
        } else {
            return result.toString();
        }
    }
}
