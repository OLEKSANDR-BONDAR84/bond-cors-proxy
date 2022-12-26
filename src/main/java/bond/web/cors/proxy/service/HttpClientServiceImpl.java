package bond.web.cors.proxy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HttpClientServiceImpl implements HttpClientService {

    @Override
    public Object get(Map<String, String> headers, Map<String, String> params) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<String> response = restTemplate.exchange(
                    headers.get("url"),
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    String.class,
                    params);
            if (response.hasBody()) {
                return response.getBody();
            }
        } catch (Exception ex) {
            return "";
        }
        return "";
    }
}
