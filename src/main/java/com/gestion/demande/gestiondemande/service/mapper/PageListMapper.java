package com.gestion.demande.gestiondemande.service.mapper;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PageListMapper {

    public static  Map<String,Object> getPageToMapObject(Object o, Object o1, Object o2, Object o3) {
        Map<String, Object> response = new HashMap<>();
        response.put("results", o);
        response.put("currentPage", o1);
        response.put("totalItems", o2);
        response.put("totalPages", o3);
        return response;
    }

}
