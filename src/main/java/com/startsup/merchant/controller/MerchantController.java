package com.startsup.merchant.controller;

import com.startsup.merchant.entities.Merchants;
import com.startsup.merchant.service.MerchantService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(maxAge = 3600)
@RestController
public class MerchantController {

    private final MerchantService merchantService;

    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);
    @Value("${version}")
    private String version;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @GetMapping("/api/v1/healthcheck")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        JSONObject response = new JSONObject();
        response.put("status", "healthy");
        response.put("version", version);
        logger.info("healthcheck OK");
        return ResponseEntity.ok(response.toMap());
    }

    @GetMapping("/api/v1/merchants")
    public List<Merchants> fetchAllMerchants() {
        logger.info("Request Received");
        List<Merchants> merchants = merchantService.getAllMerchants();
        logger.info("Response={}", merchants);
        return merchants;
    }

    @PostMapping("/api/v1/merchants")
    public ResponseEntity<Merchants> createOrUpdateMerchant(@RequestBody Merchants merchant) {
        logger.info("Request received, {}", merchant);
        return ResponseEntity.ok(merchantService.updateMerchant(merchant).get());
    }


}
