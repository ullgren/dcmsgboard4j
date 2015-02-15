package com.ullgren.dcmsgboard4j;

public class SingelDotMessage implements Message, Screen {
	
	private short currentX = Board.SIZE_X;
	private short currentY = Board.SIZE_Y;

	@Override
	public boolean get(int x, int y) {
		if ( x == currentX && y == currentY ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Screen getNextScreen() {
		if ( ++currentX >= Board.SIZE_X ) {
			currentX = 0;
			if ( ++currentY >= Board.SIZE_Y ) {
				currentY = 0;
			}
		}
		return this;
	}

}
