//********************************************************************
//  FractalTreeViewer.java       Author: Andrew Apicella
//
//  Demonstrates the use of recursion.
//  @atapicella (13 April 2015): converted from an applet to an application
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class FractalTreeViewer implements ActionListener
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final int MIN = 0, MAX = 14;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private TreePanel drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        FractalTreeViewer viewer = new FractalTreeViewer();
    }

    public FractalTreeViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("The Fractal Tree");
        titleLabel.setForeground (Color.black);

        increase = new JButton (new ImageIcon ("increase.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decrease.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);

        orderLabel = new JLabel ("Order: 1");
        orderLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);

        drawing = new TreePanel(1);

        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        panel.add(drawing);
        frame.add(panel);

        frame.repaint();
        frame.setVisible(true);
    }

    //-----------------------------------------------------------------
    //  Determines which button was pushed, and sets the new order
    //  if it is in range.
    //-----------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        int order = drawing.getOrder();

        if (event.getSource() == increase)
            order++;
        else
            order--;

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + order);
            drawing.setOrder(order);
            frame.repaint();
        }

    }
}
