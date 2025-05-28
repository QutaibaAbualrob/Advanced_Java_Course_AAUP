package quiz2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Readarr implements Callable<Integer[]> {
    String fn;
    Integer[] arr;

    public Readarr(String fileName) {
        fn = fileName;
    }

    public Integer[] call() {
        try {
            BufferedReader bufr = new BufferedReader(new FileReader(fn));
            String line = bufr.readLine();
            String[] data = line.split(" ");
            arr = new Integer[data.length];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
        } catch (Exception e) {
        }

        return arr;
    }
}

public class Quiz2_Callable_Interface {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String f1 = bufr.readLine();
        String f2 = bufr.readLine();

        Readarr a1 = new Readarr(f1);
        Readarr a2 = new Readarr(f2);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer[]> fr1 = service.submit(a1);
        Future<Integer[]> fr2 = service.submit(a2);

        Integer[] arr1 = fr1.get();
        Integer[] arr2 = fr2.get();
        service.shutdown();
        int size = arr1.length + arr2.length;

        Integer[] finalArr = new Integer[size];

        for (int i = 0; i < arr1.length; i++) {
            finalArr[i] = arr1[i];
        }

        for (int i = arr1.length, j = 0; i < size; i++, j++) {
            finalArr[i] = arr2[j];
        }

    }

}
