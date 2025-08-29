package br.com.hiago.user_api.services.impl;

import br.com.hiago.user_api.domain.User;
import br.com.hiago.user_api.repositories.UserRepository;
import br.com.hiago.user_api.services.UserService;
import br.com.hiago.user_api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private final Environment environment;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario de id: "+id+" nâo encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
