import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOrders = Integer.parseInt(scan.nextLine());
        List<String> peopleInParty = new ArrayList<>();

        for (int i = 0; i < numberOrders ; i++) {
            boolean checkAvailability = true;
            List<String> movementPeople = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            if ("not".equals(movementPeople.get(2))){
                for (int j = 0; j < peopleInParty.size() ; j++) {
                    if (movementPeople.get(0).equals(peopleInParty.get(j))){
                        peopleInParty.remove(j);
                        checkAvailability = false;
                        break;
                    }
                }
                if (checkAvailability){
                    System.out.println(movementPeople.get(0) + " " + "is not in the list!");
                }
            }else if ("going!".equals(movementPeople.get(2))){
                boolean checkInPart = true;
                for (int j = 0; j <peopleInParty.size() ; j++) {
                    if (movementPeople.get(0).equals(peopleInParty.get(j))){
                        System.out.println(movementPeople.get(0) + " " + "is already in the list!");
                        checkInPart = false;
                    }
                }
                if (checkInPart){
                    peopleInParty.add(movementPeople.get(0));
                }


            }
        }
        for(String num : peopleInParty){
            System.out.println(num);
        }
    }
}

