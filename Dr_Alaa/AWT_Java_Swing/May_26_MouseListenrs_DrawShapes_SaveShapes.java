
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
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
   
    private  class MyPanel extends JPanel implements ActionListener, MouseListener{

        JButton b1=new JButton("Rectangle");
        JButton b2=new JButton("Circle");
   String shape="";
   int x,y;
   ArrayList <Shape> shapes = new ArrayList();
   
   
   Shape findShape(int x, int y){
       for (int i=0;i<shapes.size();i++){
           Shape s= shapes.get(i);
           if ((x>=s.x && x<=s.x+50) && (y>=s.y && y<=s.y+50))
               return s;
       }
       
       return null;
   }
   public void mousePressed(MouseEvent e){
       x = e.getX();
       y = e.getY();
       if (findShape(x,y)==null)
      shapes.add(new Shape(x,y,shape));
       
       
       
       repaint();
    
   }
      public void mouseClicked(MouseEvent e){
        
          if (e.getClickCount()>=2 && findShape(e.getX(), e.getY())!=null){
              shapes.remove(findShape(e.getX(), e.getY()));
          repaint();
          }
          
   }
         public void mouseExited(MouseEvent e){
       
   }
            public void mouseEntered(MouseEvent e){
       
   }
               public void mouseReleased(MouseEvent e){
       
   }
  public void actionPerformed(ActionEvent e)     {
   shape = ((JButton)e.getSource()).getText();
     
   }
        
     MyPanel()   {  
 
       this.add(b1);
        this.add(b2);
    
        b1.addActionListener(this);
        b2.addActionListener(this);
   this.addMouseListener(this);
        
     }
        
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
for (int i=0;i<shapes.size();i++)
{
    Shape s=shapes.get(i);
    if (s.type.equalsIgnoreCase("rectangle"))
        g2.draw(new Rectangle2D.Double(s.x,s.y,50,50));
    else
        if (s.type.equalsIgnoreCase("circle"))
        g2.draw(new Ellipse2D.Double(s.x,s.y,50,50));    
        }
       
    }
   class Shape {
       int x,y;
       String type;

            public Shape(int x, int y, String type) {
                this.x = x;
                this.y = y;
                this.type = type;
            }
       
   }
    }//panel
} // frame

public class JavaApplication1 {

    public static void main(String[] args)throws Exception{
 new ShowFrame();
   
    }
    
}
