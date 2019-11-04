package jdraw.framework;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractFigureHandle implements FigureHandle {
    private static final int HANDLE_SIZE = 6;
    private final Figure owner;
    private Point fixedCorner;

    public AbstractFigureHandle(Figure owner) {
        this.owner = owner;
    }

    @Override public Figure getOwner() {
        return this.owner;
    }

    @Override public Point getLocation() {
        return owner.getBounds().getLocation();
    }
    public Rectangle getBounds() {return owner.getBounds();}

    @Override public void draw(Graphics g) {
        Point loc = getLocation();
        g.setColor(Color.WHITE); g.fillRect(loc.x - 3, loc.y - 3, 6, 6);
        g.setColor(Color.BLACK); g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
    }

    @Override public boolean contains(int x, int y) {
        Point loc = getLocation();
        return Math.abs(x - loc.x) < HANDLE_SIZE / 2
                && Math.abs(y - loc.y) < HANDLE_SIZE / 2;
    }

    @Override public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
        fixedCorner = getFixedCorner();
    }

    @Override public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
        owner.setBounds(getVariableCorner(x, y), fixedCorner);
    }

    @Override public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
        fixedCorner = null;
    }

    public abstract Point getFixedCorner();

    public abstract Point getVariableCorner(int x, int y);

}
