package org.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "FnsClient",
        url = "https://api-fns.ru/api"
)
public interface FnsClient {
    @PostMapping("/egr")
    String getClientFnsData(@RequestParam("req") String req,@RequestParam("key") String  key);
}
