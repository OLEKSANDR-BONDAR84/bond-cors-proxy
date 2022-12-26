package bond.web.cors.proxy.service;

import java.util.Map;

public interface HttpClientService {

    public Object get(Map<String, String> headers, Map<String, String> params);
}
