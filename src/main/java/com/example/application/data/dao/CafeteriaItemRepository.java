package com.example.application.data.dao;

import com.example.application.data.model.CafeteriaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeteriaItemRepository extends JpaRepository<CafeteriaItem, String> {


}