package com.ullgren.dcmsgboard4j.example;

import com.ullgren.dcmsgboard4j.*;

public class ScreenTest {

	public static void main(String[] args) {
		 Message message = new ScrollingTextMessage("This is generated from a Java program");
//		Message message = new TestpatternMessage();
		try (Board board = new UsbBoard(); Board board2 = new ConsoleBoard();) {
			board.open();
			board2.open();

			Screen s = message.getNextScreen();
			for (int i = 0; s != null; i++) {

				board.update(s);
				board2.update(s);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Only get a new screen every second loop
				if (i % 2 == 0) {
					s = message.getNextScreen();
				}
			}
		}
	}

}
