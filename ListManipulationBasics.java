import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!"end".equals(command)){
            //List<String> input = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String[] input = command.split(" ");
            /*if ("end".equals(input.get(0))){

                System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

                break;
            }*/
            int data1 = Integer.parseInt(input[1]);
            String token = input[0];
            switch (token){
                case "Add":
                    numbers.add(data1);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(data1));
                    break;
                case "RemoveAt":
                    numbers.remove(data1);
                    break;
                case "Insert":
                    int data2 = Integer.parseInt(input[2]);
                    numbers.add(data2, data1);
                    break;

            }
            command = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
