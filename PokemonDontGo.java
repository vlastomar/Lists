import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> ditances = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (true){
            if (ditances.isEmpty()){
                System.out.println(sum);
                break;
            }
            int index = Integer.parseInt(scan.nextLine());
            int temp = 0;
            if (index < 0){
                index = 0;
                temp = ditances.get(index);
                sum += temp;
                ditances.set(0, ditances.get(ditances.size() - 1));
            }else if (index > ditances.size() - 1){
                index = ditances.size() - 1;
                temp = ditances.get(index);
                sum += temp;
                ditances.set(index, ditances.get(0));

            }else{
                temp = ditances.get(index);
                ditances.remove(index);
                sum += temp;
            }


            for (int i = 0; i < ditances.size() ; i++) {

                if (ditances.get(i) <= temp){
                    int increasedValue = temp + ditances.get(i);
                    ditances.set(i, increasedValue);
                }else{
                    int decreasedVlaue = ditances.get(i) - temp;
                    ditances.set(i, decreasedVlaue);
                }
            }
        }
    }
}
