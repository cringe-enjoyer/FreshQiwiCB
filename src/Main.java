import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        //args = USD 2022-10-08
        //boolean isWork = true;
        //Scanner scanner = new Scanner(System.in);
        //while (isWork) {
            //System.out.println("Введите ISO код валюты");
            //scanner.nextLine();
            //System.out.println("Введите дату в формате YYYY-MM-DD");
            try {
                String codeISO = args[0];
                Date date = convertToDate(args[1]);//scanner.nextLine());
                ValCurs valuta = WebUtil.sendRequest(date);
                System.out.println(valuta.getValuta(codeISO));
            } catch (ParseException e) {
                System.err.println(e);
                System.out.println("Введен неверный формат даты");
            } catch (JAXBException | IOException | InterruptedException e) {
                System.err.println(e);
                System.out.println("Ошибка запроса");
            }
            catch (Exception e) {
                System.err.println(e);
                System.out.println("Неверные параметры");
            }
            //System.out.println("Завершить работу утилиты?\nДа/Нет");
            //String answer = scanner.nextLine();
            //isWork = answer.equals("Нет") || answer.equals("нет");
        //}
        //scanner.close();
    }

    private static Date convertToDate(String date) throws ParseException {
        return sdf.parse(date);
    }
}
