import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuiniCoursePlannig {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> initialSchedule = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        while (true){

            List<String> command = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());
            if ("course start".equals(command.get(0))){
                for (int i = 0; i < initialSchedule.size() ; i++) {
                    System.out.println((i + 1) + "." + initialSchedule.get(i) );
                }
                break;
            }
            switch (command.get(0)){
                case "Add":
                    if (!initialSchedule.contains(command.get(1))){
                        initialSchedule.add(command.get(1));
                    }
                    break;
                case "Insert" :
                    if (!initialSchedule.contains(command.get(1))){
                        initialSchedule.add(Integer.parseInt(command.get(2)), command.get(1));
                    }
                    break;
                case "Remove":
                    if (initialSchedule.contains(command.get(1))){
                        initialSchedule.remove(command.get(1));
                        if (initialSchedule.contains(command.get(1) + "-" + "Exercise")){
                            initialSchedule.remove(command.get(1) + "-" + "Exercise");
                        }
                    }

                    break;
                case "Swap":
                    int placeFirst = 0;
                    int placeSecond = 0;
                    if (initialSchedule.contains(command.get(1)) && initialSchedule.contains(command.get(2))){
                        for (int i = 0; i < initialSchedule.size(); i++) {
                            if (command.get(1).equals(initialSchedule.get(i))){
                                placeFirst = i;
                            }
                            if (command.get(2).equals(initialSchedule.get(i))){
                                placeSecond = i;
                            }
                        }
                        initialSchedule.set(placeFirst, command.get(2));
                        if (initialSchedule.contains(command.get(2) + "-" + "Exercise")){
                            initialSchedule.add(placeFirst + 1, command.get(2) + "-" + "Exercise");
                            //initialSchedule.remove(placeSecond + 1);
                            for (int i = placeSecond; i < initialSchedule.size() ; i++) {
                                if ((command.get(2) + "-" + "Exercise").equals(initialSchedule.get(i))){
                                    initialSchedule.remove(i);
                                    break;
                                }
                            }
                        }
                        for (int i = placeSecond; i < initialSchedule.size() ; i++) {
                            if (command.get(2).equals(initialSchedule.get(i))){
                                initialSchedule.set(i, command.get(1));
                            }
                        }

                        if (initialSchedule.contains(command.get(1) + "-" + "Exercise")){
                            for (int i = placeSecond; i < initialSchedule.size(); i++) {
                                if (command.get(1).equals(initialSchedule.get(i))){
                                    initialSchedule.add(i +1, command.get(1) + "-" + "Exercise");
                                    break;
                                }

                            }
                            for (int i = placeFirst; i < initialSchedule.size() ; i++) {
                                if ((command.get(1) + "-" + "Exercise").equals(initialSchedule.get(i))){
                                    initialSchedule.remove(i);
                                    break;
                                }
                            }

                        }
                    }
                    break;
                case "Exercise":
                    if (initialSchedule.contains(command.get(1))){
                        int index = 0;
                        for (int i = 0; i < initialSchedule.size() ; i++) {
                            if (command.get(1).equals(initialSchedule.get(i))){
                                index = i;
                            }
                        }
                         if (!initialSchedule.contains(command.get(1) + "-" + "Exercise")){
                             initialSchedule.add(index+1, command.get(1) + "-" + "Exercise");
                         }
                    }else   if (!initialSchedule.contains(command.get(1))){
                        initialSchedule.add(command.get(1));
                        initialSchedule.add(command.get(1) + "-" + "Exercise");
                    }
                    break;
            }
        }
    }
}
