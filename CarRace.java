import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> carsTime = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        double timeLeft = 0;
        double timeRight = 0;

        for (int i = 0; i < carsTime.size()/2 ; i++) {
            timeLeft += carsTime.get(i);
            if (carsTime.get(i) == 0){
                timeLeft = timeLeft * 0.8;
            }
        }
        for (int i = carsTime.size() - 1; i > carsTime.size()/2 ; i--) {
            timeRight += carsTime.get(i);
            if (carsTime.get(i) == 0){
                timeRight = timeRight * 0.8;
            }
        }
        if (timeLeft < timeRight){
            System.out.printf("The winner is left with total time: %.1f", timeLeft);
        }else if (timeLeft > timeRight){
            System.out.printf("The winner is right with total time: %.1f", timeRight);
        }
    }
}
