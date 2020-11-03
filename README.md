# Pet Clinic - Spring Boot Web Application

## Installation steps

Execute following commands in order to run Pet Clinic app in Docker:

> git clone https://github.com/robertgherlan/pet-clinic.git

To download the source code locally.

> cd pet-clinic
Move to 
> mvn clean package

Build the **Spring Boot Fat Jar**.  

> docker build -t spring-boot-pet-clinic-web .

Build the Docker image with **spring-boot-pet-clinic-web** tag.

> docker run -d -p 8080:8080 spring-boot-pet-clinic-web

This command will run the Docker container which is accessible on 8080 port.

> docker ps

This command display all running containers.

If the container is displayed then the appplication can be accesed with following address:  
> [http://localhost:8080](http://localhost:8080)
