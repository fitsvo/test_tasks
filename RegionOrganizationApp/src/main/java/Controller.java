import com.fasterxml.jackson.core.JsonProcessingException;
import models.Organization;
import models.OrganizationsResponse;
import utils.Config;
import utils.Connect;
import utils.JacksonUtil;

import java.util.*;

public class Controller {
    static String RESIDENT = "Резидент РФ";

    public static int getCountOrganizationRegion(String regionCode, Map<String, Integer> mapOfOrganization){
        return mapOfOrganization.get(regionCode);
    }

    public static Map<String, Integer> getCountOrganization(){
        List<Organization> organizations = getListOrganization(Connect.getRB(Config.getStr("ApiUrl")));
        Map<String, Integer> resultMap = new HashMap<>();
        try{
            int regionCount = Config.getInt("RegionCount");
            for(int regionInc = 1; regionInc < regionCount; regionInc++){
                int finalRegionInc = regionInc;
                resultMap.put(String.format("%02d",regionInc),
                        (int) organizations.stream().filter((organization) -> organization.getInn().startsWith(String.format("%02d", finalRegionInc))
                                && organization.getResidence().equals(RESIDENT)
                                && organization.getBlockDate() == null).count());
                }
        } catch (Exception e) {
            System.out.println("Проблема получения ответа от сервера: " + e.getMessage());
        }
        return resultMap;
    }
    public static List<Organization> getListOrganization(String response){
        List<Organization> organizations = new ArrayList<>();
        try{
            OrganizationsResponse organizationsResponse = JacksonUtil.getMapper().readValue(response, OrganizationsResponse.class);
            organizations = organizationsResponse.getOrganizations();
        } catch (JsonProcessingException e) {
            System.out.println("Проблема получения ответа от сервера: " + e.getMessage());
        }
        return organizations;
    }
}
