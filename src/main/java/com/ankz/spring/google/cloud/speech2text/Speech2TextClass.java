package com.ankz.spring.google.cloud.speech2text;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Speech2TextClass {
	
	 /**
	   * Demonstrates using the Speech API to transcribe an audio file.
	   */
	  public static void run(String... args) throws Exception {
	    // Instantiates a client
	    try (SpeechClient speechClient = SpeechClient.create()) {

	      // The path to the audio file to transcribe
	    	System.out.println("fileName : " + args[0]);
	      String fileName = args[0];

	      // Reads the audio file into memory
	      Path path = Paths.get(fileName);
	      byte[] data = Files.readAllBytes(path);
	      ByteString audioBytes = ByteString.copyFrom(data);

	      // Builds the sync recognize request
	      RecognitionConfig config = RecognitionConfig.newBuilder()
//	          .setEncoding(AudioEncoding.LINEAR16)
	    		  .setEncoding(AudioEncoding.LINEAR16)
	          .setEnableAutomaticPunctuation(true)
	          .setLanguageCode("en-US")
	          .build();
	      RecognitionAudio audio = RecognitionAudio.newBuilder()
	          .setContent(audioBytes)
	          .build();

	      // Performs speech recognition on the audio file
	      RecognizeResponse response = speechClient.recognize(config, audio);
	      List<SpeechRecognitionResult> results = response.getResultsList();
	      
	      System.out.println("results : " + results);

	      for (SpeechRecognitionResult result : results) {
	        // There can be several alternative transcripts for a given chunk of speech. Just use the
	        // first (most likely) one here.
	        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
	        System.out.printf("Transcription: %s%n", alternative.getTranscript());
	      }
	    }
	  }
}
