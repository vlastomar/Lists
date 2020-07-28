import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
            List<String> words =  new ArrayList<>();

        for (int i = 0; i < number ; i++) {
            words.add(scan.nextLine());
        }
        Collections.sort(words);
        int count = 1;
        for(String word : words){
            System.out.println(count + "." + word);
            count++;
        }
    }
}
