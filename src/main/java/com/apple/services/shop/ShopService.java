package com.apple.services.shop;

import com.apple.models.shop.Shop;
import com.apple.repositories.shop.ShopRepository;
import com.apple.services.cms.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    private UserService userService;

    public void createShop(Shop shop){
        shop.setUuid(UUID.randomUUID().toString());
        //shop.setCreatedBy();
        shopRepository.save(shop);
    }
}
