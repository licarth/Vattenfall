import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by thomas on 5/7/14.
 */
public class UnmarchallTest {
    @Test

    public void testIfUnmarchallerWorks() {
        try {

            File xmlToParse = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(SMeterEngineResult.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SMeterEngineResult result = (SMeterEngineResult) jaxbUnmarshaller.unmarshal(xmlToParse);
            System.out.println(result);

        } catch (JAXBException e) {
            e.printStackTrace();
        }



}
}
