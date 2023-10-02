package com.startsup.merchant.controller;

import com.startsup.merchant.entities.Merchants;
import com.startsup.merchant.entities.Zones;
import com.startsup.merchant.service.MerchantService;
import com.startsup.merchant.service.ZoneService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/zone")
public class ZoneController {

    private final ZoneService zoneService;

    private static final Logger logger = LoggerFactory.getLogger(ZoneController.class);
    @Value("${version}")
    private String version;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Zones>> fetchAllMerchants() {
        logger.info("Request Received");
        List<Zones> merchants = zoneService.getAllZones();
        logger.info("Response={}", merchants);
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(merchants);
    }

    @PostMapping("/")
    public ResponseEntity<Zones> createOrUpdateMerchant(@RequestBody Zones zone) {
        logger.info("Request received, {}", zone);
        return ResponseEntity.ok(zoneService.addOrUpdateZone(zone));
    }


}
