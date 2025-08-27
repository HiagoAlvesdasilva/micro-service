package br.com.hiago.payroll_api.resources;

import br.com.hiago.payroll_api.domain.Payroll;
import br.com.hiago.payroll_api.domain.User;
import br.com.hiago.payroll_api.feignClients.UserFeign;
import br.com.hiago.payroll_api.services.PayrollService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {


    private final PayrollService service;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
        return ResponseEntity.ok().body(service.getPayment(workerId, payment));
    }
}
