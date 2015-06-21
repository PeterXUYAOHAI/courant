package siat.courant.event;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2015/6/17.
 */
public class TextParser {
    BufferedReader br;

    public Event nextParsedEventFromFile() throws IOException {
        return parsedEventByLine(br.readLine());
    }

    public void readFile(String FilePath) throws IOException {
        br = new BufferedReader(new FileReader(FilePath));
    }

    public Event parsedEventByLine(String line){
        String[] words = line.split("\\s+");
        if (words[0].equals("StockEvent"))
            return new StockEvent(Long.parseLong(words[2]),Integer.parseInt(words[1]),Integer.parseInt(words[6]),Integer.parseInt(words[5]), Integer.parseInt(words[3]),words[4]);
        else if(words[0].equals("Geo3in"))
            return (new Geo3in(Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]),Long.parseLong(words[4])));
        else if(words[0].equals("Rfid3in"))
            return new Rfid3in(Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]), Long.parseLong(words[4]),Integer.parseInt(words[5]));
        return null;

    }
}
