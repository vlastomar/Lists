import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int size = firstPlayer.size();
        for (int i = 0; i < size ; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
            if (firstPlayer.get(i) > secondPlayer.get(i)){
                firstPlayer.add(firstPlayer.get(i));
                firstPlayer.add(secondPlayer.get(i));
                firstPlayer.remove(i);
                secondPlayer.remove(i);
            }else if (firstPlayer.get(i) < secondPlayer.get(i)){
                secondPlayer.add(secondPlayer.get(i));
                secondPlayer.add(firstPlayer.get(i));
                firstPlayer.remove(i);
                secondPlayer.remove(i);
            }else if (firstPlayer.get(i).equals(secondPlayer.get(i))){
                firstPlayer.remove(i);
                secondPlayer.remove(i);

            }
            i = -1;
        }
        int sum = 0;
        boolean check = false;
        if (firstPlayer.isEmpty()){
            for(int num : secondPlayer){
                sum += num;
            }
        }else if (secondPlayer.isEmpty()){
            for(int num : firstPlayer){
                sum += num;
                check = true;
            }
        }
        if (check){
            System.out.println("First player wins! Sum: " + sum);
        }else {
            System.out.println("Second player wins! Sum: " + sum);
        }

    }
}
