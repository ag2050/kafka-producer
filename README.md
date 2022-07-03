# kafka-producer
This project highlights following.
<li> Produce record in Kafka cluster launced in confluent cloud.</li>
<li> Store DB credentials outside of the artifacts/jars in encripted format and pull those encripted data then decode it and create datasource instance during bootstrap process.</li>


In order to connect with Confluent cloud we need API Keys consist of Api key and a secret. You can generate API Keys from Confluent.

spring.kafka.properties.bootstrap.servers =pkc-ymrq7.us-east-2.aws.confluent.cloud:9092
spring.kafka.properties.sasl.mechanism=PLAIN
spring.kafka.properties.sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule   required username='<API Keys Goes here>'   password='<Secret goes here>';
spring.kafka.properties.security.protocol=SASL_SSL

spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.IntegerSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.topic=transaction-events
 
  
Note: I have used base64 encoading to encrypt datasource properties and placed outside the artifacts/jar. below command was used to run jar from commandline 
  java -jar <jar-name> -Dspring.config.location=application.properties
application.properties mentioned above in the argument is outside of the artifact.
