import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

/**
 * Created by thomas on 5/6/14.
 */
@Setter
@ToString
@XmlRootElement(name="smeterengine")
//@XmlAccessorType(XmlAccessType.FIELD)
public class SMeterEngineResult {

    @XmlElement
    public Scale scale;

    @XmlElement
    public DistrictResult district;

}
