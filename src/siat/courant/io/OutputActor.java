package siat.courant.io;

import siat.courant.engine.EngineConfig;
import siat.courant.engine.Tuple;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by asus on 2015/6/16.
 */
public class OutputActor implements Receiver {

    int outputLevel;//0-toString 1-toDB 2-toSocket 3-toFile 4-toRemote
    String outputFilePath;
    String getOutputFileName;
    Tuple tuple = new Tuple();
    EngineConfig engineConfig;

    public OutputActor(){}
    public OutputActor(EngineConfig engineConfig){
        outputLevel = engineConfig.getOutputLevel();
        outputFilePath = engineConfig.getOutputFilePath();
        getOutputFileName = engineConfig.getOutputName();
    }

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

    //to be implement
    public void outputToRemote(Tuple tuple){
    }

    //to be implement
    public void outputToDB(Tuple tuple){
    }

    //to be implement
    public void outputToSocket(Tuple tuple){
    }

    public void outputToConsole(Tuple tuple){
        System.out.println(tuple.toString());
    }

    @Override
    public void addTuple(Tuple tuple) throws IOException {
        if (outputLevel==1)
            outputToFile(tuple,outputFilePath,getOutputFileName);
        if (outputLevel==0)
            outputToConsole(tuple);
        if (outputLevel==2);//to be implement
        if (outputLevel==3);//to be implement
    }
}
