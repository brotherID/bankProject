package org.bank.payment.file.exchange.api;


import lombok.AllArgsConstructor;
import org.bank.payment.file.exchange.dtos.CheckDTO;
import org.bank.payment.file.exchange.service.CheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import static org.zalando.problem.Status.NOT_FOUND;

@RestController
@RequestMapping("/api/v1/bank")
@AllArgsConstructor
public class CheckController {

    public static final String CHECK_NOT_FOUND = "Check not found";
    private final CheckService checkService;

    @GetMapping(value = "/checks/{checkId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<CheckDTO> getCheckById(@PathVariable(name = "checkId") String checkId) {
        return checkService.getCheckById(checkId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> Problem.builder()
                        .withTitle(CHECK_NOT_FOUND)
                        .withStatus(NOT_FOUND)
                        .withDetail("Le cheque avec l'ID " + checkId + " n'a pas été trouvée.")
                        .build());
    }


    @PostMapping(value = "/check")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCheck(@RequestBody CheckDTO checkDTO, @RequestParam(value = "idDiscount") String idDiscount) {

        try {
            return ResponseEntity.ok(checkService.addCheck(checkDTO, idDiscount));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount not found with ID : " + idDiscount);
        }
    }


}
