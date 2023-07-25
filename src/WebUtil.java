import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для отправки и обработки запросов
 */
public class WebUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static ValCurs sendRequest(Date date, String codeISO) throws IOException, InterruptedException, JAXBException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.cbr.ru/scripts/XML_daily.asp?date_req=" + sdf.format(date))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String result = response.body();
        return getFromXML(result, codeISO);
    }

    private static ValCurs getFromXML(String response, String codeISO) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        return (ValCurs) context.createUnmarshaller().unmarshal(new StringReader(response));
    }
}
