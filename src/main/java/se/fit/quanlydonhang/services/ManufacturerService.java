package se.fit.quanlydonhang.services;

import se.fit.quanlydonhang.models.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    void saveManufacturer(Manufacturer manufacturer);
    List<Manufacturer> findAll();
    void updateManufacturer(Manufacturer manufacturer);
    void deleteManufacturer(Manufacturer manufacturer);
    boolean delete(String id);
    Optional<Manufacturer> findById(String id);
}
