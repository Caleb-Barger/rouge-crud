package local.barge.flowercrud.controllers;

import local.barge.flowercrud.models.Flower;
import local.barge.flowercrud.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping(value = "/flower", consumes = {"application/json"})
    public ResponseEntity<?> addNewFlower(
            @Valid
            @RequestBody
            Flower newFlower) {
        newFlower.setFlowerid(0);
        newFlower = flowerService.save(newFlower);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newFlowerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{flowerid}")
                .buildAndExpand(newFlower.getFlowerid())
                .toUri();
        responseHeaders.setLocation(newFlowerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
