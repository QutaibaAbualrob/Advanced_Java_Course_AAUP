class ReadArrThread extends Thread {
    String fn;
    int[] arr;

    public ReadArrThread(String fileName) {
        this.fn = fileName;
    }

    public void run() {
        try (BufferedReader bufr = new BufferedReader(new FileReader(fn))) {
            String line = bufr.readLine();
            String[] data = line.split(" ");
            arr = new Integer[data.length];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

public class Quiz2_Thread_Class_Join {

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String f1 = bufr.readLine();
        String f2 = bufr.readLine();

        ReadArrThread t1 = new ReadArrThread(f1);
        ReadArrThread t2 = new ReadArrThread(f2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int[] arr1 = t1.arr;
        int[] arr2 = t2.arr;

        int size = arr1.length + arr2.length;
        int[] finalArr = new int[size];

         for (int i = 0; i < arr1.length; i++) {
            finalArr[i] = arr1[i];
        }

        for (int i = arr1.length, j = 0; i < size; i++, j++) {
            finalArr[i] = arr2[j];
        }

        
    }
}


