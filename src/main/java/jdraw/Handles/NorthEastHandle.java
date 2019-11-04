package jdraw.Handles;

import jdraw.framework.AbstractFigureHandle;
import jdraw.framework.Figure;

import java.awt.*;

public class NorthEastHandle extends AbstractFigureHandle {

    public NorthEastHandle(Figure owner) {
        super(owner);
    }

    @Override public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
    }

    @Override public Point getLocation() {
        Point p = getOwner().getBounds().getLocation();
        p.x += getBounds().width;
        return p;
    }


    @Override
    public Point getFixedCorner() {
        Rectangle r = getBounds();
        return new Point(r.x, r.y + r.height);
    }
    @Override
    public Point getVariableCorner(int x, int y) {
        return new Point(x, y);
    }



}
