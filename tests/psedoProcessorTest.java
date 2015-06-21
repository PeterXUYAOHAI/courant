import siat.courant.engine.NFA;
import siat.courant.engine.PseudoEngine;
import siat.courant.event.TextParser;
import siat.courant.stream.BlockingQueueStream;
import siat.courant.stream.StreamHub;
import siat.courant.stream.Streamizable;

import java.io.IOException;

/**
 * Created by asus on 2015/6/21.
 */
public class psedoProcessorTest {

    public static void main(String[] args) throws IOException {
        StreamHub streamHub = new StreamHub();
        PseudoEngine pseudoEngine = new PseudoEngine();
        pseudoEngine.setNfa("test1.query");
        pseudoEngine.setInputStreamFrom(streamHub);
        TextParser textParser = new TextParser();
        textParser.readFile("test123");
        for (int i=0; i<8; i++){
            streamHub.notifyStreams(textParser.nextParsedEventFromFile());
        }

        pseudoEngine.setOutputLevel(0);
        pseudoEngine.runEngine();

    }



}
