package workingWithFiles;

import listBirthdays.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface inputDataOut {
    void inputFileToText(Map<Employee, String> listBirthdays, Path input) throws IOException;
    void bufferedReaderInput(File file) throws IOException;
    void textInfo(String text, Path filePath) throws IOException;
    String outputFile(Path outFile) throws IOException;
}
