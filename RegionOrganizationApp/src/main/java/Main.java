
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> result = createData();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите код региона, либо \"обновить\" для обновления данных, либо \"выход\" для выхода: ");
            String regionCode;
            while (!(regionCode = reader.readLine()).equals("выход")) {
                if (regionCode.equals("обновить")) {
                    result = refreshData();
                }
                try {
                    int count = Integer.parseInt(regionCode);
                    if (regionCode.length() > 2) throw new NumberFormatException();
                    System.out.println("Количество организаций в регионе : "
                            + Controller.getCountOrganizationRegion(String.format("%02d", count), result));
                } catch (NumberFormatException e) {
                    System.out.println("Введенное число не соответствует коду региона.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка формирования ответа: " + e.getMessage());
        }
    }

    private static Map<String, Integer> refreshData() {
        System.out.println("Данные обновляются, подождите.");
        Map<String, Integer> result = Controller.getCountOrganization();
        System.out.println("Данные обновлены.");
        return result;
    }

    private static Map<String, Integer> createData() {
        return refreshData();
    }
}
