package com.designpatterns.priceserivce.storage;


import com.designpatterns.priceserivce.storage.entities.PriceEntity;

import java.util.Map;

public class Bootstrapper {

    public static void bootstrapMapWithInitialValues(Map<String, PriceEntity> map){
        map.put("0", new PriceEntity("10000","details1"));
        map.put("1", new PriceEntity("123123","details2"));
        map.put("2", new PriceEntity("00111","details3"));
        map.put("3", new PriceEntity("9999999","details4"));
        map.put("4", new PriceEntity("-1111111","details5"));
    }
}
