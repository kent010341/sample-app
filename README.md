# sample-app
A sample project that contains techniques of 

* Kendo UI (jQuery, JavaScript, HTML5)
* RESTful API (Apache CXF)
* JPA (Hibernate)
* Apache Karaf 
* Apache Maven

## Development Environment
* JDK 11
* Apache Karaf 4.2.10
* MySQL 5.7 (requires a database called `test`)

## Install
### http & cxf feature
In Karaf console, add and install `http` features, run:  
   
```
karaf@root()> feature:repo-add http
```
and install  
  
```
karaf@root()> feature:install http
```  

```
karaf@root()> feature:install cxf
```

### Install Karaf's standard feature
1. Download (`git clone`) the karaf repository on github: [here](https://github.com/apache/karaf)
 
  ```
  git clone https://github.com/apache/karaf.git
  ```

2. Remember to `checkout` to the version required. (In this case, `4.2.10`)  
  
  ```
  git checkout karaf-4.2.10
  ```

3. `cd` to `karaf/assemblies/features/standard`
4. Use maven to clean and install
  
  ```
  mvn clean install
  ```

5. This will provide a feature called `http-whiteboard`

### Install feature of sample-app

1. Use maven to clean and install (use `-DskipTests` to skip the test phase)  
  
   ```
   mvn clean install -DskipTests
   ```  

2. Add the feature of `sample-app`:  
 
   ```
   karaf@root()> feature:repo-add mvn:kent/service-feature/LATEST/xml
   ```

3. Install data source:  
 
   ```
   karaf@root()> feature:install f-service-datasource
   ```

4. Install service:  
 
   ```
   karaf@root()> feature:install f-service
   ```
   
5. Install whiteboard:  
 
   ```
   karaf@root()> feature:install f-service-whiteboard
   ``` 

### Check if all karaf bundle is active
1. Use `bundle:list` to list all bundles
2. If the state isn't active, use `bundle:start` with its id to activate it. For example:
   
   ```
   karaf@root()> bundle:start 130
   ```

## Web Service
After active `service-whiteboard`, open any browser and check [http://localhost:8181/web/index.html](http://localhost:8181/web/index.html)

> Currently it may be an empty grid because there's nothing in the MySQL database.

* As long as this website is loaded, it will send GET request.
* Button "Add new record" send POST request.
* Button in-line "Edit" send PUT request.
* Button in-line "Delete" send DELETE request.
