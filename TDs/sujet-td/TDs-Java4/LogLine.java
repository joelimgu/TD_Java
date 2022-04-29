import java.util.Date;

class LogLine {
    protected Date date;
    protected String message;
    protected Robot sender;
    protected Robot autre = null;

    public LogLine(String message, Robot sender) {
        this.date = date;
        this.message = message;
        this.sender = sender;
    }
    public LogLine(String message, Robot sender, Robot autre) {
        this.date = date;
        this.message = message;
        this.sender = sender;
        this.autre = autre;
    }

    public String toString() {
        String s = date.toString() + "] sender:" + this.sender + " mes: " + this.message + " tiers: " + this.autre;
        return s;
    }
}
