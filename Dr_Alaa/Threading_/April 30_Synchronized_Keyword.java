
package javaapplication1;

import java.io.*;

class PrintValues{
  

    public PrintValues() {
        
    }
    
    void print(int id) throws Exception{
           for (int i=0;i<10;i++)
            System.out.println("unsynchronized area "+i+"\t"+id);
        synchronized(this){
        for (int i=0;i<10;i++)
            System.out.println("before sleep "+i+"\t"+id);
        if (id==1)
            Thread.sleep(5000);
        for (int i=0;i<10;i++)
            System.out.println(id+" "+i);
        }
       
        
    }
    
    
}
class TestThread extends Thread{
    String id;

    public TestThread(String id) {
        this.id = id;
    }
    
    
    public void run(){
        synchronized (System.out){
        System.out.print(id+ " inside run");
        System.out.println(" second line");
        }
        
    }
}
class ReadFile extends Thread{
   int id;
     PrintValues obj;
    public ReadFile(int id,   PrintValues obj ) {
        this.id = id;
        this.obj=obj;
    }
  
    public void run(){
        try{
      
//          if (id==1)
//            obj.print(id);
//          else if (id==2)
//            obj.print(id);
//          else
              obj.print(id);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
    
}

public class JavaApplication1 {


    

    public static void main(String[] args) throws Exception{
        //  PrintValues obj1  = new PrintValues();
          //  PrintValues obj2  = new PrintValues();
            //  PrintValues obj3  = new PrintValues();
//   ReadFile t1 = new ReadFile(1,obj1);
//   ReadFile t2 = new ReadFile(2,obj1);
//   ReadFile t3 = new ReadFile(3,obj1);
//  t1.start();
//  t2.start();
//  t3.start();

TestThread t1 = new TestThread("Thr1");
TestThread t2 = new TestThread("Thr2");
t1.start();
t2.start();


    }
    
}
