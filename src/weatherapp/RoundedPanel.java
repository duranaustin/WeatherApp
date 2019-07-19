package weatherapp;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel
{
    protected int _strokeSize = 1;
    protected boolean _highQuality = true;
    protected Dimension _arcs = new Dimension(30, 30);
    protected int _shadowGap = 5;

    protected Color _backgroundColor = Color.LIGHT_GRAY;

    public RoundedPanel()
    {
        super();
        setOpaque(false);
    }

    @Override
    public void setBackground(Color c)
    {
        _backgroundColor = c;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        if(_highQuality)
        {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }

        else
        {
            _shadowGap = 1;
        }

        graphics.setColor(_backgroundColor);
        graphics.fillRoundRect(0,  0, width, height, _arcs.width, _arcs.height);
        graphics.setStroke(new BasicStroke(_strokeSize));
    }
}