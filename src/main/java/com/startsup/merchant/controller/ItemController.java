package com.startsup.merchant.controller;

import com.startsup.merchant.entities.Items;
import com.startsup.merchant.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
public class ItemController {

    private final ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/api/v1/items")
    public ResponseEntity<List<Items>> fetchAllItems() {
        logger.info("Request Received");
        List<Items> items = itemService.getAllItems();
        logger.info("Response={}", items);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/api/v1/items/{id}")
    public ResponseEntity<Object> fetchItemById(@PathVariable int id) {
        logger.info("Request Received");
        Optional<Items> items = itemService.getItemById(id);
        logger.info("Response={}", items);
        return items.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/api/v1/items/merchant/{merchant_id}")
    public ResponseEntity<List<Items>> fetchAllItemsByMerchantId(@PathVariable int merchant_id) {
        logger.info("Request Received");
        List<Items> items = itemService.getAllItemsByMerchantId(merchant_id);
        logger.info("Response={}", items);
        return items.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(items);
    }

    @PostMapping("/api/v1/items")
    public ResponseEntity<Items> createOrUpdateItem(@RequestBody Items item) {
        return ResponseEntity.ok(itemService.updateItem(item).get());
    }


}
