import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {

            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = -1;
            }

        }
        /*String output = "";
        for (Double i : numbers) {
            output += new DecimalFormat("0.#").format(i) + " ";
        }
        System.out.println(output);*/
       String output = printByDelimeters(numbers, " ");
        System.out.println(output);
    }
    public static String printByDelimeters(List<Double> numb, String emptiSpace){
       String out = "";
       for(Double num : numb){
           out += (new DecimalFormat("0.#").format(num) + emptiSpace);

       }
        return out;

    }
}
