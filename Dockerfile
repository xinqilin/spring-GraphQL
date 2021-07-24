FROM openjdk:11
COPY ./target/*.jar C:/ideaProjects/docker-workspace/graphQL.jar
WORKDIR C:/ideaProjects/docker-workspace
RUN sh -c 'touch graphQL.jar'
ENTRYPOINT ["java","-jar","graphQL.jar"]