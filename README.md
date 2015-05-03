# jee7-jaas-sample
JEE7 (EJB 3.2 JSF2.2 Primefaces 5 JAAS ) with maven (WAR EJB EAR modules)

To build:
Open Command Prompt, go to the source direcotry and type mvn.

To run:
Download mysql-connector-java-5.1.35-bin.jar.
Download Wildfly 8.2 Final.
Copy module.xml to the "wildfly-8.2.0.Final\modules\system\layers\base\com\mysql\main" directory.
Copy mysql-connector-java-5.1.35-bin.jar to the same directory.
Copy standalone.xml to the "wildfly-8.2.0.Final\standalone\configuration" directory.

Any modifications of the original standalone.xml file are commented with "SAMPLEAPP".

Download and install MySQL.
Import database dump from 'database' catalogue. 
