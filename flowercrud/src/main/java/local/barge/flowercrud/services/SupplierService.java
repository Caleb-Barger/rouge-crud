package local.barge.flowercrud.services;

import local.barge.flowercrud.models.Supplier;

import java.util.List;

public interface SupplierService{
    Supplier findSupplierById(long id);

    List<Supplier> findAllSuppliers();

    Supplier findSupplierByName(String name);
}
