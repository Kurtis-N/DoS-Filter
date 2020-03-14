# DoS-Filter
Jetty's DoS filter implementation using SpringBoot and Gradle

# To Run Locally
1. Clone project and import into IntelliJ or similar IDE
2. Run: gradle clean assemble bootRun
OR
1. Launch the jar directly
2. java -jar build/libs/jetty-dos-filter-example-1.0.0.jar

Open your browser and navigate to: http://localhost:8080/hello
You should see some welcome text.
I defaulted the DoS Filter to have maximum 1 request per second and to set a delay of 3 seconds on all requests over that limit.
If you press refresh quickly (more than once a second you will see the delay before loading, then switch over to your console and you should see the DoS Alert show up in the logs with additional details.
