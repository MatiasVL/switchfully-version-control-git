# Spring Boot Tomcat Manual Deploy

As said before, Spring Boot aims to get us up and running as quick as possible (it "just runs").
It does this by packaging a embedded tomcat in our WAR. That way, we don't need to manually deploy WAR files.
But what does that mean, "deploying WAR files"? Let's find out!

## Start by installing Apache Tomcat 9.x

Tomcat is a web container / server that runs web applications (based on Servlets and JavaServer pages), 
but it can also be used as a HTTP server.
In short: it will host and run WAR files.

1. Download Apache Tomcat 9.X
2. Install Apache Tomcat
    - The ui-manager should be installed as well (normally, this is by default)
3. Run the service
    - The tomcat process runs by default on port 8080
    - So, try to surf to `http://localhost:8080`
4. If Tomcat's successfully running and installed, go to `http://localhost:8080/manager/html`
    - It's possible you first have to configure a user
        - Go to `conf/tomcat-users.xml` in your installation directory of Tomcat
        - Add the following line, inside the `<tomcat-users>`tag:
            ```
            <role rolename="manager-gui"/>
            <user username="tomcat" password="s3cret" roles="manager-gui"/>
            ```
5. Login to `http://localhost:8080/manager/html`
6. Tomcat can run multiple WAR simultaneously, we'll be deploying our own WAR pretty soon.

## Now, create a new project

Create a new Maven project:
- GroupId = com.switchfully.spring
- ArtifactId = spring-boot-tomcat-manual-deploy

We're going to use Spring Boot, however, we'll exclude the embedded Tomcat. 
This is purely for the sake of the exercise, to show you how manually deploying a WAR is done. 
In Codelab05 we saw how Spring Boot automates and facilitates this process. 
In this codelab, we'll do it manually!

1. Add the Spring Boot dependency, using the dependency management system (parent pom by Spring Boot)
    ```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.0.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    ```
2. Create a main method class (e.g. Application):
    ```
    @SpringBootApplication
    public class Application extends SpringBootServletInitializer {
    
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(Application.class);
        }
    
        public static void main(String[] args) throws Exception {
            SpringApplication.run(Application.class, args);
        }
    
    }
    ```
    - The SpringBootServerInitializer allows to run a SpringApplication from a traditional WAR deployment
3. Create a controller class, it will be served to the end user when he navigates to the root url ("/")
    ```
    @Controller
    public class GreetingController {
    
        @RequestMapping("/")
        @ResponseBody
        String getWelcomeMessage() {
            return "Hello World!";
        }
    
    }
    ```     
4. Change the packaging to WAR.
    - Since we're using Maven and using spring-boot-starter-parent (which configures Maven’s war plugin for you) 
    all we need to do is to modify our pom.xml to change the packaging to WAR.
        ```
        <packaging>war</packaging>
        ```
5. The final step in the process is to ensure that the embedded servlet container doesn’t interfere with the servlet container (our installed Tomcat) 
to which the war file will be deployed. 
To do so, you need to mark the embedded servlet container dependency as provided ("Hey Maven, this dependency is already provided (although it isn't), don't provide it again").
    ```
    <dependencies>
      <!-- … -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-tomcat</artifactId>
          <scope>provided</scope>
      </dependency>
      <!-- … -->
    </dependencies>
    ```
6. Run `mvn clean package`
    - In your target folder, a WAR should be generated
7. Go back to your Tomcat manager, in the "WAR file to deploy" section, deploy your WAR
8. When deployed, it will show up as a new entry in the "Applications" list, click on its name.
9. You should see the "Hello World" message.

Great, we created a (really basic) web application which we had to manually deploy to a Tomcat.

## Solution

A solution is provided on https://github.com/switchfully/spring-boot-tomcat-manual-deploy
- Only check it out when you're completely finished.
- Don't if you're stuck. If you're stuck: ask questions!
