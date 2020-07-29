import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String symbols = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> symbolsList = new ArrayList<>();

        for (int i = 0; i < symbols.length() ; i++) {
            if (symbols.charAt(i) > 47 && symbols.charAt(i) < 58){
                int temp = Integer.parseInt (String.valueOf(symbols.charAt(i)));
                numbers.add(temp);
            }else{
                symbolsList.add(symbols.charAt(i));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        List<Character> finalS = new ArrayList<>();

        for (int i = 0; i < numbers.size() ; i++) {
            if (i % 2 ==0){
                takeList.add(numbers.get(i));
            }else{
                skipList.add(numbers.get(i));
            }
        }
            int counter = 0;
        for (int i = 0; i <takeList.size() ; i++) {
            for (int j = counter; j < takeList.get(i) +
                    counter ; j++) {
                if (takeList.get(i) +
                        counter <= symbolsList.size()){
                    finalS.add(symbolsList.get(j));
                }

            }

            counter += takeList.get(i) + skipList.get(i);
            if (counter > symbolsList.size() ){
                counter = symbolsList.size();
            }

        }
        for(Character secretWord : finalS){
            System.out.print(secretWord);
        }

    }
}
