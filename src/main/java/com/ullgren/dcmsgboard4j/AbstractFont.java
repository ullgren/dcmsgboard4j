package com.ullgren.dcmsgboard4j;

public abstract class AbstractFont implements Font {
	
	private String name;
	private String description;
	private String author;
	private int dataformat;
	private int dispwidth;
	private int dispheight;
	private byte[][] data;
	
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getAuthor()
	 */
	@Override
	public String getAuthor() {
		return author;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setAuthor(java.lang.String)
	 */
	@Override
	public void setAuthor(String author) {
		this.author = author;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getDataformat()
	 */
	@Override
	public int getDataformat() {
		return dataformat;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setDataformat(int)
	 */
	@Override
	public void setDataformat(int dataformat) {
		this.dataformat = dataformat;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getDispwidth()
	 */
	@Override
	public int getDispwidth() {
		return dispwidth;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setDispwidth(int)
	 */
	@Override
	public void setDispwidth(int dispwidth) {
		this.dispwidth = dispwidth;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getDispheight()
	 */
	@Override
	public int getDispheight() {
		return dispheight;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setDispheight(int)
	 */
	@Override
	public void setDispheight(int dispheight) {
		this.dispheight = dispheight;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#getData()
	 */
	@Override
	public byte[][] getData() {
		return data;
	}
	/* (non-Javadoc)
	 * @see com.ullgren.dcmsgboard4j.Font#setData(byte[][])
	 */
	@Override
	public void setData(byte[][] data) {
		this.data = data;
	}
}