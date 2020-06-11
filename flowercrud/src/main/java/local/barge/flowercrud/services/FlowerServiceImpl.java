package local.barge.flowercrud.services;

import local.barge.flowercrud.models.Flower;
import local.barge.flowercrud.repositories.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "flowerService")
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public Flower findFlowerById(long id) throws EntityNotFoundException {
        return flowerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flower " + id + " Not Found :("));
    }

    @Override
    public List<Flower> findAllFlowers() {
        List<Flower> list = new ArrayList<>();

        flowerRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);

        return list;
    }

    @Override
    public Flower findFlowerByType(String name) throws EntityNotFoundException{
        Flower flower = flowerRepository.findByType(name);
        if (flower == null) {
            throw new EntityNotFoundException("Flower " + name + " Not Found.");
        }

        return flower;
    }

    @Transactional
    @Override
    public Flower save(Flower flower) {
        Flower newFlower = new Flower();

        if (flower.getFlowerid() != 0) {
            flowerRepository.findById(flower.getFlowerid())
                    .orElseThrow(() -> new EntityNotFoundException("Flower " + flower.getFlowerid() + " Not Found"));

            newFlower.setFlowerid(flower.getFlowerid());
        }

        newFlower.setType(flower.getType());
        newFlower.setPrice(flower.getPrice());
        newFlower.setSupplier(flower.getSupplier());

        return flowerRepository.save(newFlower);
    }
}
