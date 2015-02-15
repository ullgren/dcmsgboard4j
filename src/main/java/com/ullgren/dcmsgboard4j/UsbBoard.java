package com.ullgren.dcmsgboard4j;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.usb.Device;
import ch.ntb.usb.USB;
import ch.ntb.usb.USBException;

public class UsbBoard implements Board {
    private static final short _PRODUCT_ID = 0x0013;
	private static final short _VENDOR_ID = 0x1d34;
	
	private Device dev = null;
	private List<byte[]> packetBytes;
    
    public UsbBoard() {
    	packetBytes = new ArrayList<byte[]>();
    	// Start a thread that refresh every 200 ms
	}
    
    /* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Board#update(com.ullgren.dcmsgboard4j.Screen)
	 */
    @Override
	public void update(Screen screen) {
    	//set bits for each row
    	List<byte[]> rowBytes = new ArrayList<byte[]>();
    	    	
    	for(int y = 0; y < SIZE_Y; y++) {
    		byte[] bytes = new byte[]{(byte)0xFF, (byte)0xFF, (byte)0xFF};
    		byte bytep = 2;
    		byte bitp = 0;
    		for(int x = 0; x < SIZE_X; x++) {
    			if(screen.get(x, y)) {
    				bytes[bytep] &= ~(1 << bitp);
    			}
    			if(++bitp > 7) {
    				bitp = 0;
    				bytep--;
    			}
    		}
    		rowBytes.add(bytes);
    	}
    	//make bytes that will be written to device
    	packetBytes.clear();
    	
    	for(byte i = 0; i < SIZE_Y; i += 2) {
    		byte[] row1 = rowBytes.get(i);
    		byte[] row2 = i != 6 ? rowBytes.get(i+1) : new byte[]{0x00, 0x00, 0x00};
    		
    		byte[] bytes = new byte[]{0x01, i, row1[0], row1[1], row1[2], row2[0], row2[1], row2[2]};
    		packetBytes.add(bytes);
    	}
    	refresh();
    }
    
    //refresh board
    private void refresh() {
	    for(int i = 0; i < packetBytes.size(); i++) {
	    	try {
	    		dev.controlMsg(0x21, 0x09, 0,0, packetBytes.get(i), packetBytes.get(i).length, 2000, false);
	    	} catch(Exception e) {
//	    		if(!connectInterval) {
//	    			console.log("Disconnected.");
//	    			connectInterval = setInterval(connect, 1000);
//	    		}
	    	}
		}
    }

	private void usbSetup() {
		 	dev = USB.getDevice(_VENDOR_ID, _PRODUCT_ID); // Vendor ID, Product ID
	        try {
	            dev.open(1, 0, -1); // Open the device (Configuration(default), Interface(Control), AlternativeConfig(None))
	        } catch (USBException ex) {
	        	throw new BoardException(
	        			String.format(
	        					"Please check the driver for device VID:%s, PID:%s",
	        					Integer.toHexString(_VENDOR_ID),
	        					Integer.toHexString(_PRODUCT_ID)),
	        			ex);
	        }
	}

	@Override
	public void open() throws BoardException {
		usbSetup();
	}

	@Override
	public void close() throws BoardException {
		if ( dev != null ) {
			try {
				dev.close();
			} catch (USBException ex) {
				throw new BoardException(
    					"Failed to close device",
	        			ex);
			}
		}
	}

}
