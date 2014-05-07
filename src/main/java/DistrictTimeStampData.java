import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.*;

/**
 * Created by thomas on 5/7/14.
 */
@ToString
public class DistrictTimeStampData {
    @XmlTransient
    public DateTime value;

    @XmlAttribute(name = "value")
    public void setValue(String string) {
        this.value = DateTime.parse(string);
    }

    @XmlElement
    public Double usage;
    @XmlElement
    public Double generation;
    @XmlElement
    public Double feed;
    @XmlElement(name = "key-acount-usage")
    public Double keyAccountUsage;

}
