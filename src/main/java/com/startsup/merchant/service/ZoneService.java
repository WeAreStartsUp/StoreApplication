package com.startsup.merchant.service;

import com.startsup.merchant.database.repository.OrderItemsRepository;
import com.startsup.merchant.database.repository.OrdersRepository;
import com.startsup.merchant.database.repository.ZonesRepository;
import com.startsup.merchant.entities.Order;
import com.startsup.merchant.entities.OrderItems;
import com.startsup.merchant.entities.Zones;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ZoneService {

    private ZonesRepository zonesRepository;

    @Autowired
    public void setZonesRepository(ZonesRepository zonesRepository) {
        this.zonesRepository = zonesRepository;
    }

    public List<Zones> getAllZones() {
        return zonesRepository.findAll();
    }

    public Zones addOrUpdateZone(Zones zone) {
        return zonesRepository.save(zone);
    }

    public void deleteZone(Zones zone) {
        zonesRepository.delete(zone);
    }
}
