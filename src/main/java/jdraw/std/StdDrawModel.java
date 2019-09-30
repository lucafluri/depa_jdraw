/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author Fluri Luca
 *
 */
public class StdDrawModel implements DrawModel {
	private ArrayList<Figure> figures = new ArrayList<Figure>();
	private ArrayList<DrawModelListener> mListeners = new ArrayList<DrawModelListener>();
	//TODO USE MAP
	private HashMap<Figure, FigureListener> fListeners = new HashMap<Figure, FigureListener>();


	private void notifyDrawModelListeners(DrawModel source, Figure f, DrawModelEvent.Type type){
		mListeners.forEach(e -> e.modelChanged(new DrawModelEvent(source, f, type)));
	}

	@Override
	public void addFigure(Figure f) {
		figures.add(f);

		fListeners.put(f, e -> notifyDrawModelListeners(this, f, DrawModelEvent.Type.FIGURE_CHANGED));

		f.addFigureListener(fListeners.get(f));

		notifyDrawModelListeners(this, f, DrawModelEvent.Type.FIGURE_ADDED);


	}

	@Override
	public Stream<Figure> getFigures() {
		//System.out.println("StdDrawModel.getFigures has to be implemented");
		return figures.stream(); // Only guarantees, that the application starts -- has to be replaced !!!
	}

	@Override
	public void removeFigure(Figure f) {
		figures.remove(f);
		f.removeFigureListener(fListeners.get(f));
		mListeners.forEach(e -> e.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED)));

	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		mListeners.add(listener);

	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		mListeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	@Override
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		// TODO to be implemented  
		figures.remove(f);
		figures.add(index, f);
		notifyDrawModelListeners(this, f, DrawModelEvent.Type.DRAWING_CHANGED);
	}

	@Override
	public void removeAllFigures() {
		figures.forEach(e -> e.removeFigureListener(fListeners.get(e)));
		figures.clear();
		mListeners.forEach(e -> e.modelChanged(new DrawModelEvent(this, null, DrawModelEvent.Type.DRAWING_CLEARED)));

	}
}
