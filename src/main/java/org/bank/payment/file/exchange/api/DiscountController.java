package org.bank.payment.file.exchange.api;


import lombok.AllArgsConstructor;
import org.bank.payment.file.exchange.dtos.DiscountDTO;
import org.bank.payment.file.exchange.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/bank")
public class DiscountController {

    private final DiscountService discountService;


    @GetMapping(value="/discount")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getDiscountById(@RequestParam(name = "idDiscount") String idDiscount){
        try {
            return ResponseEntity.ok(discountService.getDiscountByIdDiscount(idDiscount));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount not found with ID : " + idDiscount);
        }
    }


    @PostMapping(value="/discount")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addDiscount(@RequestBody DiscountDTO discountDTO){
            return ResponseEntity.ok(discountService.createDiscount(discountDTO));
    }

}
