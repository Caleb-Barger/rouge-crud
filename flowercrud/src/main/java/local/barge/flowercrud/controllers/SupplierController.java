package local.barge.flowercrud.controllers;

import local.barge.flowercrud.models.Supplier;
import local.barge.flowercrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/suppliers", produces = {"application/json"})
    public ResponseEntity<?> listAllSuppliers() {
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping(value = "/suppliers/{supplierid}", produces = {"application/json"})
    public ResponseEntity<?> findSupplierById(@PathVariable Long supplierid) {
        Supplier supplier = supplierService.findSupplierById(supplierid);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
}
