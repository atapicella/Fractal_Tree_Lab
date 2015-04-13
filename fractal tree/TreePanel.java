//********************************************************************
//  TreePanel.java       Author: Andrew Apicella
//
//  Represents a drawing surface on which to paint a fractal tree.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 700;
    private final int PANEL_HEIGHT = 500;

    private final int minBranchLength = 5;
    private final double percentSmaller = .8;
    private final double theta = 30;

    private final double BOTTOMX = 350, BOTTOMY = 500;
    private final double TOPX = 350, TOPY = 400;
    private final double startingLength = 100;
    //private final double smallest branch = 

    private int current; //current order
    private int startOrder = 2;

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (int order, double prevX, double prevY, double prevAngle, double prevLength,
    Graphics page)
    {

        if (order<this.current+1 && prevLength>5.49)
        {

                double newLength, newAngleRight, newXRight, newYRight;
                double newAngleLeft, newXLeft, newYLeft;

                newLength = prevLength*percentSmaller;
                newAngleRight = prevAngle+theta;
                newXRight = (newLength*(Math.cos(Math.toRadians(newAngleRight))))+prevX;
                newYRight = (newLength*(Math.sin(Math.toRadians(newAngleRight))))+prevY;
                page.drawLine((int) prevX, (int) prevY, (int) newXRight, (int) newYRight);

                newAngleLeft = prevAngle-theta;
                newXLeft = (newLength*(Math.cos(Math.toRadians(newAngleLeft))))+prevX;
                newYLeft = (newLength*(Math.sin(Math.toRadians(newAngleLeft))))+prevY;
                page.drawLine((int) prevX, (int) prevY, (int) newXLeft, (int) newYLeft);

                drawFractal (order+1, newXRight, newYRight, newAngleRight, newLength, page);
                drawFractal (order+1, newXLeft, newYLeft, newAngleLeft, newLength, page);
        }

    }
    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.setColor (Color.green);
        g.drawLine((int) BOTTOMX, (int) BOTTOMY, (int) TOPX, (int) TOPY);
        if (this.current > 1)
        {
            drawFractal(this.startOrder, TOPX, TOPY, 270, startingLength, g);
        }
    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        this.current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }
}
