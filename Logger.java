import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void PrintMessage(String messageString) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"); //Year-Month-Date Hours:Minutes:Seconds.MilliSeconds
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(String.format("[%s] : [INFO] : " + messageString, formattedDate));
    }
}
