package listBirthdays;

import java.time.LocalDate;
import java.util.Set;

public interface IBirthdays {
    void addBirthday(Employee employee, LocalDate birthday);

    Set<LocalDate> get(Employee employee);

    Set<Employee> getAllEmployees();
}
