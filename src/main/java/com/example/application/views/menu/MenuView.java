package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.PermitAll;

import java.awt.*;

@PageTitle("Menu")
@Route(value = "/menu", layout = MainLayout.class)
@PermitAll
public class MenuView extends VerticalLayout {
    class CheckIdListener
            implements ComponentEventListener<ClickEvent<Button>> {
        int count = 0;

        @Override
        public void onComponentEvent(ClickEvent<Button> event) {
            event.getSource()
                    .setText("You have clicked me " + (++count) + " times");
        }
    }
    public MenuView() {
        Button checkId = new Button("Sprawdz Id");
        H1 header1 = new H1("This is MENU test");
        add(header1);
        add(new Paragraph("It’s a place where you can grow your own UI"));
        add(checkId);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
