package listBirthdays;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ListOfBirthdays {
    private int defaultP;
    private LocalDate today = LocalDate.now();

    public Map<Employee, LocalDate> getList(int defaultPeriod, LocalDate today, Map<Employee, LocalDate> listBirthdays) {
        Map<Employee, LocalDate> list = new HashMap<>();
        for (Map.Entry<Employee, LocalDate> entry : listBirthdays.entrySet()) {
            long period = ChronoUnit.DAYS.between(today.minusYears(today.getYear()), entry.getValue().minusYears(entry.getValue().getYear()));
            if (period <= defaultPeriod && period >= 0) {
                list.put(entry.getKey(), entry.getValue());
            }
        }
        return list;
    }

    public Map<Employee, String> formatList(int defaultPeriod, LocalDate today, Map<Employee, LocalDate> formBirthday) {
        Map<Employee, String> form = new HashMap<>();
        System.out.printf("   День рождения за заданный период: %n%n");
        for (Map.Entry<Employee, LocalDate> employeeLocalDateMap : formBirthday.entrySet()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM");
            form.put(employeeLocalDateMap.getKey(), employeeLocalDateMap.getValue().format(formatter));
            System.out.printf("%20s день рождения %s%n",employeeLocalDateMap.getKey(), employeeLocalDateMap.getValue().format(formatter));
        }
        return form;
    }
}
