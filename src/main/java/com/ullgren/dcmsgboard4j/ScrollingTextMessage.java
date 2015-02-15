package com.ullgren.dcmsgboard4j;

public class ScrollingTextMessage extends TextMessage {
	
	private byte currentOffset = 0;
	private byte stepOffset = 1;

	public ScrollingTextMessage(String text) {
		this(text, new Font1());
	}
	
	public ScrollingTextMessage(String text, Font font) {
		super(text, font);
	}

	@Override
	public Screen getNextScreen() {
		this.currentOffset+=this.stepOffset;
		if ( this.currentOffset <= ( this.ledMessage.length + Board.SIZE_X) ) {
			return this;
		} else {
			return null;
		}
	}

	@Override
	public boolean get(int x, int y) {
		int realX = x+currentOffset-Board.SIZE_X;
		if ( realX < 0 || realX >=  Board.SIZE_X ) {
			return false;
		} else {
			return this.ledMessage[realX][y];
		}
	}

}
