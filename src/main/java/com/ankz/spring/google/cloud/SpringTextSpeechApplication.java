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

		String text_1 = "Hi Everyone,\n"
				+ "Good morning, good after noon or good evening to all of you , well based upon the timezone you are in.\n"
				+ "This is iSearch team thanking all the jury members for giving us their time and this opportunity to portray the innovation done by the team. \n"
				+ "\n"
				+ "I would like to set the stage and would walk the talk detailing the work done, please feel free to interrupt if you require any clarification at that moment or you may hold the query while we reach to our Q & A session.  \n"
				+ "I hope you all are able to see the presentation so will get started.\n" + "\n" + "\n"
				+ "Before we jump into the detailing, we would like to put some light on why we choose the name iSearch. - iSearch says that search within Impetus, it also says I myself can search, with no dependency. \n"
				+ "So basically We can define iSearch as a tool to explore and gain insight within Impetus hence the nomenclature impetus search or iSearch.\n"
				+ "\n"
				+ "It is an  initiative that aims to transform the existing manual Project Management Operations into an in-house platform powered by search/visualization capabilities using the modern scalable and extendable tech stack.\n"
				+ "This is a product which opens up a gateway to PMO processes; but not restricted to only this particular set of audience.\n"
				+ "Currently it is helping to make life easy for HEGs, PMOs and to some extent each employee within impetus.\n"
				+ "\n"
				+ "If i may take the liberty to say, Most of the innovations are due to technology migrations or due to customer requirements but iSearch is beyond technology migrations or customer requirements. We will be detailing it in few moments. \n"
				+ "\n" + "The Agenda we have here is on the screen. \n"
				+ "During this presentation, we will walk you through\n" + "\n" + "the team involved.\n"
				+ "what lies within iSearch and what it offers.\n"
				+ "what is the technology stack which powers it beneath.\n"
				+ "what is the impact and influence it has on the organization and what is it capable of in its future iterations.\n"
				+ "and lastly we would be keen to go through your thoughts and suggestions, and would be helping with the queries if any over QnA.\n"
				+ "\n"
				+ "So on this opening note, I would hand-over to Alok,  who conceptualize this idea and facilitated us to deliver this through-out.\n";

		String text_2 = "The Product’s viability is envisioned based upon the resources available within and as we all know, when people are tagged to client projects they find it hard to devote dedicated efforts to other projects.\n"
				+ "Considering this , we tried to kept the breadth of technologies which involves minimum learning curve for one to quickly jump on the bandwagon.\n"
				+ "Also we have utilized all the open source alternatives to keep the overall cost of the product low and affordable in the longer run.\n"
				+ "\n" + "So the tech-stack used here is collection of;\n"
				+ "Apache TIKA - for parsing doc/pdf format documents  which are prevalent in resumes.\n"
				+ "Apache POI - for parsing Excel/Spreadsheets to keep the parser development effort minimum.\n" + "\n"
				+ "\n"
				+ "REST-APIs with Spring Boot - Helps to remove the boiler-plate code and reduce the dev effort and time. Also provides Spring-Security which helps to maintain the authentication & authorization aspects with less efforts.\n"
				+ "One-unified-homepage iSearch ; which brings all the services under one umbrella for smooth UX.\n"
				+ "\n" + "\n"
				+ "ES -  to index the documents in json format and is compatible with the rest-api and provide fast real-time querying the data.\n"
				+ "Kibana - which works well with ES and provide decent options for reporting and charting. The dashboards are easily customizable by what we consider as technical/non-technical persons and can cater to a wide spectrum of audience.\n"
				+ "\n"
				+ "Apache HTTP Server- Considering the high-availability and failover, to replicate the indexed data on the File-server and make it available to audience as-it-is basis for future purposes/ as per use-case. \n"
				+ "Python-utilities - to automate the process quickly and less-resouce extensive.\n" + "\n"
				+ "From architecture point of view, iSearch incorporates micro-service architecture where each component/service is running as independent pluggable module and unavailability of one doesn't effect others.\n"
				+ "We also provide run-time deployment options. presently embedded TC but can be scaled as docker containers which can sit on ES cluster.\n"
				+ "\n";

		String text_3 = "Initially the iSearch application was designed for only searching the available candidates based on the skillset, so we thought of using a standalone database and use custom UI using any of the front-end technologies like Angular/Bootstrap etc. But as the scope of the application increased, we explored the best solution using Elastic and Kibana as the major source for data persistence and visualization.\n"
				+ "We moved away from the archaic monolithic architecture to microservice application with each component as a separate service for reading data from various sources like MIS/Empower/Operation team etc. All the flow is handled via Spring BOOT rest endpoints and spring security for authentication.\n"
				+ "\n"
				+ "Next we are relying heavily on Apache Tikka for parsing the uploaded resumes in the document format and extracting the required data for to be index. This helps us in resource planning and help the talent acquisition team to monitor the pipeline of skilled resources available.\n"
				+ "\n"
				+ "Most of our reports are in excel format so we use Apache POI for parsing them and push the parsed data to elastic indexes. We also maintain a repository of the question based on the technology so that candidates can prepare or get some familiarity on the level of questions being asked during the client interview.\n"
				+ "\n"
				+ "As discussed, earlier Elastic is the backbone of our application which holds all the data being pushed from different sources and Kibana is used extensively as an UI/dashboard for filtering out the required data for PMO/Resource Managers and the Impetus leadership team. Entire infrastructure is powered by the CI/CD pipeline using gitlab. \n"
				+ "\n"
				+ "Moving onto the next slide, we have the central Network Attached Driver (NAS) where all the documents/resumes are uploaded. The NAS driver is constantly being watched by the watch service for any new documents to be picked up for processing. Likewise, we have the Resume Parser, Json Generator etc. as the watch service defined. Once the events are triggered the data is extracted and pushed to elastic via HTTP end points and data is finally index. Any no voice user can come and see the reports/dashboard from the Kibana visualization tool.\n"
				+ "\n"
				+ "This is pretty much on the tech stack and the architecture of the iSearch product. Handing it to Yogaraj for providing some light Innovation Applied and how iSearch impacts the organization\n"
				+ "";
		String outpath = "./output/out.mp3";
		String inpath = "./input/mpthreetest.mp3";

		System.out.println("calling Text2SpeechClass.run !!!");
//		Text2SpeechClass.run(text_0, outpath);
		Text2SpeechClass.run_v2(text_2, outpath);

		System.out.println("calling Speech2TextClass.run !!!");
//		Speech2TextClass.run(outpath);
	}
}
