package org.artificia.zync.music;

public class ID3Metadata
{
	private String title, artist, album, composer, year, track;
	private double duration;
	private Integer bitRate, sampleRate;	
	
	public ID3Metadata()
	{}
	
	public ID3Metadata(ID3Metadata copyFrom)
	{
		this.title = copyFrom.title;
		this.artist = copyFrom.artist;
		this.album = copyFrom.album;
		this.composer = copyFrom.composer;
		this.year = copyFrom.year;
		this.track = copyFrom.track;
		this.duration = copyFrom.duration;
		this.bitRate = copyFrom.bitRate;
		this.sampleRate = copyFrom.sampleRate;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	public String getAlbum()
	{
		return album;
	}
	
	public void setAlbum(String album)
	{
		this.album = album;
	}
	
	public String getComposer()
	{
		return composer;
	}
	
	public void setComposer(String composer)
	{
		this.composer = composer;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	
	public String getTrack()
	{
		return track;
	}
	
	public void setTrack(String track)
	{
		this.track = track;
	}
	
	public double getDuration()
	{
		return duration;
	}
	
	public void setDuration(double duration)
	{
		this.duration = duration;
	}
	
	public Integer getBitRate()
	{
		return bitRate;
	}
	
	public void setBitRate(Integer bitRate)
	{
		this.bitRate = bitRate;
	}
	
	public Integer getSampleRate()
	{
		return sampleRate;
	}
	
	public void setSampleRate(Integer sampleRate)
	{
		this.sampleRate = sampleRate;
	}
}
