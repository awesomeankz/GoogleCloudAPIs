# GoogleCloudAPIs
Google Cloud apis for Text-Speech Conversions



https://www.callicoder.com/spring-boot-docker-example/

#  package the application in the form of a jar file using maven

$ mvn clean package

#build the docker image by typing the following command
 
$ docker build -t spring-boot-GoogleCloudAPIs-demo .

# list the docker imgs

$ docker image ls

#run it using docker run command in foreground -

$ docker run -p 5000:8021 spring-boot-GoogleCloudAPIs-demo 

	In the run command, we have specified that the port 8021 on the container should be mapped to the port 5000 on the Host OS.
	Once the application is started, you should be able to access it at 
	http://localhost:5000.


#run it using docker run -d option in detached mode 

$ docker run -d -p 5000:8021 spring-boot-GoogleCloudAPIs-demo

1c3528715862a8a8efb712c85bc8ab61f3419c04eb6dc613af76c89846d316e0 <-- ContainerId

# list of all containers running in your system

$ docker container ls