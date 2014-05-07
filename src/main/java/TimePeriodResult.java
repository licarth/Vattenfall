import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by thomas on 5/7/14.
 */
@ToString
public class TimePeriodResult {
    @XmlTransient
    public DateTime begin;
    @XmlTransient
    public DateTime end;

    @XmlElement
    public List<DistrictTimeStampData> districtTimestampData;

    @XmlAttribute
    public void setBegin(String string) {
        this.begin = DateTime.parse(string);
    }

    @XmlAttribute
    public void setEnd(String string) {
        this.end = DateTime.parse(string);
    }

}