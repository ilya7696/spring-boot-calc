package by.tovpenets.springbootcalc.controller;

import by.tovpenets.springbootcalc.model.PaymentRequest;
import by.tovpenets.springbootcalc.model.ResponseAnswer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/{id}")
    public ResponseAnswer showStatus(@PathVariable String id) {
        return new ResponseAnswer(200, "Status for id " + id + " is OK");
    }

    @PostMapping("/pay")
    public ResponseAnswer pay(@RequestBody PaymentRequest request) {
        if (request.getPayment() - request.getDiscount() < 0)
            return new ResponseAnswer(500, "ERROR");
        else return new ResponseAnswer(200, "OK");
    }
}
