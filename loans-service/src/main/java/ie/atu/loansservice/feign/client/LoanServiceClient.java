package ie.atu.loansservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="users-service", url="http://localhost:8080/api/user")
public interface LoanServiceClient {

    @GetMapping("/callUserService/{userId}")
    String getUserById(@PathVariable("userId") String userId);
}
