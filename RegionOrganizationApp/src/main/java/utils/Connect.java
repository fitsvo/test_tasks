package utils;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

public class Connect {
    public static String getRB(String url) {
        Response response;
        try(AsyncHttpClient http = new DefaultAsyncHttpClient()){
            response = http.prepareGet(url).execute().get();
            if (!response.getResponseBody().contains("Error")) return response.getResponseBody();
            else throw new Exception();
        } catch (Exception e) {
            System.out.println("Ошибка подключения.");
            return "";
        }
    }
}
