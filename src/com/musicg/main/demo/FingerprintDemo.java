/*
 * Copyright (C) 2012 Jacquet Wong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.musicg.main.demo;

import com.musicg.fingerprint.FingerprintManager;
import com.musicg.wave.Wave;

import java.io.File;
import java.io.IOException;

public class FingerprintDemo{
	
	public static void main (String[] args){
		String filePath = "/home/Ryan/Music/Flight of the Conchords/Flight of the Conchords";
		long startTime = System.currentTimeMillis();
		fingerprintDirectory(new File(filePath));
		long endTime = System.currentTimeMillis();
		System.out.println("Total directory size: " + new File("Audio").getTotalSpace());
		System.out.println("Number of files: " + new File("Audio").listFiles().length);
		System.out.println("Total time for directory: " + (endTime - startTime));
	}

	private static void fingerprintFile(File f){
		String filename = f.getName();
		String filenameWithoutExtension = getNameWithoutExtension(filename);
		if(isSupportedFileType(getFileExtension(filename))) {
			//create a wav version of the file
			convertAudioToWave(f);
			// create a wave object
			Wave wave = new Wave("Audio/" + filenameWithoutExtension + ".wav");

			// get the fingerprint
			byte[] fingerprint = wave.getFingerprint();

			// dump the fingerprint
			FingerprintManager fingerprintManager = new FingerprintManager();
			fingerprintManager.saveFingerprintAsFile(fingerprint, "out/" + filenameWithoutExtension + ".fingerprint");

			System.out.println("Size (bytes): " + fingerprint.length);
			// load fingerprint from file
			//byte[] loadedFp=fingerprintManager.getFingerprintFromFile("out/"+filename+".fingerprint");
		}
	}

	private static void fingerprintDirectory(File directory){
		if(directory.isDirectory()){
			File[] fileList = directory.listFiles();
			for(File f : fileList){
				fingerprintFile(f);
			}
		}else if(directory.isFile()){
			fingerprintFile(directory);
		}
	}

	/**
	 * Make sure that the passed in file is an audio format supported by ffmpeg
	 * To be implemented later
	 * @param filetype
	 * @return
	 */
	public static boolean isSupportedFileType(String filetype){
		switch(filetype){
			//Check if file type is a valid audio format
			case "wav":
			case "mp1":
			case "mp2":
			case "mp3":
			case "mp4":
			case "m4a":
			case "m4b":
			case "m4v":
			case "m4r":
			case "3gp":
			case "aac":
			case "vox":
			case "flac":
			case "mlp":
			case "thd":
			case "ac3":
			case "amr":
			case "3ga":
			case "awb":
			case "evrc":
			case "wma":
			case "ra":
			case "ram":
			case "qdx":
			case "adpcm":
			case "spx":
			case "ogg":
			case "oga":
			case "opus":
			case "aa3":
			case "oma":
			case "at3":
			case "at9":
			case "vqf":
			case "vql":
			case "tsp":
			case "tsl":
			case "caf":
			case "xa":
			case "ors": return true;
			//End check to see if file type is valid audio format
			//Check to see if file type is valid video container
			case "asf":
			case "wmv":
			case "avi":
			case "gxf":
			case "iff":
			case "3g2":
			case "mj2":
			case "dvb":
			case "dcf":
			case "m21":
			case "mkv":
			case "mk3d":
			case "mka":
			case "mks":
			case "mpg":
			case "mpeg":
			case "m2p":
			case "ps":
			case "ts":
			case "tsv":
			case "tsa":
			case "mxf":
			case "ogv":
			case "ogx":
			case "ogm":
			case "omg":
			case "txd":
			case "wtv": return true;
			default: return false;
		}
	}

	private static String getFileExtension(String filename){
		int extensionIndex = filename.indexOf('.') + 1;
		if(extensionIndex == 0) {
			System.out.println(filename);
			return filename;
		}
		else {
			return filename.substring(extensionIndex);
		}
	}

	private static String getNameWithoutExtension(String filename){
		//remove file extension
		filename = filename.substring(0, filename.indexOf(getFileExtension(filename)));
		//remove dot preceding extension
		filename = filename.substring(0, filename.length() - 1);
		return filename;
	}

	private static void convertAudioToWave(File f){
		try{
			String path = makePathBashCompatible(f.getAbsolutePath());
			ProcessBuilder pb = new ProcessBuilder("bash/extractAudio.sh", path);
			pb.inheritIO();
			Process p = pb.start();
			p.waitFor();
		}catch(IOException e){
			System.out.println("Error: cannot convert/extract audio");
			return;
		}catch(InterruptedException e){
			System.out.println("Something was interrupted");
			return;
		}
	}

	public static String makePathBashCompatible(String path){
		String p= path.replaceAll(" ", "\\\\ ");
		System.out.println("New Path: " + p);
		System.out.println("\\ \"");
		return path;
	}
}