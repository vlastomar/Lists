import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> arrayS = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> newArray = new ArrayList<>();
        List<String> finalArr = new ArrayList<>();

       for (int i = arrayS.size() - 1; i >= 0; i--) {
           newArray.add(arrayS.get(i));
        }
        for (int i = 0; i < newArray.size(); i++) {
            arrayS = Arrays.stream(newArray.get(i).split(" ")).collect(Collectors.toList());
            for (int j = 0; j <arrayS.size() ; j++) {
                finalArr.add(arrayS.get(j));
            }
        }
        for (int i = 0; i <finalArr.size() ; i++) {
            if (finalArr.get(i).equals("")){
                finalArr.remove(i);
                i = -1;
            }

        }

        for (String S : finalArr){
            System.out.print(S + " ");
        }

    }
}
