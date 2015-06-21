package siat.courant.IO;

import siat.courant.engine.EngineConfigurer;
import siat.courant.engine.RemoteService;
import siat.courant.engine.Tuple;
import siat.courant.event.Event;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by asus on 2015/6/16.
 */
public class OutputActor implements Receiver {

    int outputLevel;//0-toString 1-toDB 2-toSocket 3-toFile 4-toRemote

    Tuple tuple = new Tuple();
    EngineConfigurer engineConfigurer;

//    public OutputActor(){
//        this.outputLevel = 0;
//        this.outputName = "test.txt";
//        this.outputPath = "";
//    }
//
//    public OutputActor(String outputPath, String outputName,int outputLevel){
//        this.outputLevel = outputLevel;
//        this.outputName = outputName;
//        this.outputPath = outputPath;
//    }
//
// public void output(Tuple tuple, int outputLevel){
//     if (outputLevel==0)
//         tuple.toString();
//     else if (outputLevel==1)
//         outputToDB(tuple);
//     else if (outputLevel==2)
//         outputToSocket(tuple);
//     else if (outputLevel==3)
//      //   outputToFile(tuple);
//     //else if (outputLevel==4)
//         //outputToRemote(tuple);
//        return;
// }
//
//    public void outputToDB(Tuple tuple){
//
//    }
//    public void outputToSocket(Tuple tuple){
//
//    }

    public void outputToFile(Tuple tuple,String filePath,String fileName) throws IOException {
        File file = new File(filePath+"/"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getName(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(tuple.toString());
        bw.close();

    }

//    public void outputToRemote(Tuple tuple,RemoteService remoteService){
//        ArrayList<Event> events = tuple.getEvents();
//        for (Event e:events )
//            remoteService.resultsProcess(e);
//    }

    @Override
    public void addTuple(Tuple tuple) throws IOException {
        this.tuple=tuple;
        outputToFile(tuple,"","test2");
    }
}
