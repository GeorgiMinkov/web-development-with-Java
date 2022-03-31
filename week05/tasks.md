For all your tasks use your Ticket system project from week04

## Task 0
Implement two [logging](https://www.graylog.org/post/server-log-files-in-a-nutshell#:~:text=A%20server%20log%20file%20is,or%20the%20application%20was%20accessed.) mechanism to show data from your application - to a console and to a file

Your custom loggers must implement the following interface:
```
public interface Logger {

    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
```

The first implementation should use the STDOUT (standard output -> System.out.println)

The second one should store information inside file (use the code snippet bellow)
```
private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
    File log = new File("log.txt");
    try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
        out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

```

Based on the logging level defined inside the application.propeties limit the information that you log inside your application.

Logging parameters: INFO, DEBUG, TRACE
```
INFO level log only INFO
DEBUG level log INFO & DEBUG
TRACE level log INFO & DEBUG & TRACE
```
error log is always shown.


Based on your active spring profile you must use the appropriate implementation
For example 
```
local profile to use the STDOUT implementation
dev profile to use the FILE implementation
```

## Task 1
Finish your implementation for Ticket system from week04.
Use your custom logger inside the ticket system.

Example. log data when you enter creation method -> logger.info("createEvent triggered");


## Task 2
Implement data reading from the application.properties file.

Add inside it a maximum value for row and seat. Then use this value for your ticket creation method

```
use the following notation
config.event.maximum_row
config.event.maximum_seat
```

Tips: you can use @Value or AppConfig class from lecture example. 
[similar class implementation](https://github.com/GeorgiMinkov/smart-garden/blob/master/ms-smart-garden/src/main/java/bg/unisofia/fmi/robotcourse/config/AppConfig.java) and
[property file](https://github.com/GeorgiMinkov/smart-garden/blob/master/ms-smart-garden/src/main/resources/application.properties)

## Task 3
Create different profiles named: naroden, stairichen

Based on the runned spring profile initilize two list with different event names and description.
```
config.event.name=Chervenata shapchitsa,Test
config.event.description=alabala,testing description
```

From those list initilized simple Events (date data can be random generated)
