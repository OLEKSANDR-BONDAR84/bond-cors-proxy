package bond.web.cors.proxy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HttpClientServiceImpl implements HttpClientService {

    private final static String ERROR_CODE_DEF = "{\"status\":\"error\",\"code\":\"404\"," +
            "\"message\":\"Request has been failed.\"}";

    @Override
    public Object get(Map<String, String> headers, Map<String, String> params) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<String> response = restTemplate.exchange(
                    headers.get("url"),
                    HttpMethod.GET,
                    new HttpEntity<Map<String, String>>(headers),
                    String.class,
                    params);
            if (response.hasBody()) {
                return response.getBody();
            }
        } catch (RuntimeException ex) {
            return ex.getMessage();
        }
        return ERROR_CODE_DEF;
    }
}
