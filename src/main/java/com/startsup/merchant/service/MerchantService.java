package com.startsup.merchant.service;

import com.startsup.merchant.database.repository.MerchantsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantService {

    private final MerchantsRepository merchantsRepository;

    public MerchantService(MerchantsRepository merchantsRepository) {
        this.merchantsRepository = merchantsRepository;
    }

    public List<Merchants> getAllMerchants() {
        List<Merchants> merchants;
        try {
            merchants = merchantsRepository.findAll();
        } catch (Exception e) {
            merchants = new ArrayList<>();
        }
        return merchants;
    }

    public Optional<Merchants> getMerchantFromId(int id) {
        Optional<Merchants> merchant;
        try {
            merchant = merchantsRepository.findById(id);
        } catch (Exception e) {
            merchant = Optional.empty();
        }
        return merchant;
    }

    public Optional<Merchants> updateMerchant(Merchants merchant) {
        try {
            merchant = merchantsRepository.save(merchant);
            return Optional.of(merchant);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
