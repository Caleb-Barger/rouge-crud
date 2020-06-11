package local.barge.flowercrud.repositories;

import local.barge.flowercrud.models.Flower;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends CrudRepository<Flower, Long> {
}
