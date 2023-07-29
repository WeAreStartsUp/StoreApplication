package com.startsup.main.controllers;

import com.startsup.main.models.Address;
import com.startsup.main.models.Store;
import com.startsup.main.models.Zone;
import com.startsup.main.repositories.StoreRepository;
import com.startsup.main.repositories.ZoneRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class StoreController {

    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Value("${version}")
    private String version;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @GetMapping("/api/v1/healthcheck")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        JSONObject response = new JSONObject();
        response.put("status", "healthy");
        response.put("version", version);
        logger.info("healthcheck OK");
        return ResponseEntity.ok(response.toMap());
    }

    @PostMapping("/api/v1/zone")
    public ResponseEntity<Zone> addZone(@RequestHeader("correlation-id") String correlationId,
                                        @RequestBody Map<String, Object> request ) {
        Zone zone = new Zone(request.get("id").toString(), request.get("name").toString());
        zone = zoneRepository.save(zone);
        return ResponseEntity.ok(zone);
    }

    @GetMapping("/api/v1/zone")
    public ResponseEntity<List<Zone>> addZone(@RequestHeader("correlation-id") String correlationId) {
        List<Zone> zones = zoneRepository.findAll();
        return ResponseEntity.ok(zones);
    }

    @PostMapping("/api/v1/store")
    public ResponseEntity<Store> addData(@RequestHeader("correlation-id") String correlationId) {

//        Address address = Address.Builder.newInstance()
//                .setFirstLine("123 Test Colony")
//                .setSecondLine("Vivekananthar Street")
//                .setCity("Madurai")
//                .setState("Tamil Nadu")
//                .setCountry("India")
//                .setZone(new Zone("MDU", "Madurai"))
//                .setPinCode("623145")
//                .build();

        Address address1 = new Address("123, Test", "test colony", "Madurai", "TamilNadu", "India", "623512");
        Store store = new Store("Gopi's Super Market", address1, zoneRepository.findById("MDU").get());

        storeRepository.save(store);
        logger.info("correlation-id={}, Store Created, store={}", correlationId, store);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/api/v1/stores")
    public ResponseEntity<List<Store>> getStores(@RequestHeader("correlation-id") String correlationId) {
        logger.info("correlation-id={}, request received to fetch list of stores", correlationId);
        List<Store> stores = storeRepository.findAll();
        logger.info("correlation-id={}, List of Stores fetched, stores={}", correlationId, stores);
        return ResponseEntity.ok(stores);
    }
}
