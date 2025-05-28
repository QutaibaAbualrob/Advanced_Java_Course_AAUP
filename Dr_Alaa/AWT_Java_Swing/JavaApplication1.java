
package javaapplication1;

import java.awt.*;
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
   
    private  class MyPanel extends JPanel{
        JButton b1=new JButton("Rectangle");
        JButton b2=new JButton("Circle");
     MyPanel()   {
         this.add(b1);
         this.add(b2);
     }
        
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        
//        g2.fill (new Rectangle2D.Double(50,70,250,300));
//        Line2D line = new Line2D.Double(50,70,300,370);
//        
//        g2.setColor(Color.red);
//        g2.draw(line);
//        
//        
//        Line2D line2 = new Line2D.Double(300,70,50,370);
//        g2.setColor(Color.green);
//        g2.draw(line2);
//          Line2D line3 = new Line2D.Double(50,220,300,220);
//        g2.setColor(Color.yellow);
//        g2.draw(line3);
//           Line2D line4 = new Line2D.Double(175,70,175,370);
//        g2.setColor(Color.blue);
//        g2.draw(line4);
//        g2.setFont(new Font("Brush Script MT",1,30));
//        g2.drawString("Advanced Java!", 400, 400);

//        for (int i=0;i<200;i+=20){
//            g2.setPaint(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
//            g2.draw(new Rectangle2D.Double(400-i/2,250-i/2,i,i));
//        }
        
        
        
    }
}//panel
} // frame

public class JavaApplication1 {

    public static void main(String[] args)throws Exception{
 new ShowFrame();
   
    }
    
}
