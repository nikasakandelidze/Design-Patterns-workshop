package com.designpatterns.imageserivce.storage;

import com.designpatterns.imageserivce.storage.entities.ImageEntity;

import java.util.Map;

public class Bootstrapper {

    public static void bootstrapMapWithInitialValues(Map<String, ImageEntity> map){
        map.put("0", new ImageEntity("name1","date1"));
        map.put("1", new ImageEntity("name2","date2"));
        map.put("2", new ImageEntity("name3","date3"));
        map.put("3", new ImageEntity("name4","date4"));
        map.put("4", new ImageEntity("name5","date5"));
        map.put("5", new ImageEntity("name6","date6"));
        map.put("6", new ImageEntity("name7","date7"));
        map.put("7", new ImageEntity("name8","date8"));
    }
}
