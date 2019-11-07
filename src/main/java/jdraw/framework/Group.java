package jdraw.framework;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group extends AbstractFigure implements FigureGroup {
    private final List<Figure> parts;

    public Group(List<Figure> parts) {
        if(parts == null || parts.size() == 0)
            throw new IllegalArgumentException();
        this.parts = new ArrayList<>(parts);
    }

    @Override public Iterable<Figure> getFigureParts() {
       return Collections.unmodifiableList(parts);
    }

    @Override public void draw(Graphics g) {
        for(Figure part : parts){
            part.draw(g);
        }

    }

    @Override public void move(int dx, int dy) {
        if(dx != 0 || dy != 0) {
            parts.forEach(f -> f.move(dx, dy));
        }
    }

    @Override public boolean contains(int x, int y) {
        return parts.stream().anyMatch(f -> f.contains(x, y));
    }

    @Override public void setBounds(Point origin, Point corner) {

    }

    @Override public Rectangle getBounds() {
        Rectangle bounds = parts.get(0).getBounds();
        parts.stream().skip(1).forEach(
                f -> bounds.add(f.getBounds())
        );
        return bounds;
    }
}
