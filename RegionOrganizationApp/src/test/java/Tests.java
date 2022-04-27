import models.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Connect;

import java.util.List;


public class Tests {
    @Test
    void test_Not_Null() {
        String jsonResponse = "{\n" +
                "  \"result\": \"OK\",\n" +
                "  \"records\": [\n" +
                "    {\n" +
                "      \"ID\": \"0\",\n" +
                "      \"Name\": \"Компания не определена\",\n" +
                "      \"INN\": \"Не определен\",\n" +
                "      \"Residence\": \"Не определен\",\n" +
                "      \"StoreDate\": \"01.01.2000 00:00:00\",\n" +
                "      \"BlockDate\": \"01.01.2000 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ID\": \"1\",\n" +
                "      \"Name\": \"СП Урожай ООО\",\n" +
                "      \"INN\": \"0205008145\",\n" +
                "      \"Residence\": \"Резидент РФ\",\n" +
                "      \"StoreDate\": \"01.01.2021 00:00:00\",\n" +
                "      \"BlockDate\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ID\": \"2\",\n" +
                "      \"Name\": \"Шкаповское ГПП ООО\",\n" +
                "      \"INN\": \"0255017547\",\n" +
                "      \"Residence\": \"Резидент РФ\",\n" +
                "      \"StoreDate\": \"01.01.2021 00:00:00\",\n" +
                "      \"BlockDate\": \"\"\n" +
                "    }\n]\n}";
        List<Organization> organizations = Controller.getListOrganization(jsonResponse);
        Assertions.assertNotNull(organizations);
    }

    @Test
    void test_Another_Not_Null() {
        String jsonResponse = "{\n" +
        "  \"result\": \"OK\",\n" +
                "  \"records\": []}";
        List<Organization> organizations = Controller.getListOrganization(jsonResponse);
        Assertions.assertNotNull(organizations);
    }

    @Test
    void test_Null() {
        String jsonResponse = "{}";
        List<Organization> organizations = Controller.getListOrganization(jsonResponse);
        Assertions.assertNull(organizations);
    }

    @Test
    void test_Connect_Not_Null() {
        String url = "https://spimex.com/";
        String responseBody = Connect.getRB(url);
        Assertions.assertNotNull(responseBody);
    }

}
