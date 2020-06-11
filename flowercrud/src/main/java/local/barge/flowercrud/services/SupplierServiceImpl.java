package local.barge.flowercrud.services;


import local.barge.flowercrud.models.Supplier;
import local.barge.flowercrud.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier findSupplierById(long id) throws EntityNotFoundException {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier " + id + " Not Found"));
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        List<Supplier> list = new ArrayList<>();

        supplierRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Supplier findSupplierByName(String name) throws EntityNotFoundException {
        Supplier supplier = supplierRepository.findByName(name);
        if (supplier == null) {
            throw new EntityNotFoundException("Supplier " + name + " Not Found");
        }

        return supplier;
    }
}
