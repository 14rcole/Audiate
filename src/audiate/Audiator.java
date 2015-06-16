package audiate;
/**
 * Class to create, manage, and analzy audio fingerprints
 * @author Ryan
 *
 */
public class Audiator {
	private AudioMatch match;
	
	/**
	 * Constructor Class
	 * This still needs more info
	 * @param id
	 * @param name
	 */
	public Audiator(String id, String name){
		match = new AudioMatch();
	}
	
	/**
	 * Gets a list of the songs that have been fingerprinted so far
	 */
	private static String[] getFingerprintedSongs(){
		return new String[0];
	}
	
	/**
	 * Fingerprints each file in a directory with one of the given extensions
	 * @param path
	 * @param extensions
	 */
	private void fingerprintDirectory(String path, String[] extensions){
		
	}
	
	/**
	 * Fingerprints the file corresponding to the given path
	 * @param filepath
	 */
	private void fingerprintFile(String filepath){
		
	}
	
	/**
	 * Finds hashes that align in time with other matches and 
	 * finds consensus on which hashes are "true" signal from
	 * the audio, returning an AudioMatch object with information on the match;
	 * @return
	 */
	private AudioMatch findMatches(){
		return match;
	}
	
	/**
	 * Compares the passed in audio snippet to the existing database to identify the song
	 * @return
	 */
	private String recognize(){
		return "";
	}
	
	/**
	 * 
	 * @return String
	 */
	private String[] fingerprintWorker(){
		return new String[2];
	}
	
	/**
	 * Splits an array into roughly n equal segments and returns the 
	 * @param <T>
	 */
	private <T> Object chunkify(T[] list, int n){
		return list;
	}
	
	
	
	
	
	
	
	
}
