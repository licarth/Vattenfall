import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * Created by thomas on 5/7/14.
 */
@ToString
@Setter
public class District {
        @XmlAttribute
        private DistrictName name;
        @XmlElement
        private TimePeriod time_period;
}
