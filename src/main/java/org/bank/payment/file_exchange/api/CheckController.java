package org.bank.payment.file_exchange.api;


import lombok.AllArgsConstructor;
import org.bank.payment.file_exchange.dtos.CheckDTO;
import org.bank.payment.file_exchange.service.CheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class CheckController {

    private final  CheckService checkService;

    @GetMapping(value="/check")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getCheckById(@RequestParam(name = "idCheck") String idCheck){
        try {
            return ResponseEntity.ok(checkService.getCheckByIdCheck(idCheck));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check not found with ID : " + idCheck);
        }
    }


    @PostMapping(value="/check")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCheck(@RequestBody CheckDTO checkDTO , @RequestParam(value = "idDiscount") String idDiscount){

        try {
            return ResponseEntity.ok(checkService.addCheck(checkDTO,idDiscount));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount not found with ID : " + idDiscount);
        }
    }


}
