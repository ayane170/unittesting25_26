package week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Elevator {

    public int[]  activeButtons(String badge,int currentLevel){
        if (currentLevel <-2 || currentLevel > 10){
            throw new IllegalArgumentException("Ongeldig huidig verdieping : " + currentLevel);
        }
        if (badge == null)
            throw new IllegalArgumentException("Geen badge : Lift niet toegestaan!");

        Set<Integer>allowed = new HashSet<>();

        if (isStaff(badge)){
            for (int f = -2; f <= 10; f++){
                allowed.add(f);
            }
        }else {
            int floor = firstDigitalOfRoom(badge);
            allowed.add(0);
            allowed.add(10);
            if (floor <1 || floor > 9){
                throw new IllegalArgumentException("Ongeldig kamerverdieping uit badge : " + floor);
            }
            allowed.add(floor);
        }
        if (!allowed.contains(currentLevel)){
            throw new IllegalStateException("Alarm:gebruiker op een niet toegelaten verdieping " + currentLevel);
        }
        allowed.remove(currentLevel);

        int[] result = allowed.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }


    private Boolean isStaff(String badge){
        return "S".equalsIgnoreCase(badge.trim());
    }

    private int firstDigitalOfRoom(String badge){
        if (badge == null || !Character.isDigit(badge.charAt(0))){
            throw new IllegalArgumentException("Geen badge : Lift niet toegestaan!");
        }
        return Character.getNumericValue(badge.charAt(0));
    }
}



