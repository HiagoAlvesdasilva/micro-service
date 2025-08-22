package br.com.hiago.user_api.resources;

import br.com.hiago.user_api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<User> findById(@PathVariable Long  id);

    @GetMapping(value = "/todos")
    ResponseEntity<List<User>> findAll();
}
