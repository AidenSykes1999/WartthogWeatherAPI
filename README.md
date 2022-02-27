# Warthog's-Weather-API

<img src="ProgramImages/spartaLogo.png" align="right" width="160" />

![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-blue?style=for-the-badge&logo=appveyor)
![Log4J](https://img.shields.io/badge/-Log4J-orange?style=for-the-badge&logo=appveyor)
![IntelliJ](https://img.shields.io/badge/-IntelliJ-black?style=for-the-badge&logo=appveyor)
![JDK](https://img.shields.io/badge/-JDK-cyan?style=for-the-badge&logo=appveyor)
![JUnit](https://img.shields.io/badge/-JUnit-magenta?style=for-the-badge&logo=appveyor)
![agile](https://img.shields.io/badge/-Agile-yellow?style=for-the-badge&logo=appveyor)
![scrum](https://img.shields.io/badge/-Scrum-red?style=for-the-badge&logo=appveyor)
![cucumber](https://img.shields.io/badge/-Cucumber-darkgreen?style=for-the-badge&logo=appveyor)
![testing](https://img.shields.io/badge/-Testing-green?style=for-the-badge&logo=appveyor)

> Contributors:
>
> • Roberto Lovece - Junior Java SDET Consultant | [Portfolio](https://robertolovece.github.io/Portfolio-Website/) | [GitHub](https://github.com/RobertoLovece) | [LinkedIn](https://www.linkedin.com/in/roberto-lovece-20abb121a/) |
>
> • Suyash Srivastava - Junior Java SDET Consultant | [GitHub](https://github.com/SuyashsGit) | [LinkedIn](https://www.linkedin.com/in/suyash-srivastava-0a977a15a/) |
>
> • Mehmet Yetim - Junior Java SDET Consultant | [GitHub](https://github.com/mehmetyetim) | [LinkedIn](https://www.linkedin.com/in/mehmet-akif-yetim-65a4081b6/) |
>
> • Aiden Sykes - Junior Java SDET Consultant | [GitHub](https://github.com/AidenSykes1999) | [LinkedIn](https://www.linkedin.com/in/aiden-sykes/) |
>
> • Stephen Jones - Junior Java SDET Consultant | [GitHub](https://github.com/StephenJones1997) | [LinkedIn](https://www.linkedin.com) |
>
> • Donovan Cupueran - Junior Java SDET Consultant | [GitHub](https://github.com/djucacupueran) | [LinkedIn](https://www.linkedin.com/in/donovan-juca-01b7aa222/) |
>
>

## **Table Of Contents**
* [**Overview**](#overview)
* [**What is framework?**](#what-is-framework)
* [**Project Planning (Agile)**](#project-planning)
    - [Sprint 1](#sprint-1)
    - [Sprint 2](#sprint-2)
    - [Sprint 3](#sprint-3)
    - [Mood Board](#mood-board)
    - [User Stories](#user-stories)
* [**Software and Dependencies**](#software-and-dependencies)
    - [IntelliJ](#intellij)
    - [JDK](#jdk)
    - [Apache Maven](#apache-maven)
    - [JUnit Jupiter API](#junit-jupiter-api)
    - [Jackson](#jackson)
    - [Hamcrest](#hamcrest)
* [**How to use the project**](#how-to-use-the-project)
    - [How to download](#how-to-download)
    - [Instructions for using the project on the console](#instructions-for-running-the-application-on-the-console)
* [**Testing**](#testing)
    - [JUnit Testing](#junit-testing)
    - [Manual Testing](#manual-testing)
    - [Mocking](#mocking)
* [**Future work**](#future-work)

### **Overview**

In this project, we have built a testing framework to test the Open Weather Map API.
Our framework will only be focused on the [Current Weather](https://openweathermap.org/current) section.

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **What is framework?**

A framework, or software framework, is a platform that provides a foundation for developing software applications. They’re used in many industries, including web development, data science, and more.

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Project Planning**

#### **Sprint 1**
ADD DETAILS AND SCREENSHOTS
#### **Sprint 2**
ADD DETAILS AND SCREENSHOTS
#### **Sprint 3**
ADD DETAILS AND SCREENSHOTS
#### **Mood Board**

ADD DETAILS AND SCREENSHOTS
#### **User Stories**
ADD DETAILS AND SCREENSHOTS


<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Software and dependencies**
#### **IntelliJ**
IntelliJ IDEA is an integrated development environment written in Java for developing computer software. It is developed by JetBrains, and is available as an Apache 2 Licensed community edition, and in a proprietary commercial edition. Both can be used for commercial development.
- In this application we have used IntelliJ IDEA [Version 2021.3.2](https://www.jetbrains.com/idea/download/#section=windows)

#### **JDK**
The JDK is the Java Development Kit, the full-featured SDK for Java. It has everything the JRE has, but also the compiler (javac) and tools (like javadoc and jdb). It is capable of creating and compiling programs.
- In this application we have used JDK [Version 17.0.2](https://jdk.java.net/17/)
#### **Apache Maven**
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
* _**Note:** This dependency can be imported using IntelliJ._
* _Go to **"File" > "New Project"** and then selecting **"Maven"** as the project structure._
#### **JUnit Jupiter API**

JUnit Jupiter is the API for writing tests using JUnit version 5. JUnit 5 is the project name (and version) that includes the separation of concerns reflected in all three major modules: JUnit Jupiter, JUnit Platform, and JUnit Vintage.
- In this application we have used JUnit Jupiter [Version 5.8.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.2)
* _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
* Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>
```

#### **Jackson**
Jackson is a Java Json library used for parsing and generating Json files. It has built in Object Mapper class which parses json files and deserializes it to custom java objects. It helps in generating json from java objects.

- In this application we have used Jackson [Version 2.13.1](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html)
* _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
* Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.1</version>
    </dependency>
```

#### **Hamcrest**
Hamcrest is a framework that assists writing software tests in the Java programming language. It supports creating customized assertion matchers ('Hamcrest' is an anagram of 'matchers'), allowing match rules to be defined declaratively. These matchers have uses in unit testing frameworks such as JUnit and jMock.


<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **How to use the project**

#### **How to download**
- Step 1: Click on the green 'Code' button and then choose the 'Download ZIP' option.
  <img src="ProgramImages/"/>
- Step 2: Extract the file by double-clicking on the downloaded ZIP file.
  <img src="ProgramImages/"/>
- Step 3: Open IntelliJ IDEA application, then click on File option (the option is in the top left corner of the screen) and then click on Open. Then navigate to the place where you have extracted the folder, select the folder and click 'Open'.
  <img src="ProgramImages/"/>
  <img src="ProgramImages/"/>
- Step 4: Click on 'Trust Project' button, and then Click on 'New Window'.
  <img src="ProgramImages/"/>
  <img src="ProgramImages/"/>
- Step 5: Look for Main.java class after following these steps: WartthogWeatherAPI > src > main > java > com.sparta.weatherapi > Main.java
  <img src="ProgramImages/"/>
- Step 6: Run the Main class and enjoy the project.
  <br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Testing**
#### **JUnit Testing**
- To provide a better performance to the user, all parts of this framework have been thoroughly tested using JUnit (unit testing framework).

ADD DETAILS AND SCREENSHOTS

#### **Manual Testing**

ADD DETAILS AND SCREENSHOTS

#### **Mocking**


ADD DETAILS AND SCREENSHOTS

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Future Work**
Possible improvements for Warthog's Weather API 2.0:
- Allow the framework to work on different modes (xml and html)
- Making the framework to support other endpoints from the [OpenWeather Map API](https://openweathermap.org).

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>
=============================== ENJOY THE PROJECT ===============================