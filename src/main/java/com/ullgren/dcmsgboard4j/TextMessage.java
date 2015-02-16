package com.ullgren.dcmsgboard4j;

public class TextMessage implements Message, Screen {
	
	protected boolean[][] ledMessage;
	private Font font;
	

	public TextMessage(String text) {
		this(text, new Font2());
	}
	
	public TextMessage(String text, Font font) {
		this.ledMessage = new boolean[text.length()*font.getDispwidth()][Board.SIZE_Y];
		this.font = font;
		for(int i = 0; i<text.length();i++) {
			addChar(text.charAt(i), i*font.getDispwidth());
		}
	}

	@Override
	public Screen getNextScreen() {
		return this;
	}
	
	private void addChar(char c, int xloc) {
		int cx,x,y;

		for(y=0;y<(this.font.getDispheight());y++) {
			for (cx=0,x=xloc; x < this.ledMessage.length && cx<=(this.font.getDispwidth());cx++,x++) {
				byte[] entry = this.font.getData()[(int)c];
				this.ledMessage[x][y] = ((entry[y] & (1<<cx))!=0)?  true:this.ledMessage[x][y];
			}
		}
	}

	@Override
	public boolean get(int x, int y) {
		return this.ledMessage[x][y];
	}

}
