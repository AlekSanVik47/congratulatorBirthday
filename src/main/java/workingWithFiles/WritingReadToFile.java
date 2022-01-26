package workingWithFiles;

import listBirthdays.Employee;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Map;

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

    @Override
    public void inputFileToMap(Map<Employee, LocalDate> listBirthdays, Path input) {
        try {
            File fileBirthdays = new File(String.valueOf(input));
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileBirthdays));
            outputStream.writeObject(listBirthdays);
            outputStream.close();
            System.out.println(listBirthdays);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void outputFile(Path outFile) {
        try {
            FileInputStream inputStream = new FileInputStream(String.valueOf(outFile));
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
