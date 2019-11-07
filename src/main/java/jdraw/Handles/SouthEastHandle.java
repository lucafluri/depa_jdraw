package jdraw.Handles;

import jdraw.framework.AbstractFigureHandle;
import jdraw.framework.Figure;

import java.awt.*;

public class SouthEastHandle extends AbstractFigureHandle {

    public SouthEastHandle(Figure owner) {
        super(owner);
    }

    @Override public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
    }

    @Override public Point getLocation() {
        Point p = getOwner().getBounds().getLocation();
        p.x += getBounds().width;
        p.y += getBounds().height;
        return p;
    }


    @Override
    public Point getFixedCorner() {
        Rectangle r = getBounds();
        return new Point(r.x, r.y);
    }
    @Override
    public Point getVariableCorner(int x, int y) {
        return new Point(x, y);
    }



}
