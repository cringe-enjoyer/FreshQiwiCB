import jakarta.xml.bind.annotation.*;

/**
 * Класс описывающий валюту из XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Valuta {
    @XmlElement(name = "Valute")
    private String valute;
    /**
     * ISO код валюты
     */
    @XmlAttribute(name = "ID")
    private String id;
    @XmlElement(name = "NumCode")
    private String numCode;
    @XmlElement(name = "CharCode")
    private String charCode;
    @XmlElement(name = "Nominal")
    private int nominal;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Value")
    private String value;

    public String getValute() {
        return valute;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return charCode + " (" + name + "): " + value;
    }
}
