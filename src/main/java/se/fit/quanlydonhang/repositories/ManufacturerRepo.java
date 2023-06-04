package se.fit.quanlydonhang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.fit.quanlydonhang.models.Manufacturer;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, String> {
}
