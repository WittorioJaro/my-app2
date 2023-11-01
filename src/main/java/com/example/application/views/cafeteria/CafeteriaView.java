package com.example.application.views.cafeteria;

import com.example.application.data.model.CafeteriaItem;
import com.example.application.services.CafeteriaItemService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Cafeteria")
@Route(value = "/cafeteria", layout = MainLayout.class)
@PermitAll
public class CafeteriaView extends VerticalLayout {
    CafeteriaItemService cafeteriaItemService;

    public CafeteriaView(CafeteriaItemService providedCafeteriaItemService) {
        this.cafeteriaItemService = providedCafeteriaItemService;

        List<CafeteriaItem> cafeteriaItems = providedCafeteriaItemService.getAllItems();

        H1 title = new H1("Cafeteria");

        Grid<CafeteriaItem> itemGrid = new Grid<>(CafeteriaItem.class);
        itemGrid.setItems(cafeteriaItems);
        itemGrid.setColumns("name", "price");
        add(title);
        add(itemGrid);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
