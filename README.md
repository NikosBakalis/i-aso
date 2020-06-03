# i-aso
In Greece almost every hospital uses it's own software platform to register doctors, nurses, patients and other information. That causes various problems like lack of compatibility between different platforms and many communication problems. I-aso, willing to help these hospitals provides this platform to all of them.

## Name
This project named after a deity intertwined with the concept of healing Iaso *(Ιασώ)*.

## Contributors
* [Bakalis Nikolas](https://github.com/NikosBakalis): nbakalis@ceid.upatras.gr
* [Karatzas Andreas](https://github.com/andreasceid): ankaratzas@ceid.upatras.gr
* [Mayaki Anna](https://github.com/annamayaki): magiaki@ceid.upatras.gr
* [Tsakas Panagiotis](https://github.com/TsakasPanagiotis): tsakas@ceid.upatras.gr

## Execution
* With IntelliJ Idea:
```
1. Clone the project to the IDE.
    1. Copy the GitHub web page url: *https://github.com/NikosBakalis/i-aso*.
    2. Open IntelliJ IDEA click on: *Get from Version Control*.
    3. Paste the link into the URL area.
    4. Click clone.
2. Set your JRE version to 1.8 or above.
3. In *i-aso* folder expand *Java* and right click *Main.java*. Then clink on *Run 'Main.main()'*.
```
***
* With .jar file:
```
Future update.
```
***

## Dependencies
#### Database
```
1. You need to have a database server installed on your computer like MySQL Worckbench, XAMPP, etc.
2. Find our MySQL folder expand it and get iaso_prototype-v08.2.sql and iaso_prototype-v08.2-inserts.sql
3. Execute the MySQL code of these two files to your database server.
4. Your database is now ready.
```

#### Connection
```
1. Open up IntelliJ IDEA and load i-aso.
2. Use "Ctrl + Alt + Shift + S" to open Project Structure.
3. Click on "Libraries", add a "New Project Library" and click "Java".
4. On the new window find "Libraries\mysql-connector-java-8.0.19.jar" and click "Ok".
5. Your connection is now ready.
```

#### Connection Properties
```
1. Into the MySQL folder find connection.properties file and open it up.
2. Set your personal database connection info into the file.
3. Your connection properties are now ready.
```