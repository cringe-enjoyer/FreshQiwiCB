import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

/**
 * Класс описывающий оболочку для списка всех полученных по запросу валют
 */
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {
    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "Valute")
    private ArrayList<Valuta> valutes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Valuta> getValutes() {
        return valutes;
    }

    public void setValutes(ArrayList<Valuta> valutes) {
        this.valutes = valutes;
    }

    public Valuta getValuta(String codeIso) {
        for (Valuta valuta : valutes) {
            if (valuta.getCharCode().equals(codeIso))
                return valuta;
        }
        return null;
    }
}
