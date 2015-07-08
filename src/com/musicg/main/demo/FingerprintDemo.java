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

public class FingerprintDemo{
	
	public static void main (String[] args){
		System.out.println(Runtime.getRuntime().totalMemory());
		String filename = "Smallest mbgitr.wav";

		fingerprint(filename);
	}

	private static void fingerprint(String filename){
		// create a wave object
		System.out.println(Runtime.getRuntime().freeMemory());
		Wave wave = new Wave("Audio/"+filename);

		// get the fingerprint
		byte[] fingerprint=wave.getFingerprint();

		// dump the fingerprint
		FingerprintManager fingerprintManager=new FingerprintManager();
		fingerprintManager.saveFingerprintAsFile(fingerprint, "out/"+filename+".fingerprint");

		System.out.println("Size (bytes): " + fingerprint.length);
		// load fingerprint from file
		//byte[] loadedFp=fingerprintManager.getFingerprintFromFile("out/"+filename+".fingerprint");
	}
}