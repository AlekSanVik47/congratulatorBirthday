package workingWithFiles;

import listBirthdays.Employee;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface inpDataOut {
    String inputFile(Map<Employee, String> listBirthdays, Path input) throws IOException;
    void textInfo(String text, Path filePath) throws IOException;
    String outputFile(Path outFile) throws IOException;
}
