
package javaapplication1;

import java.io.*;

// in irder to use multithreading (parallelism) environment. Use one of the followings:
//1. Runnable interface
//2. Thread class
//3. Callable interface
class Test implements Runnable{
String id;
    public Test(String id) {
        this.id=id;
    }
    
   public void run(){
        for (int i=0;i<10;i++)
            System.out.println(id+" : "+i);
        
    }
}
class TestThread extends Thread{
String id;
    public TestThread(String id) {
        this.id=id;
    }
    
   public void run(){
        for (int i=0;i<10;i++)
            System.out.println(id+" : "+i);
        
    }
}

class ReadFile extends Thread{
    String fileName;
     boolean isFinished=false;
private int sum=0;

int getSum(){
    return sum;
}
    public ReadFile(String fileName) {
        this.fileName = fileName;
    }
    public void run(){
        try{
        String line;
        
            BufferedReader bufr = new BufferedReader(new FileReader(fileName));
        while ((line=bufr.readLine())!=null)
            
            sum += Integer.parseInt(line);
        }catch(Exception e){
            e.printStackTrace();
        }
        
       isFinished=true; 
        
    }
    
}

public class JavaApplication1 {

    
    public static void main(String[] args) throws Exception{
        
        ReadFile f1 = new ReadFile("d:\\1.txt");
        ReadFile f2 = new ReadFile("d:\\2.txt");
        f1.start();
        f2.start();
        
        while (!f1.isFinished || !f2.isFinished);// wait until ALL working threads have finished their work!
        
        
        System.out.println("File 1: "+f1.getSum());
        System.out.println("File 2: "+f2.getSum());
        
        
     
//        Thread t1 = new Thread (new Test("A"));
//        Thread t2 = new Thread(new Test("B"));
//    t1.start();
//    t2.start();
   

//
//TestThread tt1 = new TestThread("A");
//TestThread tt2 = new TestThread("B");
//TestThread tt3 = new TestThread("C");
//        tt1.start();
//        tt2.start();
//        tt3.start();
    }
    
}
