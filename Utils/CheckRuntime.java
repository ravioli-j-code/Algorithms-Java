package Utils;

public class CheckRuntime {
    
    private long start = 0;
    private long end = 0;

    public void start() {
        this.start = System.currentTimeMillis();
        this.end = System.currentTimeMillis();
    }

    public void end() {
        this.end = System.currentTimeMillis();
    }

    public String getResult() {
        return "runtime is : " + (end - start) + " milliseconds.";
    }


}
