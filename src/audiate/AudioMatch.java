package audiate;

/**
 * Object that provides all of the necessary information for an audio snippet for which a match has been found
 * @author Ryan
 *
 */
public class AudioMatch {
	private String songID;
	private String songName;
	private int confidence;
	private int offset;
	private int offsetSeconds;
	private String fieldFileSha1;
	
	public AudioMatch(String songID, String songName, int confidence, int offset, int offsetSeconds,
			String fieldFileSha1){
		this.songID = songID;
		this.songName = songName;
		this.confidence = confidence;
		this.offset = offset;
		this.offsetSeconds = offsetSeconds;
		this.fieldFileSha1 = fieldFileSha1;
	}
	
	public AudioMatch(){
		this("", "", 0, 0, 0, "");
	}
	
	public String getId(){
		return songID;
	}
	
	public String getName(){
		return songName;
	}
	
	public int getConfidence(){
		return confidence;
	}
	
	public int getOffset(){
		return offset;
	}
	
	public int getOffsetSeconds(){
		return offsetSeconds;
	}
	
	public String getSha1(){
		return fieldFileSha1;
	}
	
}
