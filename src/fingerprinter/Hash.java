package fingerprinter;

/**
 * A class whose purpose is to generate a hash for a spectrogram of an audio file
 *
 */
public class Hash{
    Spectrogram spectrogram;
    public Hash(Spectrogram spectrogram){
        this.spectrogram = spectrogram;
    }

    /**
     * Adds a high pass filter to the spectrogram in order to accentuate the higher frequency peaks
     * @return a new filtered spectrogram
     */
    public Spectrogram highPass(){
        return new Spectrogram();
    }

    /**
     * Finds the peaks of the spectrogram
     * @return an array of all of the peaks frequencies and times
     * EVAN: Should we create a peak object that stores the frequencies and times and use that instead of a 2d array?
     */
    public int[][] findPeaks(){
        return new int[2][];
    }

    /**
     * Computes the sha1 hash of the peaks based on their frequency and distance from other peaks
     * @param peaks
     * @return
     */
    public String hashPeaks(int[][] peaks){
        return "";
    }
}