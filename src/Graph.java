import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame
{

    Main Frame;

    public Graph()
    {
        super("graph Monster");

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        Frame = new Main();

        mainPanel.add(Frame);

        mainPanel.setBackground(Color.red);

        super.add(mainPanel);

        //super.setUndecorated(true);

        super.pack();

        super.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Graph();
    }


}