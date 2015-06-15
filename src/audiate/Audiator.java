package audiate;
/**
 * Class to create, manage, and analzy audio fingerprints
 * @author Ryan
 *
 */
public class Audiator {
	private String id;
	private String name;
	private int confidence;
	private int offset;
	
	/**
	 * Constructor Class
	 * This still needs more info
	 * @param id
	 * @param name
	 */
	public Audiator(String id, String name){
		this.id = id;
		this.name = name;
		this.confidence = 0;
		this.offset = 0;
	}
	
	
}
