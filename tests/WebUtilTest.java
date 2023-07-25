import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class WebUtilTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    @Test
    void sendRequest() {
        String dateStr = "22.07.2023";
        Date date = null;
        Valuta expected = null;
        String isoCode = "USD";
        try {
            date = sdf.parse(dateStr);
            expected = WebUtil.sendRequest(date).getValuta(isoCode);
            Valuta result = new Valuta();
            result.setName("Доллар США");
            result.setNumCode("840");
            result.setCharCode(isoCode);
            result.setNominal(1);
            result.setValue("90,3846");
            result.setId("R01235");
            Assertions.assertEquals(expected.toString(), result.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}