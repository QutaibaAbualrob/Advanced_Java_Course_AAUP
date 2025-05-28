
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;



class ShowFrame extends JFrame{
    String x;
    ShowFrame(){
        //setSize(400,200);
        //setVisible(true);
        
       
        Toolkit kit=Toolkit.getDefaultToolkit();
       Dimension dim = kit.getScreenSize();
        this.setLocation(dim.width/4, dim.height/4);
        this.setSize(dim.width/2, dim.height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("this is my first frame");
        Container c = this.getContentPane();
        c.add(new MyPanel());
        
        this.setVisible(true);
        
    }
   
    private  class MyPanel extends JPanel implements ActionListener{
        
        
        JButton b1=new JButton("Start");
        JButton b2=new JButton("Start");
        JLabel l1 = new JLabel("0");
        JLabel l2 = new JLabel("0");
        Timer t1 = new Timer(1000,this);
           Timer t2 = new Timer(1000,this);
  public void actionPerformed(ActionEvent e)     {

      if (e.getSource() == b1 && b1.getText().equals("Start"))
      {
          t1.start();
          b1.setText("Stop");
      }
      else   if (e.getSource() == b1 && b1.getText().equals("Stop"))
      {
           t1.stop();
          b1.setText("Start");
      }
         if (e.getSource() == b2 && b2.getText().equals("Start"))
      {
          t2.start();
          b2.setText("Stop");
      }
      else   if (e.getSource() == b2 && b2.getText().equals("Stop"))
      {
           t2.stop();
          b2.setText("Start");
      }   
         else
          if (e.getSource()==t1)
              l1.setText(Integer.parseInt(l1.getText())+1+"");
         else
          if (e.getSource()==t2)    
              l2.setText(Integer.parseInt(l2.getText())+1+"");
       
   }
        
     MyPanel()   {
       this.add(b1);
        this.add(b2);
        this.add(l1);
        this.add(l2);
        
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setFont(new Font("",1,20));
        l2.setFont(new Font("",1,20));
        
        
     }
        
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
       
    }
}//panel
} // frame

public class JavaApplication1 {

    public static void main(String[] args)throws Exception{
 new ShowFrame();
   
    }
    
}
