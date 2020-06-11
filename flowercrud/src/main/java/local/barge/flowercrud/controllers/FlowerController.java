package local.barge.flowercrud.controllers;

import local.barge.flowercrud.models.Flower;
import local.barge.flowercrud.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @GetMapping(value = "/flowers", produces = {"application/json"})
    public ResponseEntity<?> listAllFlowers() {
        List<Flower> flowers = flowerService.findAllFlowers();
        return new ResponseEntity<>(flowers, HttpStatus.OK);
    }

    @GetMapping(value = "/flowers/{flowerid}", produces = {"application/json"})
    public ResponseEntity<?> getFlowerById(@PathVariable Long flowerid) {
        Flower flower = flowerService.findFlowerById(flowerid);
        return new ResponseEntity<>(flower, HttpStatus.OK);
    }
}
