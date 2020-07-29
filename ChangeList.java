import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        while (true){
            List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
            if ("end".equals(input.get(0))){
                for(int num : numbers){
                    System.out.print(num + " ");
                }
                break;
            }
            if ("Delete".equals(input.get(0))){
                for (int i = 0; i < numbers.size() ; i++) {
                    if (numbers.get(i) == Integer.parseInt(input.get(1))){
                        numbers.remove(i);
                        i=-1;
                    }
                }
                /*Integer temp = Integer.valueOf(input.get(1));
                while (numbers.contains(temp)){
                    numbers.remove(temp);
                }*/
            }else if ("Insert".equals(input.get(0))){
                int pos = Integer.parseInt(input.get(2));
                if (pos >= 0 && pos < numbers.size()) {
                    numbers.add(Integer.parseInt(input.get(2)), Integer.parseInt(input.get(1)));
                }
            }
        }

    }
}
