package com.example.application.views.cafeteria;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("Cafeteria")
@Route(value = "/cafeteria", layout = MainLayout.class)
@PermitAll
public class CafeteriaView extends VerticalLayout {

}
