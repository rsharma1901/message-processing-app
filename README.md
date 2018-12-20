"# message-processing-app" 

Steps to Run: 
1. run mvn clean install to download all dependencies for the maven project.
2. It's spring boot application, run the application as java project and will initialize all the beans and JMS listener starts listening to the messages on the queue.
3. For test purpose i have harcoded more than 50 messages in the list and put them in the queue at the application startup.
4. After running application please check the console for the detailed logs/
