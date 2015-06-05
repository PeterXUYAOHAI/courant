package siat.courant.engine;

import siat.courant.event.*;
import siat.courant.stream.*;
import java.util.*;


public interface Engine{
	//void initialize();
	void runEngine();
	void evaluateRuns(Event event); //for SkipTillNextMatch
	void evaluateRuns(Event event, Run run);
	void addRunByPartition(Run newRun); //not prior

	void evaluateEventForPartitionContiguity(Event e, Run r);
	void addEventToRun(Run run, Event event);
	boolean checkPredicate(Event event, Run run);
	boolean checkPartition(Event event, Run run);
	boolean checkProceed(Run run);
	boolean checkNegation(Run run);
	Run cloneRun(Run run);
	boolean checkTimeWindow(Event event, Run run);
	boolean outputMatch(Match match);

	boolean deleteRunsOverTimeWindow(long currentTime, long timeWindown, long delayTime);
	void cleanRuns();
	void cleanRunsByPartition();
	Streamizable getInput(Streamizable stream);
	void setInput(Streamizable stream);
	EventBuffer getBuffer();
	void setBuffer(EventBuffer eventBuffer);
	NFA getNFA(); // MUST BE modified	
	void setNFA();
	RunPool getEngineRunController();
	void setEngineRunController(RunPool engineRunController);
	ArrayList<Run> getActiveRuns();
	void setActiveRuns( ArrayList<Run> activeRuns);
	MatchController getMatches();
	void setMatches(MatchController matches);
	ArrayList<Run> getToDeleteRuns();
	void setToDeleteRuns(ArrayList<Run> toDeleteRuns);
	HashMap<Long, ArrayList<Run>> getActiveRunsByPartition();
	void setActiveRunsByPartition(HashMap<Long, ArrayList<Run>> activeRunsByPartition);
	
}
