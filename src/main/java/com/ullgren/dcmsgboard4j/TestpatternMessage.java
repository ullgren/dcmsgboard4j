package com.ullgren.dcmsgboard4j;

public class TestpatternMessage implements Message, Screen {
	
	private boolean[][]leds = new boolean[Board.SIZE_X][Board.SIZE_Y];
	private int currentPattern = 0;

	@Override
	public boolean get(int x, int y) {
		return this.leds[x][y];
		
	}

	@Override
	public Screen getNextScreen() {
		currentPattern++;
		
		switch (currentPattern) {
		case 0:
			clearAll();
			break;
		case 1:
			setAll();
			break;
		case 2:
			setBoxBorders();
			break;
		case 3:
			setBoxCorners();
			break;
		case 4:
			setSimpleDiag();
			break;
		case 5:
			setRand();
			break;
		default:
			return null;
		}
		return this;
	}

	private void setRand() {
		clearAll();
		for (int x=0;x<Board.SIZE_X;x++) {
            for(int y=0;y<Board.SIZE_Y;y++) {
                    this.leds[x][y] = ((Math.random()*2)>1?true:false);
            }
    }

	}
	private void setSimpleDiag() {
		clearAll();
		int x=0; int y=0;
		for(;x<Board.SIZE_X && y<Board.SIZE_Y;x++, y++) {
            this.leds[x][y] = true;
		}
	}

	private void setBoxCorners() {
		clearAll();
		this.leds[0][0] = true;
		this.leds[Board.SIZE_X-1][0] = true;
		this.leds[Board.SIZE_X-1][Board.SIZE_Y-1] = true;
		this.leds[0][Board.SIZE_Y-1] = true;
	}

	private void setBoxBorders() {
		clearAll();
		for(int x=0;x<Board.SIZE_X;x++) {
			this.leds[x][0] = true;
			this.leds[x][Board.SIZE_Y-1] = true;
	    }
	    for(int y=0;y<Board.SIZE_Y;y++) {
	    	this.leds[0][y] = true;
	    	this.leds[Board.SIZE_X-1][y] = true;
	    }
	}

	private void clearAll() {
		for(int x=0; x < Board.SIZE_X; x++) {
			for(int y=0; y < Board.SIZE_Y; y++){
				this.leds[x][y] = false;
			}
		}
	}
	
	private void setAll() {
		clearAll();
		for(int x=0; x < Board.SIZE_X; x++) {
			for(int y=0; y < Board.SIZE_Y; y++){
				this.leds[x][y] = true;
			}
		}
	}

}
