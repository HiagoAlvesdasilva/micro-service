package br.com.hiago.user_api.resources.impl;

import br.com.hiago.user_api.domain.User;
import br.com.hiago.user_api.resources.UserResource;
import br.com.hiago.user_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
