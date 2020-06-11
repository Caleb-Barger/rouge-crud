package local.barge.flowercrud.services;

import local.barge.flowercrud.models.Flower;
import local.barge.flowercrud.models.Supplier;
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
    public void delete(long id) {
        if (flowerRepository.findById(id).isPresent()) {
            flowerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Flower " + id + " Not Found");
        }
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
    
    @Transactional
    @Override
    public Flower update(Flower flower, long id) {
        Flower currentFlower = flowerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flower " + id + " Not Found"));
        
        if (flower.getType() != null) {
            currentFlower.setType(flower.getType());
        }
        
        if (flower.priceValueExists) {
            currentFlower.setPrice(flower.getPrice());
        }

        if (flower.getSupplier() != null) {
//             Supplier s = flower.getSupplier();
//             Supplier newSupplier = new Supplier(s.getName(), s.getAddress(), s.getPhonenumber(), s.getFlowers());
//             currentFlower.setSupplier(newSupplier);
            currentFlower.setSupplier(flower.getSupplier());
        }

        return flowerRepository.save(currentFlower);
    }
}
