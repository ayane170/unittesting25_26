package week2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class EmailInvalid {

    public Map<String, LocalDate>findClientsToFollowUp(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("lines is null or empty");
        }
        Map<String, LocalDate> latestByName = new HashMap<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] split = line.split(",");
            if (split.length != 3) continue;
            String name = split[0].trim();
            String email = split[1].trim();
            String dateStr = split[2].trim();

            if (!email.contains("@")) continue;

            LocalDate date;
            try {
                date = LocalDate.parse(dateStr);
            } catch (DateTimeException e) {
                //Date invalide -> ignorer
                continue;
            }
            //conserver la date la plus recente par client
            if (!latestByName.containsKey(name) || date.isAfter(latestByName.get(name))) {
                latestByName.put(name, date);
            }
        }

            //ne renvoyer que ceux dont le derniere date est strictment >1 an
            LocalDate cutoff = LocalDate.now().minusDays(1);
            Map<String, LocalDate> result = new HashMap<>();
            for (Map.Entry<String, LocalDate> e : latestByName.entrySet()) {
                if (e.getValue().isBefore(cutoff)) {
                result.put(e.getKey(), e.getValue());
            }
        }
        return result;
    }
    }

