package listBirthdays;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Birthdays implements IBirthdays {
    private final Map<Employee, Set<LocalDate>> listBirthdayForEmployees;

    public Birthdays() {
        listBirthdayForEmployees = new HashMap<>();
    }

    public Set<LocalDate> getBirthday(Employee employee) {
        return listBirthdayForEmployees.computeIfAbsent(employee, k -> new HashSet<>());
    }

    @Override
    public void addBirthday(Employee employee, LocalDate birthday) {
        Set<LocalDate> birthdays = getBirthday(employee);
        birthdays.add(birthday);
    }
    @Override
    public Set<LocalDate> get(Employee employee) {
        return getBirthday(employee);
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return listBirthdayForEmployees.keySet();
    }

    @Override
    public String toString() {
        return "День рождения сотрудников \n" +
                "------------------------\n" +
                listBirthdayForEmployees + "\n";

    }
}
