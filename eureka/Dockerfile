FROM java:8
COPY *.jar /app.jar
CMD ["--server.port=8761"]
EXPOSE 8761
ENTRYPOINT ["java","-jar","./app.jar"]
