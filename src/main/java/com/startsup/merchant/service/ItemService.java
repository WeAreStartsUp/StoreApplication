package com.startsup.merchant.service;

import com.startsup.merchant.database.repository.ItemsRepository;
import com.startsup.merchant.entities.Items;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAllItems() {
        List<Items> items;
        try {
            items = itemsRepository.findAll();
        } catch (Exception e) {
            items = new ArrayList<>();
        }
        return items;
    }

    public Optional<Items> getItemById(int id) {
        Optional<Items> item = itemsRepository.findById(id);
        return item;
    }

    public List<Items> getAllItemsByMerchantId(int merchantId) {
        List<Items> items;
        try {
            items = itemsRepository.findItemsByMerchantId(merchantId);
        } catch (Exception e) {
            items = new ArrayList<>();
        }
        return items;
    }


    public Optional<Items> updateItem(Items item) {
        try {
            return Optional.of(itemsRepository.save(item));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
