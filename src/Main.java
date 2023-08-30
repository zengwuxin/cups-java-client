
import java.io.*;


public class Main {

    public static void main(String []args) throws Exception {

        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("bash", "-c", "echo 'test using lp to print from java app' | lp -d hostname-printer -U java-app");
        try {
            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean flag = true;
        while (flag) {
            Thread.sleep(2000);
        }
    }
}