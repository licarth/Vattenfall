import lombok.Data;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

/**
 * Created by thomas on 5/7/14.
 */
@Setter
public class TimePeriod {
    private DateTime begin;
    private DateTime end;

    @XmlAttribute(name = "time_zone")
    private TimeZone time_zone;

    public TimePeriod(DateTime begin, DateTime end){
        this.time_zone = TimeZone.CET;
        this.begin = begin;
        this.end = end;
    }

    @XmlAttribute
    public String getBegin() {
        return begin.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @XmlAttribute
    public String getEnd() {
        return end.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
    }
}