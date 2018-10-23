### Developer: Shalotte Sam



# Basic Programming 

In this project we are required to read data from a txt file, clean the data then write the cleaned data in an sql file.

### Getting Started
The following are the instructions to get this copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

Software you need to install on your machine to run the project:

* SDK : jdk version 1.8.0_161
* SCM: git version 2.19.0
* Build Tool: maven version apache-maven-3.5.4
* Unit Test: junit version 4.11

### Installing the software

##### Java

First download JDK from this link https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html. Place it as one of your environment variables. To ensure that JDK is installed on your local machine input java -version on the command prompt, you should get an output displaying the version output e.g java version "1.8.0_161".


##### Maven

First download Maven from this link https://maven.apache.org/download.cgi. Put it as one of you environment variables. To ensure that maven is installed on your local machine input mvn -version on the command prompt, you should get an output displaying the version output e.g Apache Maven 3.5.4.

##### Git

First download Git from this link https://git-scm.com/downloads. To check if git is installed use git -version on your command prompt.

##### Junit Testing

The Junit version is added as a dependency in the pom.xml.



#### After installing the software and cloning the repository, you can run the project in the following manner.

* Navigate to the directory of the project containing the pom.xml and execute mvn clean package. maven will start building the project.
* After having build the project navigate to the directory with the jar file execute the command java -jar application.jar sample_1.txt 500. Where sample_1.txt is the directory of the txt file to be processed and 500 is the userid.
* The output should be the following:
Output : <file_name>.sql
insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values(400, 'Manmay', 'Mohanty', 'M', '07/03/1983', true);
insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values(401, 'Marike', 'Fourie', 'F', '30/11/2001', false);
