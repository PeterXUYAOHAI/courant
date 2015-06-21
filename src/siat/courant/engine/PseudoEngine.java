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
	EngineConfigurer engineConfigurer;
	Receiver receiver;
	OutputActor outputActor;

	public PseudoEngine(){
		stream=new BlockingQueueStream();
		receiver = new OutputActor();
	}
	
	public void setInputStreamFrom(StreamHub streamHub){
		streamHub.registerStream(stream);
	}
		
	public void printStream(){
		stream.printStream();
	}

	public void setNfa(String filePathName){
		NFA nfa = new NFA(filePathName);
		engineConfigurer = new EngineConfigurer();
		engineConfigurer.setTimeWindow(nfa.getTimeWindow());
		engineConfigurer.setSize(nfa.getSize());
		engineConfigurer.setIsHasPartitionAttribute(nfa.isHasPartitionAttribute());
		engineConfigurer.setIsHasNegation(nfa.isHasNegation());
		engineConfigurer.setSelectionStrategy(nfa.getSelectionStrategy());
		engineConfigurer.setPartitionAttribute(nfa.getPartitionAttribute());
		//outputLevel is set to be default(to-String) , could be changed by setOutputLevel(int outputLevel)
		//outputName is set to be default(""), could be changed by setOutputName(String outputName)
		//outputPath is set to be default("test.txt") , could be changed by setOutputPath(String outputPath)
		//outputForm is set to be default(by tuple), could be changed by setOutputType(String outputForm)
	}

	public void runEngine() throws IOException {
		/*
		specific method to be added
		 */
		Tuple tuple = new Tuple();
		while(stream.getSize()>0)
			tuple.addEvent(stream.popEvent());
		outputTuple(tuple);
	}
	public void addEvent(Event event){
	}
	public void outputTuple(Tuple tuple) throws IOException {
//		if (engineConfigurer.getOutputType().equals("tuple")) {
			receiver.addTuple(tuple);
//		}
//		if (engineConfigurer.getOutputType().equals("event")) {
//			for (Event e : tuple.getEvents()) {
//				receiver.addTuple(e);
//			}
//		}
	}
		//outputActor.output(tuple,engineConfigurer.getOutputLevel());

	public void setOutputLevel(int outputLevel){
		engineConfigurer.setOutputLevel(outputLevel);
	}



	public void setOutputForm(String outputForm){
		engineConfigurer.setOutputType(outputForm);
	}
	public String getPartitionAttribute(){
		if (this.engineConfigurer !=null)
			return this.engineConfigurer.getPartitionAttribute();
		else
			return "";

	}
	public int getTimeWindow(){
		if (this.engineConfigurer !=null)
			return this.engineConfigurer.getTimeWindow();
		else
			return 0;
	}
	public int getSize(){
		if (this.engineConfigurer !=null)
			return this.engineConfigurer.getSize();
		else
			return 0;
	}
	public boolean isHasPartitionAttribute(){
		if (this.engineConfigurer !=null)
			return this.engineConfigurer.isHasPartitionAttribute();
		else
			return false;
	}

	public boolean isHasNegation(){
		if (this.engineConfigurer !=null)
			return this.engineConfigurer.isHasNegation();
		else
			return false;
	}

	public String getSelectionStrategy(){
		if (engineConfigurer !=null)
			return this.engineConfigurer.getSelectionStrategy();
		else
			return null;
	}
}
