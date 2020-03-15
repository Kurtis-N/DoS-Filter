# DoS-Filter
An implementation of Jetty's DoS filter using SpringBoot and Gradle.
Launch the web app and hit refresh multiple times to see your requests throttled.

# Build Run Locally
1. Clone project and import into IntelliJ or similar IDE
2. Run: gradle clean assemble bootRun
# Or Run Jar directly
1. Launch the jar directly
2. java -jar build/libs/jetty-dos-filter-example-1.0.0.jar

# What to expect
Open your browser and navigate to: http://localhost:8080/hello

You should see some welcome text.


I defaulted the DoS Filter to have maximum 1 request per second and to set a delay of 3 seconds on all requests over that limit.

If you press refresh quickly (more than once a second you will see the delay before loading, then switch over to your console and you should see the DoS Alert show up in the logs with additional details.

![DoS Console Image](https://i.imgur.com/OZgkhdH.png)
