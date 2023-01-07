package bond.web.cors.proxy.controller;

import bond.web.cors.proxy.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HttpGetController {

    private final HttpClientService httpClient;

    @Autowired
    public HttpGetController(HttpClientService httpClient) {
        this.httpClient = httpClient;
    }

    @RequestMapping(value = "v1", produces = "application/json")
    @ResponseBody
    public Object getObject(@RequestHeader Map<String, String> headers,
                            @RequestParam Map<String, String> params) {
        return Optional.of(httpClient.get(headers, params)).orElse("");
    }
}
