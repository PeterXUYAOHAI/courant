package siat.courant.engine;

/**
 * Created by asus on 2015/6/16.
 */
public class EngineConfigurer {

    private String selectionStrategy;
    private int timeWindow;
    private int size; //also call sequenceLength
    private boolean isHasPartitionAttribute;
    private boolean isHasNegation;
    private String SelectionStrategy;
    private boolean hasNegation;
    private boolean hasPartitionAttribute;
    private boolean printResults = true;
    private int outputLevel = 0; //e.g.0-toString 1-toDB 2-toSocket 3-toFile 4-toRemote
    private String outputPath = "";
    private String outputName = "text.txt";
    private String partitionAttribute;
    private String outputForm; //by "tuple" or by "event"




    public EngineConfigurer(){}

    public void setTimeWindow(int timeWindow) {
        this.timeWindow = timeWindow;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setIsHasPartitionAttribute(boolean isHasPartitionAttribute) {
        this.isHasPartitionAttribute = isHasPartitionAttribute;
    }

    public void setIsHasNegation(boolean isHasNegation) {
        this.isHasNegation = isHasNegation;
    }

    public void setSelectionStrategy(String selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    public void setPartitionAttribute(String partitionAttribute) {
        this.partitionAttribute = partitionAttribute;
    }

    public void setOutputLevel(int outputLevel) { this.outputLevel = outputLevel; }




    public int getTimeWindow() {
        return timeWindow;
    }

    public int getSize() {
        return size;
    }

    public boolean isHasNegation() {
        return isHasNegation;
    }

    public boolean isHasPartitionAttribute() {
        return isHasPartitionAttribute;
    }

    public String getSelectionStrategy() {
        return selectionStrategy;
    }

    public String getPartitionAttribute() {return partitionAttribute;}

    public int getOutputLevel() {
        return outputLevel;
    }


    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public String getOutputForm() {
        return outputForm;
    }

    public void setOutputForm(String outputForm) {
        this.outputForm = outputForm;
    }
}