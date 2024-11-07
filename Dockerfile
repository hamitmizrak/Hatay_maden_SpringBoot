# Image Create
FROM openjdk:17

#ARG JAR_FILE=/target/Hatay_SpringBoot.jar
#ARG JAR_FILE=*.jar
ARG JAR_FILE=/target/*.jar

# Yukarıdaki değişken ismini kısalttım
ADD ${JAR_FILE} blog.jar

ENTRYPOINT ["java","-jar","/blog.jar"]

##################################################
# docker build -t imageName .
# docker build -f CustomerDockerfile -t imageName .
# docker image ls
# docker ps
# docker ps -a
# docker container run -d -p 5555:4444 --rm ecommerce