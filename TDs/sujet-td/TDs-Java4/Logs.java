import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Stack;

class Logs {
    protected Stack<LogLine> stack = new Stack<>();

    public void add(String message, Robot emetteur, Robot tiers) {

        LogLine log = new LogLine(message, emetteur, tiers);
        stack.add(log);
    }

    public String toString() {
        String res = "";
        for (LogLine logLine : this.stack) {
            res += logLine.toString() + "\n";
        }
        return res;
    }

    public LogLine trouveLigne(Robot emetteur, Robot tiers) throws Exception {
        for ( LogLine line: this.stack ) {
            if (line.sender == emetteur && line.autre == tiers) {
                return line;
            }
        }
        throw new Exception("pas trouve");
    }
}
