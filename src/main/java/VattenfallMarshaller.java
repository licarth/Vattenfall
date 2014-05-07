import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by thomas on 5/7/14.
 */
public class VattenfallMarshaller {

    private static final String URL = "https://www.vattenfall.de/SmeterEngine/networkcontrol";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(SMeterEngine.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            SMeterEngine p = new SMeterEngine();
            p.setCity(City.BERLIN);
            p.setScale(Scale.DAY);
            District district = new District();
            district.setName(DistrictName.Spandau);
            district.setTime_period(new TimePeriod(new DateTime(2014, 1, 1, 0, 0), new DateTime(2014, 5, 7, 0, 0)));
            p.setDistrict(district);
            StringWriter sw = new StringWriter();
            m.marshal(p,sw);
            System.out.println(sw.toString());

            HttpClient client = new DefaultHttpClient();
            HttpPost httpRequest = new HttpPost(URL);
            httpRequest.setHeader("Content-Type", "application/xml");
            String xmlString = sw.toString();
            StringEntity entity = new StringEntity(xmlString);
            httpRequest.setEntity(entity);
            HttpResponse response = client.execute(httpRequest);
            String result = EntityUtils.toString(response.getEntity());
//            System.out.println(result);

            //Unmarshall

            JAXBContext jaxbContext = JAXBContext.newInstance(SMeterEngineResult.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SMeterEngineResult result2 = (SMeterEngineResult) jaxbUnmarshaller.unmarshal(new StringReader(result));
//            System.out.println(result2);

            FileOutputStream fop = null;
            File file;
            String content = "This is the text content";

            try {

                file = new File("out.csv");
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                //cols
                StringBuilder sb = new StringBuilder();
                sb.append("date");
                sb.append(", ");
                sb.append("usage");
                sb.append(", ");
                sb.append("generation");
                sb.append(", ");
                sb.append("feed");
                sb.append(", ");
                sb.append("key-account-usage");
                sb.append("\n");
                fop.write(sb.toString().getBytes());

                for (DistrictTimeStampData districtTimeStampData : result2.district.period.districtTimestampData) {
                    sb = new StringBuilder();
                    sb.append(districtTimeStampData.value.toDateTime());
                    sb.append(", ");
                    sb.append(districtTimeStampData.usage);
                    sb.append(", ");
                    sb.append(districtTimeStampData.generation);
                    sb.append(", ");
                    sb.append(districtTimeStampData.feed);
                    sb.append(", ");
                    sb.append(districtTimeStampData.keyAccountUsage);
                    sb.append("\n");
                    fop.write(sb.toString().getBytes());
                }
                fop.flush();

                fop.close();

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
