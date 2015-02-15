package com.ullgren.dcmsgboard4j;

public interface Message {
	/**
	 * Retrieves the next screen to display for this message.
	 * @return
	 */
	public Screen getNextScreen();
}
