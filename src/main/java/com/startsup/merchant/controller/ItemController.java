package com.startsup.merchant.controller;

import com.startsup.merchant.entities.Items;
import com.startsup.merchant.service.ItemService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class ItemController {

    private final ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/items")
    public ResponseEntity<List<Items>> fetchAllItems() {
        logger.info("Request Received");
        List<Items> items = itemService.getAllItems();
        logger.info("Response={}", items);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Object> fetchItemById(@PathVariable int id) {
        logger.info("Request Received");
        Optional<Items> items = itemService.getItemById(id);
        logger.info("Response={}", items);
        return items.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/items/merchant/{merchant_id}")
    public ResponseEntity<List<Items>> fetchAllItemsByMerchantId(@PathVariable int merchant_id) {
        logger.info("Request Received");
        List<Items> items = itemService.getAllItemsByMerchantId(merchant_id);
        logger.info("Response={}", items);
        return items.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(items);
    }

    @PostMapping("/items")
    public ResponseEntity<Items> createOrUpdateItem(@RequestBody Items item) {
        return ResponseEntity.ok(itemService.updateItem(item).get());
    }

    @PostMapping("/items/loadFromFile")
    public ResponseEntity<Object> createOrUpdateItem(@RequestParam("file") MultipartFile file, @RequestParam("merchantId") Integer merchantId) {
        File tempFile = new File(file.getOriginalFilename());
        FileInputStream fileInputStream;
        try {
            tempFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(tempFile);
            file.getInputStream().transferTo(outputStream);
//            file.transferTo(tempFile);
            tempFile.deleteOnExit();
            String filename = tempFile.getName();
            logger.info("Request Received, fileName={}", tempFile.getName());
             fileInputStream = new FileInputStream(tempFile);
            Workbook workbook;
            if (filename.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
                List<Items> items = itemService.insertItems(sheet, merchantId);
                return ResponseEntity.ok(items);
            } else {
                return ResponseEntity.badRequest().body("Bad Request");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Internal Server Error");
        }
    }


}
