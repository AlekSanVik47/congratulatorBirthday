package workingWithFiles;

import listBirthdays.Birthdays;
import listBirthdays.Dates;
import listBirthdays.Employee;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ofPattern;

public class WritingToFile implements inpDataOut {

    @Override
    public String inputFile(Map<Employee, String> listBirthdays, Path input) throws IOException {
        File fileBirthdays = new File(String.valueOf(input));
        listBirthdays = new HashMap<>();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileBirthdays));
        out.writeObject(listBirthdays);
        out.close();

      /*  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileBirthdays));
        if (!listBirthdays.isEmpty()){
            bufferedWriter.write(String.valueOf(listBirthdays));
            bufferedWriter.close();
        }*/
        return String.valueOf(listBirthdays);
    }
    static void bufferedReaderInput(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
   /* public String outputFile(Path outFile) throws IOException {
        Path file = Paths.get(String.valueOf(outFile));
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        return String.join("\n", lines);
    }*/

    @Override
    public void textInfo(String text, Path filePath) throws IOException {

    }

    @Override
    public String outputFile(Path outFile) throws IOException {
        return null;
    }


    public static void main(String[] args) throws IOException {
        WritingToFile writing = new WritingToFile();
        LocalDate birtEmployee = LocalDate.of(1970, 1, 25);
        LocalDate birtEmployee1 = LocalDate.of(1965, 9, 15);
        LocalDate birtEmployee2 = LocalDate.of(1981, 2, 10);
        Dates date0 = new Dates(birtEmployee);
        Dates date1 = new Dates(birtEmployee1);
        Dates date2 = new Dates(birtEmployee2);
        birtEmployee.format(ofPattern("d MMM uuuu"));
        LocalDate today = LocalDate.now();

        Dates dates = new Dates(birtEmployee, today);
        int defaultPeriod = 30;
//        boolean f = dates.compareDates(defaultPeriod, today, birtEmployee, birtEmployee1, birtEmployee2);

        Birthdays birthdays = new Birthdays();
        Employee employee = new Employee("Василий", "Смирнов");
        Employee employee1 = new Employee("Федор", "Ветров");
        Employee employee2 = new Employee("Иван", "Иванов");
        Map<Employee, LocalDate> employeeLocalDateMap = new HashMap<>();


          /*  birthdays.addBirthday(employee, birtEmployee);
            birthdays.addBirthday(employee1, birtEmployee1);
            birthdays.addBirthday(employee2, birtEmployee2);*/
        
        System.out.println(employeeLocalDateMap);
        
    
                /*  birthdays.addBirthday(employee, birtEmployee);
        birthdays.addBirthday(employee1, birtEmployee1);
        birthdays.addBirthday(employee2, birtEmployee2);*/

/*
        Set<Employee> listEmployees = birthdays.getAllEmployees();
        for (Employee empl: listEmployees) {
            Set<LocalDate> birthd = birthdays.getBirthday(empl);
            for (LocalDate bday: birthd) {
                System.out.printf("%s %s%n", empl, birthd);
            }

        }
*/

//        System.out.println(birthdays.toString());

        Map<Employee, String> allList = new HashMap<>();
        allList.put(employee, date0.dates(birtEmployee));
        allList.put(employee1, date1.dates(birtEmployee1));
        allList.put(employee2, date2.dates(birtEmployee2));

//        printListConsole(allList);
//        writing.inputFile(allList, Path.of("/home/alexander-av/IdeaProjects/congratulator/birthdaysEmployees"));
    }

    private static void upcomingBirthdays(LocalDate birtEmployee, Dates dates, Birthdays birthdays) {
        int minPeriod = 30;
     /*   for (Birthdays bd: birthdays) {

        }*/
    /*    Map<Employee, LocalDate> upcomingBirthdays = new HashMap<>();

        for (Map.Entry<Employee, LocalDate> entry: upcomingBirthdays.entrySet()){
            if (dates.compareDates(minPeriod, birtEmployee)) {
                System.out.printf(" %20 День рождения в ближайшие %d дней%n %20s день рождения %s%n",
                        minPeriod, entry.getKey(), entry.getValue());
            }
        }*/
    }
    private static void printListConsole(Map<Employee, String> allList) {
        for (Map.Entry<Employee, String> entry: allList.entrySet()){
            System.out.printf(" %20s день рождения %s%n",entry.getKey(), entry.getValue());
        }
    }
}
