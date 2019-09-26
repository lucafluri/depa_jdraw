/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
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

	@Override
	public void addFigure(Figure f) {
		figures.add(f);
		mListeners.forEach(e -> e.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED)));

	}

	@Override
	public Stream<Figure> getFigures() {
		//System.out.println("StdDrawModel.getFigures has to be implemented");
		return figures.stream(); // Only guarantees, that the application starts -- has to be replaced !!!
	}

	@Override
	public void removeFigure(Figure f) {
		figures.remove(f);
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		// TODO to be implemented  
		//System.out.println("StdDrawModel.addModelChangeListener has to be implemented");
		mListeners.add(listener);

	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		// TODO to be implemented  
		//System.out.println("StdDrawModel.removeModelChangeListener has to be implemented");
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
		System.out.println("StdDrawModel.setFigureIndex has to be implemented");
	}

	@Override
	public void removeAllFigures() {
		// TODO to be implemented  
		System.out.println("StdDrawModel.removeAllFigures has to be implemented");
	}

}
