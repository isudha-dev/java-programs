package interview.synopsys.Task2;

//import com.codility.event.Event;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvFileDao {
        public CsvFileDao() {}

        public List<Event> readAll() throws Exception {
            String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
            String csvFile = "path/to/your/data.csv";
            String line;
            String csvDelimiter = ",";

            List<Event> events = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(csvDelimiter);
                    Event event = Event.builder().build();
                    event.setId(Long.valueOf(values[0]));
                    event.setName(values[1]);
                    event.setDescription(values[2]);

                    String dateTimeString = values[3];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

                    event.setStart(dateTime);

                    dateTimeString = values[4];
                    formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    dateTime = LocalDateTime.parse(dateTimeString, formatter);

                    event.setEnd(dateTime);
                    events.add(event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Print the parsed CSV data
            for (Event record : events) {
                System.out.println();
            }
            return events;
        }

        public void write(Event event) throws Exception {
            String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
            String csvLine = CsvFileUtils.csvLineFromEvent(event) + "\n";
            // TODO: implement
        }

        public Event read(Long eventId) throws Exception {
            List<Event> events = readAll();
            // TODO: implement
            return null;
        }

}
