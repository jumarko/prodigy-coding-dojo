# GoodData spring-xd module

The GoodData spring-xd module can be used to load data from various sources to the GoodData platform.
 
## Instructions
* Start xd server: `xd-singlenode`
* Start xd shell `xd-shell`
* Build module's jar: `mvn clean package`
* Install module (xd shell): `module upload --type sink --name gooddataSink --file spring-xd-gooddata/target/spring-xd-gooddata-1.0-SNAPSHOT.jar`
* Deploy new stream using `goodDataSink`, e.g. twitter stream (xd shell): `stream create tweets --definition "twitterstream | gooddataSink" --deploy`
* Destroy stream if you no longer need it: `stream destroy tweets`

### Notes
* You need to specify host, username and password for gooddata platform in gooddata.xml 


## Resources
* Spring XD 
  * https://github.com/spring-projects/spring-xd
  * https://github.com/spring-projects/spring-xd/wiki/About-Spring-XD
  * http://docs.spring.io/spring-xd/docs/current/reference/html/
  * https://github.com/jumarko/prodigy-coding-dojo/tree/master/analytics-dashboard
  * https://github.com/spring-projects/spring-xd-samples/tree/master/groovy-script-sink - __good info about using 
  custom module__
* Spring integration
  * https://github.com/spring-projects/spring-integration
  * https://github.com/spring-projects/spring-integration-samples 
* https://bintray.com/bintray/jcenter