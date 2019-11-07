package jdraw.Handles;

import jdraw.framework.AbstractFigureHandle;
import jdraw.framework.Figure;

import java.awt.*;

public class EastHandle extends AbstractFigureHandle {

    public EastHandle(Figure owner) {
        super(owner);
    }

    @Override public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
    }

    @Override public Point getLocation() {
        Point p = getOwner().getBounds().getLocation();
        p.y += getBounds().height/2;
        p.x += getBounds().width;
        return p;
    }


    @Override
    public Point getFixedCorner() {
        Rectangle r = getBounds();
        return new Point(r.x, r.y);
    }
    @Override
    public Point getVariableCorner(int x, int y) {
        // the x-coordinate of the mouse is ignored
        Rectangle r = getBounds();
        return new Point(x, r.y+r.height);
    }



}
