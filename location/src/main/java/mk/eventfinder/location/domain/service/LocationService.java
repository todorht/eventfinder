package mk.eventfinder.location.domain.service;

import Repository.IService;
import mk.eventfinder.location.domain.model.Location;
import mk.eventfinder.location.domain.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements IService<Location, Long> {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository mongoTemplate) {
        this.locationRepository = mongoTemplate;
    }

    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location save(Location entity) {
        return this.locationRepository.save(entity);
    }

    @Override
    public Optional<Location> findById(Long aLong) {
        return this.locationRepository.findById(aLong);
    }

    @Override
    public void delete(Location entity) {
        this.locationRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        this.locationRepository.deleteById(aLong);
    }
}
