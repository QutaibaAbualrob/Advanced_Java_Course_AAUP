
package javaapplication1;

import java.io.*;
import java.util.concurrent.*;


class ReadFile implements Callable<Integer>{
 
    String fileName;
int sum=0;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }
  
    public Integer call(){
   try{
       BufferedReader bufr = new BufferedReader (new FileReader(fileName));
       String data;
       while ((data=bufr.readLine())!=null)
           sum += Integer.parseInt(data);
   
   }catch(Exception e){
       e.printStackTrace();
   }
          return sum;


        
    }
    
}

public class JavaApplication1 {

    public static void main(String[] args)throws Exception{
      ReadFile t1 = new ReadFile("d:\\1.txt");
      
       ReadFile t2 = new ReadFile("d:\\2.txt");

       
       ExecutorService service=Executors.newFixedThreadPool(2);
       Future <Integer>r1 = service.submit(t1);
       Future <Integer>r2 = service.submit(t2);
       
       
        System.out.println(r1.get());
        System.out.println(r2.get());
service.shutdown();
    }
    
}
