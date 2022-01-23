package listBirthdays;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Dates {
    public LocalDate dateOfBirth;
    public Period period;
    public LocalDate today;
    public Dates(LocalDate dateOfBirth, LocalDate today) {
        this.today = LocalDate.now();
        this.dateOfBirth = dateOfBirth;
    }

    public Dates(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String dates(LocalDate dateOfBirth) {
        this.dateOfBirth = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        return dateOfBirth.format(formatter);
    }

    public boolean compareDates(int defaultPeriod, LocalDate today, LocalDate... dates) {
        for (LocalDate date : dates) {
            long period = ChronoUnit.DAYS.between(today.minusYears(today.getYear()), date.minusYears(date.getYear()));
           if (period <= defaultPeriod && period >= 0) {
                System.out.println("До " + date.getDayOfMonth() + " " + date.getMonth() + " осталось: " + period);
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "день рождения: " + dateOfBirth +
                ", период по умолчанию: " + period +
                ",  сегодня: " + today;
    }
}
