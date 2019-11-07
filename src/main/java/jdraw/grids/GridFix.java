package jdraw.grids;

import jdraw.framework.DrawGrid;

import java.awt.*;

public class GridFix implements DrawGrid {
    private final int stepX, stepY;

    public GridFix(int sx, int sy) {
        this.stepX = Math.max(1, sx);
        this.stepY = Math.max(1, sy);
    }

    @Override public Point constrainPoint(Point p) {
        //System.out.println("GridFix: Constrain Point: " + p);
        int x = ((p.x + stepX/2) / stepX ) * stepX;
        int y = ((p.y + stepY/2) / stepY ) * stepY;

        return new Point(x, y);
    }

    @Override public int getStepX(boolean right) {
        return stepX;
    }

    @Override public int getStepY(boolean down) {
        return stepY;
    }

    @Override public void activate() {
        System.out.println("GridFix: activate()");
    }

    @Override public void deactivate() {
        System.out.println("GridFix: deactivate()");
    }

    @Override public void mouseDown() {
        System.out.println("GridFix: mouseDown()");
    }

    @Override public void mouseUp() {
        System.out.println("GridFix: mouseUp()");
    }
}
