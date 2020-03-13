# Desbugs Selenium Testing

This is The selenium project for the automated test for all the features team and all environments

### Prerequisites

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
* [Maven](https://maven.apache.org/download.cgi)  
* [Git](https://git-scm.com/downloads)  
* [Gecko driver](https://github.com/mozilla/geckodriver/releases),  [Chrome driver](https://sites.google.com/a/chromium.org/chromedriver/downloads), Opera, Edge
* [Allure framework](https://docs.qameta.io/allure/#_installing_a_commandline)  

### Setup

Clone repository from Gitlab

```  
git clone Gitlab_Repository_path_url  
```

Mirror

```  
git clone https://github.com/devGnode/desbugs_selenium_testing.git
```

#### Setup configuration

Directory : ``src/main/resources/config/``

##### WebDriver configuration

Set your binaries webDrivers in this directory ``Drivers/`` that can be found to root of your local repository.

File configuration : ``browser.properties``

```properties
chrome=path/to/webdriver
firefox=path/to/webdriver
opera=path/to/webdriver
edge=path/to/webdriver
```

##### Basic configuration

File configuration : ``configuration.properties``

```properties
proxy.enabled=false
proxy.config=0.0.0.0:8080

front.environment=develop
api.environment=none

test.frontOffice=true
browser.default=chrome
headless=false
device=desktop
extensionPath=
```

You can override some of these properties that would have set in your configuration file with maven ( Konsole command ).

- -Dproxy : ***Boolean*** define if you want enabled proxy or not. *default value* ***false***
- -Dfrontal : ***Boolean*** define if you want make  front-offices tests or just Api test. 
    * ***true*** value will initialize the webDriver *default value*
    * ***false*** value will not initialize the webDriver
- -Dbrowser : to lower case ***String*** the browser that you want launch for realize your front-office test.
    * opera : Check if the setup directory of Opera will be found to ``c:\Program Files`` on Windows platforms.
    * edge : He doesn't support some capabilities like accept uncertified Ssl certificate. 
    * chrome : *default value*
    * firefox
- -Denv : to lower case ***String*** The environment on which you wish to run the tests
    * develop : *default value*
    * ...
- -DapiEnv : to lower case ***String***   The environment on which you wish to run api ( back-office ) tests.
    * api : *default value*
- -Ddevice : to lower case ***String*** the browser pre-configured resolution 
    * desktop : *default value*
    * ....
- -Dheadless : ***Boolean*** whether the tests are launched headless or not
    * true : *default value*
    * false
- -DextensionPath: ***String*** whether the chrome driver needs an extension to be added or not, *void default value*   
    
```
mvn clean test -Dbrowser=firefox -Dheadless=true -Denv=sint
```    

##### Running some specifics tests  

You can easily run a subset of your tests by using the `-Dcucumber.options` argument.  
There, you can filter the scenarios by their tags.  
For example, if you want to run a subset of scenarios tagged with `@smoke`, use the following line command :  

```  
mvn clean test -Dcucumber.options="--tags @smoke"  
``` 

##### Add an environment

File configuration : ``urlEnv.properties``

```properties
develop=
your_environment_name=https://url.provider
```
Implement your environment name in your UrlEnvironment class enumeration.

```java
public enum UrlEnvironment {

    DEVELOP,
    YOUR_ENVIRONMENT_NAME,
    CUSTOM;
    
    /*...*/
}    
```

### Reporting

This framework use Allure report framework

##### command example

```
mvn clean test -Dcucumber.options="--tags @non-reg allure:serve"
```

Sometimes, its possible after to have run test that allure report don't be launch correctly if you be in this situation, look brievely if directory 'allure-results" had been build corectly in 'target/' and use this command :

```
allure serve target/allure-results --port 1778
```

#### Framework architecture

```
Debugs_selenium_testing/
+--- Drivers/
+--- src/
|    +--- main/java
|    |    +--- fr.zenity.debugs
|    |          +--- configuration/
|    |          +--- context/
|    |          +--- driver/
|    |          +--- driverManager/
|    |          +--- Enum/
|    |          +--- PagesObjects/
|    |          +--- utils/
|    |
|    +--- resources
|    |    +--- config/      
|    |    +--- log4j.properties
|    |
|    +--- test/java
|    |    +--- fr.zenity.debugs
|    |         +--- runners/   
|    |         +--- steps/        
|    |
|    +--- resources/
|         +---- features/
|
+--- target/
+--- pom.xml
+--- Readme.ms
```