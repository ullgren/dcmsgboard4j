# Dream Cheeky USB Message Board for Java library

![Dream Cheeky USB Message Board](http://www.last-outpost.com/~malakai/dcled/52_product_image.jpg)

This is a Java library for the USB Dream Cheeky LED Message Board

##  Installation and Usage
This library uses [libusbjava](http://libusbjava.sourceforge.net/wp/) for accessing the USB device so before using dcmsgboard4j you will have to properly [install and setup libusbjava JNI library](http://libusbjava.sourceforge.net/wp/?page_id=8).

Here is an example on how to use the library.
```java
Board board = new UsbBoard();
board.open();

Message message = new TestpatternMessage();

Screen s = message.getNextScreen();
while ( s != null ) {
  board.update(s);
  try {
    Thread.sleep(400);
  } catch (InterruptedException e) { }
  s = message.getNextScreen();
}
```

## Reporting Issues

We use GitHub:Issues for tracking issues with this module. You can report new issues at this link https://github.com/ullgren/dcmsgboard4j/issues

## Acknowledge

The code in this library is heavily influenced, and at some occasion even directly copied, from [Jeff Jahr's dcled](http://www.last-outpost.com/~malakai/dcled/) program.

Travis CI : [![Build Status](https://secure.travis-ci.org/ullgren/dcmsgboard4j.png)](http://travis-ci.org/ullgren/dcmsgboard4j)








