package multithread;

public class SynchThread {

    private int count;

    public SynchThread() {
        count = 0;
    }

    void inc() {
        count = count+1;
    }

    int getInc() {
        return count;
    }

}
