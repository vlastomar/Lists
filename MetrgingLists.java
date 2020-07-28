import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MetrgingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numberFinal = new ArrayList<>();
        //int diffLists = 0;

        if (numbers1.size() < numbers2.size()){
            //transferNumbers(numbers1, numbers2, numberFinal);
            for (int i = 0; i < numbers1.size(); i++) {
                numberFinal.add(numbers1.get(i));
                numberFinal.add(numbers2.get(i));
            }
            for (int i = numbers1.size(); i < numbers2.size() ; i++) {
                numberFinal.add(numbers2.get(i));
            }
            //diffLists = numbers2.size() - numbers1.size();
        }else {
            for (int i = 0; i < numbers2.size(); i++) {
                numberFinal.add(numbers1.get(i));
                numberFinal.add(numbers2.get(i));
            }
            for (int i = numbers2.size() ; i < numbers1.size() ; i++) {
                numberFinal.add(numbers1.get(i));
            }
            //transferNumbers(numbers2, numbers1, numberFinal);
            //diffLists = numbers1.size() - numbers2.size();
        }
        for(int num : numberFinal){
            System.out.print(num + " ");
        }


    }

    /*public static List<Integer> transferNumbers(List<Integer> numbers1, List<Integer> numbers2, List<Integer> numberFinal) {

        for (int i = 0; i < numbers1.size(); i++) {
            numberFinal.add(numbers1.get(i));
            numberFinal.add(numbers2.get(i));
        }
        return numberFinal;
    }*/

}
