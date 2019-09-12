package com.ankz.spring.google.cloud.text2speech;

//Imports the Google Cloud client library
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Google Cloud TextToSpeech API sample application. Example usage: mvn package
 * exec:java -Dexec.mainClass='com.example.texttospeech.Text2SpeechClass'
 */
public class Text2SpeechClass {

	/**
	 * Demonstrates using the Text-to-Speech API.
	 */
	public static void run(String... args) throws Exception {
		// Instantiates a client
		try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
			// Set the text input to be synthesized
			System.out.println("args[0] : " + args[0]);
			SynthesisInput input = SynthesisInput.newBuilder().setText(args[0]).build();

			// Build the voice request, select the language code ("en-US") and the ssml
			// voice gender
			// ("neutral")
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US")
					.setSsmlGender(SsmlVoiceGender.NEUTRAL).build();

			// Select the type of audio file you want returned
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.LINEAR16).build();

			// Perform the text-to-speech request on the text input with the selected voice
			// parameters and
			// audio file type
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

			// Get the audio contents from the response
			ByteString audioContents = response.getAudioContent();

			// Write the response to the output file.
			try (OutputStream out = new FileOutputStream(args[1])) {
				out.write(audioContents.toByteArray());
				System.out.println("Audio content written to file : " + args[1]);
			}
		}
	}
}