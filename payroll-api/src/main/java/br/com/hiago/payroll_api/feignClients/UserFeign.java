package br.com.hiago.payroll_api.feignClients;

import br.com.hiago.payroll_api.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api")
public interface UserFeign {

    @GetMapping("/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long  id);

    @GetMapping(value = "/todos")
    ResponseEntity<List<User>> findAll();

}
