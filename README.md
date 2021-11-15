## Follow this steps to launch app
* You need to install Tomcat 9.0.54 or latest, Java 11, MySQL.
* Fork from this repository
* Start new project using using this repo as source
* In folder resource you will find file init_db.sql. Launch this code on your MySQL
* Find file db.properties in resource folder. Fill this field with your data
  ** URL - URL of your connection
  ** USERNAME - DB username
  ** PASSWORD - DB - password
  ** JDBC_DRIVER - MySQL drive name
* Configure your Tomcat
* Launch app