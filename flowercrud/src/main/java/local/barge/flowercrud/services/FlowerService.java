package local.barge.flowercrud.services;

import local.barge.flowercrud.models.Flower;

import java.util.List;

public interface FlowerService {

    Flower findFlowerById(long id);

    List<Flower> findAllFlowers();

    Flower findFlowerByType(String name);

    void delete(long id);

    Flower save(Flower flower);

    Flower update(Flower flower, long id);

}
