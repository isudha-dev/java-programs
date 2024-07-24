package interview.synopsys.Task2;

import java.io.*;
import java.util.*;
//import com.codility.event.Event;

public class PropertiesFileHelper {
    public static String APPLICATION_PROPERTIES = "application.properties";
    public static final String CSV_FILE_NAME_KEY = "csv.file.name";
    public static final String DEFAULT_FILE_NAME = "default.csv";

    public static String csvFileNameFromProperties() {
        // TODO: implement
        // NOTE: While working with this method an exception may be thrown.
        // Please catch any Exceptions, and return DEFAULT_FILE_NAME after Exception was caught.
        Properties properties = new Properties();

        try(InputStream is = PropertiesFileHelper.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {

            if(is != null) {
                properties.load(is);
            } else {
                throw new RuntimeException("application.properties file does not exists");
            }

            return properties.getProperty(CSV_FILE_NAME_KEY);

        } catch (Exception e) {
            return DEFAULT_FILE_NAME;
        }

    }
}

