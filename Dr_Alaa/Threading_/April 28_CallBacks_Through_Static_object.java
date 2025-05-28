
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
JavaApplication1 obj;
int getSum(){
    return sum;
    
}
    public ReadFile(String fileName, JavaApplication1 o) {
        this.fileName = fileName;
        obj=o;
    }
    public void run(){
        try{
        String line;
        
            BufferedReader bufr = new BufferedReader(new FileReader(fileName));
        while ((line=bufr.readLine())!=null)
            
            sum += Integer.parseInt(line);
        obj.foo2(sum);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
       isFinished=true; 
        
    }
    
}

public class JavaApplication1 {

static void foo(int s){
    System.out.println(s);
}
    
void foo2(int s){
    System.out.println(s);
}
    public static void main(String[] args) throws Exception{
       JavaApplication1 temp =new JavaApplication1();
        ReadFile f1 = new ReadFile("d:\\1.txt",temp);
        ReadFile f2 = new ReadFile("d:\\2.txt",temp);
        f1.start();
        f2.start();
        
       
  
    }
    
}
