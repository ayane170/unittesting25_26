package week2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMaintenance {

    public Map<String, LocalDate> findCarsOneYearWithoutService(List<String> info){
        if (info == null || info.isEmpty())
            throw new IllegalArgumentException("info is null or empty");

        Map<String, LocalDate> carHistory = new HashMap<>();


        for (String history : info) {
            String[] split = history.split(",");
            String plate = split[0];
            LocalDate maintenanceDate = LocalDate.parse(split[1]);
             if (carHistory.containsKey(plate)){
                 if (maintenanceDate.isAfter(carHistory.get(plate))){
                     carHistory.put(plate, maintenanceDate);
                 }
             }else {
                 carHistory.put(plate, maintenanceDate);
             }
        }


        return carHistory.entrySet().stream().filter(entrey ->entrey.getValue().isBefore(LocalDate.now().minusYears(1))).collect(HashMap::new,(target,entry) -> target.put(entry.getKey(), entry.getValue()),HashMap::putAll);
    }
}
