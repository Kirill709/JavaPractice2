import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComponent;

public class Main extends JComponent
{
    int U = 20;

    public Main()
    {
        super();

        super.setPreferredSize(new Dimension(800, 800));
    }


    public void paintComponent(Graphics g)
    {


        int width = super.getWidth();
        int height = super.getHeight();
        Graphics2D gb = (Graphics2D) g;
        Graphics2D gd = (Graphics2D) g;

        gb.setBackground(Color.cyan);

        gb.clearRect(0, 0, width, height);

        gb.setStroke(new BasicStroke(1));

        gb.setColor(Color.black);

        gb.setStroke(new BasicStroke(2));
        gb.drawLine(width/2, 0, width/2, height);
        gb.drawLine(0, height/2, width, height/2);

        gb.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[] {10, 2}, 0));

        for(int i=width/2+U; i<width; i+=U)
        {
            gb.drawLine(i, 0, i, height);
        }

        for(int i=width/2-U; i>0; i-=U)
            gb.drawLine(i, 0, i, height);

        //for(int i=height/2+U, i2=-1; i<height; i+=U, i2--)
        //    gb.drawString(i2+".0", width/2+5, i-5);

        for(int i=height/2-U; i>-0; i-=U)
            gb.drawLine(0, i, width, i);

        for(int i=height/2+U; i<height; i+=U)
            gb.drawLine(0, i, width, i);

        for(int i=width/2, i2=0; i<width; i+=U, i2++)
            gb.drawString(i2+"", i+5, height/2-5);

        for(int i=width/2-U, i2=-1; i>0; i-=U, i2--)
            gb.drawString(i2+"", i+5, height/2-5);

        for(int i=height/2+U, i2=-1; i<height; i+=U, i2--)
            gb.drawString(i2+"", width/2+5, i-5);

        for(int i=height/2-U, i2=1; i>0; i-=U, i2++)
            gb.drawString(i2+"", width/2+5, i-5);

        gb.setStroke(new BasicStroke(5));
        gb.setColor(Color.white);

        String [] a;
        String  c;
        try
        {
            FileReader read = new FileReader("D:\\For study\\progs\\Graph\\1.txt");
            BufferedReader buff= new BufferedReader(read);
            while(true)
            {
                c= buff.readLine();
                if(c==null)
                    break;
                a=c.split("_");
                int x[]= new int[a.length];
                int y[]= new int[a.length];
                int i=0;
                int j=0;

                for(int k=0; k<a.length-1; k+=2)
                {
                    x[i]= 400 + U * Integer.parseInt(a[k]);
                    i++;
                }

                for(int k=1; k<a.length; k+=2)
                {
                    y[j]= 400 - U * Integer.parseInt(a[k]);
                    j++;
                }

                gb.drawPolyline(x, y, 31);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error");
        }
    }
}