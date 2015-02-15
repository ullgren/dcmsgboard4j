package com.ullgren.dcmsgboard4j.example;

import com.ullgren.dcmsgboard4j.*;

public class ScreenTest {
	
	public static void main(String[] args) {
//		Message message = new ScrollingTextMessage("Test");
		Message message = new TestpatternMessage();
//		Board board = new UsbBoard();
//		board.open();
		
		Board board2 = new ConsoleBoard();
		board2.open();
		
		Screen s = message.getNextScreen();
		for(int i = 0; s!=null; i++) {
			
//			board.update(s);
			board2.update(s);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Only get a new screen every second loop
			if ( i%2 == 0 ) {
				s = message.getNextScreen();
			}
		}
//		board.close();
		board2.close();
	}

}
