import lombok.Data;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by thomas on 5/6/14.
 */
@Setter
@XmlRootElement(name="smeterengine")
@XmlAccessorType(XmlAccessType.FIELD)
public class SMeterEngine {

    @XmlElement
    private Scale scale;
    @XmlElement
    private City city;

    @XmlElement
    private District district;

    @XmlAttribute
    private String type;
}
