package utils;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

public class Connect {
    public static String getRB(String url) {
        Response response;
        try(AsyncHttpClient http = new DefaultAsyncHttpClient()){
            response = http.prepareGet(url).execute().get();
            return response.getResponseBody();
        } catch (Exception e) {
            System.out.println("Ошибка подключения.");
            return "";
        }
    }
}
