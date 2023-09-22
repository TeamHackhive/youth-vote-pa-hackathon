# Youth Vote PA Hackathon Webapp
This project was created during the Citi tech fest 2023 Hackathon. 

## Tech Stack
Our Tech stack is the following:
* Java Springboot (backend)
* HTML5, CSS, JavaScript (frontend)
* Tomcat (webserver)

We bundle our frontend files into a jar file and then deploy it onto our Tomcat webserver which resides on an EC2 instance within AWS. The Tomcat webserver then serves our html files.

## Functionality
We currently have limited functionality that can be accessed via the frontend those are the voter registration form and the election info page.

Behind the scenes we have a lot more APIS that are ready to go and all they need is the appropriate user interface pages and buttons to be used.

## Deploying
For the Java backend we use Maven as our package manager and bundler.
1. Have an appropriate POM.xml file
2. run the command `mvn clean`
3. run the command `mvn install`

