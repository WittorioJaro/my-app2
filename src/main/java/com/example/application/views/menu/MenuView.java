package com.example.application.views.menu;

import com.example.application.data.dao.UserRepository;
import com.example.application.data.model.User;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("Menu")
@Route(value = "/menu", layout = MainLayout.class)
@PermitAll
public class MenuView extends VerticalLayout {


    UserRepository userRepository;


    public MenuView(UserRepository providedUserRepository) {
        userRepository = providedUserRepository;

        Button checkId = new Button("Sprawdz Id");
        checkId.addClickListener(e -> {
            Notification.show(getUserFromDatabase("55929").getFirstName());
        });

        H1 header1 = new H1("This is MENU test");
        add(header1);
        add(new Paragraph("It’s a place where you can grow your own UI"));
        add(checkId);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    User getUserFromDatabase(String userId){
        return userRepository.findById(userId).get();
    }

}
