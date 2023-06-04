package se.fit.quanlydonhang.services.impl;

import org.springframework.stereotype.Service;
import se.fit.quanlydonhang.models.Manufacturer;
import se.fit.quanlydonhang.repositories.ManufacturerRepo;
import se.fit.quanlydonhang.services.ManufacturerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepo manufacturerRepo;

    public ManufacturerServiceImpl(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }
    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepo.save(manufacturer);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepo.findAll();
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerRepo.save(manufacturer);
    }

    @Override
    public void deleteManufacturer(Manufacturer manufacturer) {
        manufacturerRepo.delete(manufacturer);
    }

    @Override
    public boolean delete(String id) {
        Optional<Manufacturer> manufacturerOptional = manufacturerRepo.findById(id);
        if (manufacturerOptional.isPresent()) {
            manufacturerRepo.delete(manufacturerOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<Manufacturer> findById(String id) {
        return manufacturerRepo.findById(id);
    }
}
