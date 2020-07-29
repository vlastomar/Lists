import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numb = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> finalN = new ArrayList<>();
        int positionBomb = 0;
        boolean check = true;
while (true) {
    check = true;
    for (int i = 0; i < numbers.size(); i++) {
        if (numb.get(0).equals(numbers.get(i))) {
            positionBomb = i;
            check = false;
            break;
        }
    }
    if (check){
        break;
    }
    finalN = new ArrayList<>();
    int power = 0;
    power = positionBomb - numb.get(1);
    if (power > 0) {
        for (int i = 0; i < power; i++) {
            finalN.add(numbers.get(i));
        }
    }
    power = positionBomb + numb.get(1);
    if (power < numbers.size() - 1) {
        for (int i = power + 1; i < numbers.size(); i++) {
            finalN.add(numbers.get(i));
        }
    }
    numbers = finalN;

}
        int power = 0;
        for(int num : finalN){
            power += num;
        }

        System.out.println(power);
    }
}
