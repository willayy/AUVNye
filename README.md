# AUVNye
A very simple calculator for "Aktieutspädning vid nyemission" built with Maven.

#### Build
To build and run the application, run the following command in the root directory of the project. Running it without this command will result in javaFX runtime components not being added at runtime.

```
mvn clean javafx:run
```

To build the application as a standalone package (jar), run the following command in the root directory of the project

```
mvn clean package
```

Then you need to download the dependent jar files 
```javafx.controls,javafx.fxml,javafx.graphics``` 
(or the whole javaFx sdk which is what i did) and add them on runtime with the following command

```
java --module-path path/to/your/javafx-sdk-21.0.2/lib  --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar auvnye-1.0.0.jar
```

#### Dependencies
JavaFX 21.0.2 (FXML included)

