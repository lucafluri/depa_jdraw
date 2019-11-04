package jdraw.Handles;

import jdraw.framework.AbstractFigureHandle;
import jdraw.framework.Figure;

import java.awt.*;

public class NorthWestHandle extends AbstractFigureHandle {

    public NorthWestHandle(Figure owner) {
        super(owner);
    }

    @Override public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
    }

    @Override
    public Point getFixedCorner() {
        Rectangle r = getBounds();
        return new Point(r.x + r.width, r.y + r.height);
    }
    @Override
    public Point getVariableCorner(int x, int y) {
        return new Point(x, y);
    }


}
