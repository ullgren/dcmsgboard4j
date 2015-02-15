package com.ullgren.dcmsgboard4j;

public interface Font {
	
	public static final int FONTX = 5;
	public static final int FONTY = 7;

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getAuthor();

	public abstract void setAuthor(String author);

	public abstract int getDataformat();

	public abstract void setDataformat(int dataformat);

	public abstract int getDispwidth();

	public abstract void setDispwidth(int dispwidth);

	public abstract int getDispheight();

	public abstract void setDispheight(int dispheight);

	public abstract byte[][] getData();

	public abstract void setData(byte[][] data);

}