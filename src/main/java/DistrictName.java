import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by thomas on 5/7/14.
 */
@XmlEnum
public enum DistrictName {
    Pankow,
    Lichtenberg,
    @XmlEnumValue("Marzahn-Hellersdorf")
    Marzahn_Hellersdorf,
    @XmlEnumValue("Treptow-Koepenick")
    Treptow_Koepenick,
    Neukoelln,
    Friedrichshain_Kreuzberg,
    Mitte,
    @XmlEnumValue("Tempelhof-Schöneberh")
    Tempelhof_Schöneberg,
    Steglitz_Zehlendorf,
    @XmlEnumValue("Charlottenburg-Wilmersdorf")
    Charlottenburg_Wilmersdorf,
    Reinickendorf,
    Spandau;

}
