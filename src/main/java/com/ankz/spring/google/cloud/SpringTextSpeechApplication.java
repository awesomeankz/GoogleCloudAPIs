package com.ankz.spring.google.cloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ankz.spring.google.cloud.speech2text.Speech2TextClass;
import com.ankz.spring.google.cloud.text2speech.Text2SpeechClass;

@SpringBootApplication
public class SpringTextSpeechApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringTextSpeechApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		String text = "Hello There! How are you doing today? This is Google Cloud Text-to-Speech Demo!";
		String outpath = "./output/out.mp3";
		
		
		System.out.println("calling Text2SpeechClass.run !!!");
//		Text2SpeechClass.run(args);
		Text2SpeechClass.run(text, outpath);
		
		
		System.out.println("calling Speech2TextClass.run !!!");
		Speech2TextClass.run(outpath);
	}
}
