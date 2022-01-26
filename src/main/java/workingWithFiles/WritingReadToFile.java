package workingWithFiles;

import listBirthdays.Birthdays;
import listBirthdays.Dates;
import listBirthdays.Employee;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.ofPattern;

public class WritingReadToFile implements inputDataOut {


    @Override
    public void inputFileToText(Map<Employee, String> listBirthdays, Path input) {
        try {
            File fileBirthdays = new File(String.valueOf(input));
            FileOutputStream fos = new FileOutputStream(fileBirthdays);
            PrintWriter printWriter = new PrintWriter(fos);
            for (Map.Entry<Employee, String> entry : listBirthdays.entrySet()) {
                printWriter.println(entry.getKey() + " " + entry.getValue());
            }
            printWriter.flush();
            printWriter.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bufferedReaderInput(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }

    public String outFile(Path outFile) {
        try {
            Path file = Paths.get(String.valueOf(outFile));
            FileInputStream inputStream = new FileInputStream(String.valueOf(file));
            inputStream.read();
            Scanner in = new Scanner(inputStream);
            Map<Employee, String> employeeStringMap = new HashMap<>();

            inputStream.close();
            System.out.println(employeeStringMap);
            return String.valueOf(employeeStringMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void textInfo(String text, Path filePath) throws IOException {

    }

    @Override
    public String outputFile(Path outFile) throws IOException {
        return null;
    }


    public static void main(String[] args) throws IOException {
        WritingReadToFile writing = new WritingReadToFile();
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

    private static void printListConsole(Map<Employee, String> allList) {
        for (Map.Entry<Employee, String> entry : allList.entrySet()) {
            System.out.printf(" %20s день рождения %s%n", entry.getKey(), entry.getValue());
        }
    }
}
