import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        boolean isWork = true;
        Scanner scanner = new Scanner(System.in);
        while (isWork) {
            System.out.println("Введите ISO код валюты");
            String codeISO = scanner.nextLine();
            System.out.println("Введите дату в формате YYYY-MM-DD");
            try {
                Date date = convertToDate(scanner.nextLine());
                ValCurs valuta = WebUtil.sendRequest(date, codeISO);
                System.out.println(valuta.getValuta(codeISO));
            } catch (ParseException e) {
                System.err.println(e);
                System.out.println("Введен неверный формат даты");
            } catch (JAXBException | IOException | InterruptedException e) {
                System.err.println(e);
                System.out.println("Ошибка запроса");
            }
            System.out.println("Завершить работу приложения?\nДа/Нет");
            String answer = scanner.nextLine();
            isWork = answer.equals("Нет") || answer.equals("нет");
        }
        scanner.close();
    }

    private static Date convertToDate(String date) throws ParseException {
        return sdf.parse(date);
    }
}
