package jdraw.Handles;

import jdraw.framework.AbstractFigureHandle;
import jdraw.framework.Figure;

import java.awt.*;

public class WestHandle extends AbstractFigureHandle {

    public WestHandle(Figure owner) {
        super(owner);
    }

    @Override public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
    }

    @Override public Point getLocation() {
        Point p = getOwner().getBounds().getLocation();
        p.y += getBounds().height/2;
        return p;
    }


    @Override
    public Point getFixedCorner() {
        Rectangle r = getBounds();
        return new Point(r.x+r.width, r.y);
    }
    @Override
    public Point getVariableCorner(int x, int y) {
        // the x-coordinate of the mouse is ignored
        Rectangle r = getBounds();
        return new Point(x, r.y+r.height);
    }



}
