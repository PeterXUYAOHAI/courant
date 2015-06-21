package siat.courant.engine;

import siat.courant.IO.OutputActor;
import siat.courant.IO.Receiver;
import siat.courant.event.Event;
import siat.courant.stream.BlockingQueueStream;
import siat.courant.stream.StreamHub;
import siat.courant.stream.Streamizable;
import siat.courant.query.NFA;

import java.io.IOException;

public class PseudoEngine {
	Streamizable stream;
	EngineConfig engineConfig;
	Receiver receiver;
	OutputActor outputActor;

	public PseudoEngine(){
		stream=new BlockingQueueStream();
	}
	
	public void setInputStreamFrom(StreamHub streamHub){
		streamHub.registerStream(stream);
	}
		
	public void printStream(){
		stream.printStream();
	}

	public void setNfa(String filePathName){
		NFA nfa = new NFA(filePathName);
		engineConfig = new EngineConfig();
		engineConfig.setTimeWindow(nfa.getTimeWindow());
		engineConfig.setSize(nfa.getSize());
		engineConfig.setIsHasPartitionAttribute(nfa.isHasPartitionAttribute());
		engineConfig.setIsHasNegation(nfa.isHasNegation());
		engineConfig.setSelectionStrategy(nfa.getSelectionStrategy());
		engineConfig.setPartitionAttribute(nfa.getPartitionAttribute());
		//outputLevel is set to be default(to-String) , could be changed by setOutputLevel(int outputLevel)
		//outputName is set to be default(""), could be changed by setOutputName(String outputName)
		//outputPath is set to be default("test.txt") , could be changed by setOutputPath(String outputPath)
		//outputForm is set to be default(by tuple), could be changed by setOutputType(String outputForm)
	}

	public void runEngine() throws IOException {
		receiver = new OutputActor(engineConfig);;
		Tuple tuple = new Tuple();
		pseudoProcessor(tuple);	//  specific method to be added,using pseudoProcessor instead first
	}

	public void pseudoProcessor(Tuple tuple) throws IOException {
		while(stream.getSize()>0) {
			tuple.addEvent(stream.popEvent());
			if (tuple.getSize() >= 3)
				break;
		}
		outputTuple(tuple);
	}

	public void addEvent(Event event){
	}
	public void outputTuple(Tuple tuple) throws IOException {
			receiver.addTuple(tuple);
	}

	public void setOutputLevel(int outputLevel){
		engineConfig.setOutputLevel(outputLevel);
	}

	public void setOutputForm(String outputForm){
		engineConfig.setOutputType(outputForm);
	}
	public String getPartitionAttribute(){
		if (this.engineConfig !=null)
			return this.engineConfig.getPartitionAttribute();
		else
			return "";

	}
	public int getTimeWindow(){
		if (this.engineConfig !=null)
			return this.engineConfig.getTimeWindow();
		else
			return 0;
	}
	public int getSize(){
		if (this.engineConfig !=null)
			return this.engineConfig.getSize();
		else
			return 0;
	}
	public boolean isHasPartitionAttribute(){
		if (this.engineConfig !=null)
			return this.engineConfig.isHasPartitionAttribute();
		else
			return false;
	}

	public boolean isHasNegation(){
		if (this.engineConfig !=null)
			return this.engineConfig.isHasNegation();
		else
			return false;
	}

	public String getSelectionStrategy(){
		if (engineConfig !=null)
			return this.engineConfig.getSelectionStrategy();
		else
			return null;
	}
}
