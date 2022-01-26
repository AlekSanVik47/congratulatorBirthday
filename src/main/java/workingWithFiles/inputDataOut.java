package workingWithFiles;

import listBirthdays.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Map;

public interface inputDataOut {
    void inputFileToText(Map<Employee, String> listBirthdays, Path input) throws IOException;

    void inputFileToMap(Map<Employee, LocalDate> listBirthdays, Path input) throws IOException;

    void bufferedReaderInput(File file) throws IOException;

    void outputFile(Path outFile);
}
