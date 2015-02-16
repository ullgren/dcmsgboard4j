package com.ullgren.dcmsgboard4j;

import java.io.Closeable;

public interface Board extends Closeable {
	public static final int SIZE_X = 21;
	public static final int SIZE_Y = 7;
	
	public void open() throws BoardException ;
	
	public void close() throws BoardException;

	public void update(Screen screen);

}