package codeexamplesfromslides;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        String[] coolNames = new String[] {"Jimmy", "Timmy", "Tommy"};
        coolNames[0] = "Tummy";
//        coolNames[3] = "Jenny"; // Exception! Array's can't grow

        int lengthOfArray = coolNames.length; // Will be 3

        for (var name: coolNames) {
            System.out.println(name);
        }

        List<String> otherCoolNames = new ArrayList<>();

        otherCoolNames.add("Jimmy");
        otherCoolNames.add("Timmy");
        otherCoolNames.add("Tommy");

        otherCoolNames.set(0, "Tummy");

        otherCoolNames.add("Jenny");

        int numberOfCoolNamesInTheList = otherCoolNames.size();

        for (var name: otherCoolNames) {
            System.out.println(name.hashCode());
        }

        List<String> CoolNames = List.of("Jimmy", "Timmy", "Tommy");

    }

}
