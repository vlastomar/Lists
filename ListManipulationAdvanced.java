

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            List<String> input = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

            if ("end".equals(input.get(0))){

                break;
            }
            switch (input.get(0)){
                case "Contains":
                    boolean checkList = numbers.contains(Integer.parseInt(input.get(1)));
                    if (checkList){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if ("even".equals(input.get(1))){
                        for(int num : numbers){
                            if (num % 2 == 0){
                                System.out.print(num + " ");
                            }
                        }
                    }else if ("odd".equals(input.get(1))){
                        for(int num : numbers){
                            if (num % 2 != 0){
                                System.out.print(num + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for(int num : numbers){
                         sum += num;
                    }
                    System.out.print(sum);
                    System.out.println();
                    break;
                case "Filter":
                     calculateFilter(numbers, input);
                    break;

            }
        }
    }
    public static void  calculateFilter(List<Integer> numb , List<String> inp){

        switch (inp.get(1)){
            case ">":
                for(int num : numb){
                    if (num > Integer.parseInt(inp.get(2))){
                        System.out.print(num + " ");
                    }
                }
                break;
            case "<" :
                for(int num : numb){
                    if (num < Integer.parseInt(inp.get(2))){
                        System.out.print(num + " ");
                    }
                }
                break;
            case "<=" :
                for(int num : numb){
                    if (num <= Integer.parseInt(inp.get(2))){
                        System.out.print(num + " ");
                    }
                }
                break;
            case ">=" :
                for(int num : numb){
                    if (num >= Integer.parseInt(inp.get(2))){
                        System.out.print(num + " ");
                    }
                }
                break;
        }
        System.out.println();
    }
}
