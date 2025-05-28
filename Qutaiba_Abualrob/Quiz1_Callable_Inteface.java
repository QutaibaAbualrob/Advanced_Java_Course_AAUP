package callable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.*;

class CalculateNumbers implements Callable<String> {
    String fileName = "";
    int sum = 0;

    public CalculateNumbers(String n) {
        fileName = n;
    }

    @Override
    public String call() {
        String result = "";
        try {
            BufferedReader buffr = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = buffr.readLine()) != null) {
                var data = line.split(" ");
                int avg = (Integer.parseInt(data[1]) + Integer.parseInt(data[2]) + Integer.parseInt(data[3])) / 3;
                result += data[0] + " " + avg + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

public class Callable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int n = 10;
        CalculateNumbers[] nums = new CalculateNumbers[n];
        Future<String>[] rs = new Future[n];
        ExecutorService service = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++) {
            nums[i] = new CalculateNumbers("data" + i + ".txt");
            rs[i] = service.submit(nums[i]);
        }

        PrintWriter pw = new PrintWriter(System.out, true);
        for (int i = 0; i < n; i++) {
            pw.println("Name and mark of student: " + rs[i].get());
        }

        service.shutdown();
    }
}