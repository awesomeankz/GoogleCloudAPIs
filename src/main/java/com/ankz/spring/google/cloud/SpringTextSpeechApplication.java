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
		
		
		String text_0 = "Hi Ankit. The directions to visit brookfield, can be found on the maps using location mappings.";
		
	
		
	
		String text_2 = "The Product’s viability is envisioned based upon the resources available within and as we all know, when people are tagged to client projects they find it hard to devote dedicated efforts to other projects.\n" + 
				"Considering this , we tried to kept the breadth of technologies which involves minimum learning curve for one to quickly jump on the bandwagon.\n" + 
				"Also we have utilized all the open source alternatives to keep the overall cost of the product low and affordable in the longer run.\n" + 
				"\n" + 
				"So the tech-stack used here is collection of;\n" + 
				"Apache TIKA - for parsing doc/pdf format documents  which are prevalent in resumes.\n" + 
				"Apache POI - for parsing Excel/Spreadsheets to keep the parser development effort minimum.\n" + 
				"\n" + 
				"\n" + 
				"REST-APIs with Spring Boot - Helps to remove the boiler-plate code and reduce the dev effort and time. Also provides Spring-Security which helps to maintain the authentication & authorization aspects with less efforts.\n" + 
				"One-unified-homepage iSearch ; which brings all the services under one umbrella for smooth UX.\n" + 
				"\n" + 
				"\n" + 
				"ES -  to index the documents in json format and is compatible with the rest-api and provide fast real-time querying the data.\n" + 
				"Kibana - which works well with ES and provide decent options for reporting and charting. The dashboards are easily customizable by what we consider as technical/non-technical persons and can cater to a wide spectrum of audience.\n" + 
				"\n" + 
				"Apache HTTP Server- Considering the high-availability and failover, to replicate the indexed data on the File-server and make it available to audience as-it-is basis for future purposes/ as per use-case. \n" + 
				"Python-utilities - to automate the process quickly and less-resouce extensive.\n" + 
				"\n" + 
				"From architecture point of view, iSearch incorporates micro-service architecture where each component/service is running as independent pluggable module and unavailability of one doesn't effect others.\n" + 
				"We also provide run-time deployment options. presently embedded TC but can be scaled as docker containers which can sit on ES cluster.\n" + 
				"\n";
		String outpath = "./output/out.mp3";
		String inpath = "./input/mpthreetest.mp3";
		
		
		System.out.println("calling Text2SpeechClass.run !!!");
		Text2SpeechClass.run(text_0, outpath);
//		Text2SpeechClass.run_v2(text_2, outpath);
		
		
		System.out.println("calling Speech2TextClass.run !!!");
		Speech2TextClass.run(outpath);
	}
}
