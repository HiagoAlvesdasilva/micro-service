package br.com.hiago.payroll_api.services;

import br.com.hiago.payroll_api.domain.Payroll;
import br.com.hiago.payroll_api.feignClients.UserFeign;
import br.com.hiago.payroll_api.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    @Autowired
    private final Environment environment;

    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        try {
            var user = userFeign.findById(workerId).getBody();
            if (Objects.nonNull(user)){
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            } else {
                System.out.println("User not found");
            }
        } catch (FeignException.FeignClientException ex){
            throw new ObjectNotFoundException("Objetc not found");
        } catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
