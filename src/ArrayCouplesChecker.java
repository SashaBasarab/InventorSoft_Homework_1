import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> pairs = new HashMap<>();

        // if a couple exists, I delete it from map and find other elements which don't have a cople
        for (int i = 0; i < arr.length; i += 2) {
            int num1 = arr[i];
            int num2 = arr[i + 1];

            if (pairs.containsKey(num2) && pairs.get(num2) == num1) {
                pairs.remove(num2);
            } else {
                pairs.put(num1, num2);
            }
        }
        // if the map is empty, there are no elements without couple
        if (pairs.isEmpty()) {
            return "yes";
        } else { // if it's not empty I just print it to the console
            StringBuilder incorrectPairs = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
                incorrectPairs.append(entry.getKey()).append(",").append(entry.getValue()).append(",");
            }
            incorrectPairs.deleteCharAt(incorrectPairs.length() - 1); // Removing the last comma
            return incorrectPairs.toString();
        }
    }
}
