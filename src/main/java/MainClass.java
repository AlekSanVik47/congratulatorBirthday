import listBirthdays.Birthdays;
import listBirthdays.Employee;
import listBirthdays.ListOfBirthdays;
import workingWithFiles.WritingReadToFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainClass {
    public int defaultPeriod;
    private String name, surname;
    public LocalDate dateBirthday;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ListOfBirthdays listOfBirthdays = new ListOfBirthdays();
        Birthdays birthdays = new Birthdays();
        Employee employee = new Employee("Василий", "Смирнов");
        Employee employee1 = new Employee("Федор", "Ветров");
        Employee employee2 = new Employee("Иван", "Иванов");

        LocalDate birtEmployee = LocalDate.of(1970, 1, 25);
        LocalDate birtEmployee1 = LocalDate.of(1965, 9, 15);
        LocalDate birtEmployee2 = LocalDate.of(1981, 2, 10);

        Map<Employee, LocalDate> listBirthdays = new HashMap<>();
        listBirthdays.put(employee, birtEmployee);
        listBirthdays.put(employee1, birtEmployee1);
        listBirthdays.put(employee2, birtEmployee2);
        ListOfBirthdays test = new ListOfBirthdays();

        String inPeriod = "Задайте период вывода дат в днях: ";
        int defaultPeriod;
        LocalDate today = LocalDate.now();

        System.out.println(inPeriod);
        Scanner in = new Scanner(System.in);
        defaultPeriod = parseInt(in.next());
        in.close();
        WritingReadToFile writing = new WritingReadToFile();


        Map<Employee, LocalDate> listBirth = listOfBirthdays.getList(defaultPeriod, today, listBirthdays);

        Map<Employee, String> listFormBirth = listOfBirthdays.formatList(defaultPeriod, today, listBirth);


        writing.inputFileToText(listFormBirth, Path.of("birthdaysEmployees"));

//        writing.bufferedReaderInput(new File("birthdaysEmployees")); // чтение из файла в строку


//        writing.inputFileToMap(listBirth, Path.of("fileMap")); // запись объекта в файл (Map)
//        writing.outputFile(Path.of("fileMap")); // чтение объекта из файла

    }

}
