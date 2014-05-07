import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by thomas on 5/7/14.
 */
@Setter
@ToString
public class DistrictResult {
        @XmlAttribute
        public DistrictName name;
        @XmlElement
        public TimePeriodResult period;
}
