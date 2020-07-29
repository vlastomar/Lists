
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        int maxNumberWagon = Integer.parseInt(scan.nextLine());

        while (true){
            List<String> input = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            if ("end".equals(input.get(0))){
                for (int num : wagons){
                    System.out.print(num + " ");
                }
                break;
            }
            if ("Add".equals(input.get(0))){
                wagons.add(Integer.parseInt(input.get(1)));
            }else{
                for (int i = 0; i < wagons.size(); i++) {
                    int temp = Integer.parseInt(input.get(0));
                    if (temp + wagons.get(i) <= maxNumberWagon){
                        wagons.set(i, wagons.get(i) + temp);
                        break;
                    }


                }
            }

        }


    }
}
