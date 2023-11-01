package com.example.application.services;

import com.example.application.data.dao.CafeteriaItemRepository;
import com.example.application.data.model.CafeteriaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CafeteriaItemService {

    @Autowired
    CafeteriaItemRepository cafeteriaItemRepository;

    private List<CafeteriaItem> cafeteriaItems;

    public List<CafeteriaItem> getAllItems() {
        cafeteriaItems = cafeteriaItemRepository.findAll();
        return new ArrayList<>(cafeteriaItems);
    }

}