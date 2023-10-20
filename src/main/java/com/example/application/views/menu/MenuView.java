package com.example.application.views.menu;

import com.example.application.data.dao.UserRepository;
import com.example.application.data.model.User;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.constraints.Negative;
import org.vaadin.addons.pjp.html5qrcode.Html5Qrcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@PageTitle("Menu")
@Route(value = "/menu", layout = MainLayout.class)
@PermitAll
public class MenuView extends VerticalLayout {


    UserRepository userRepository;


    public MenuView(UserRepository providedUserRepository ) {
        userRepository = providedUserRepository;

        Button btnScanCode = new Button("Skanuj Kod");
        btnScanCode.addClickListener(e ->
                btnScanCode.getUI().ifPresent(ui ->
                        ui.navigate("scan"))
        );

        btnScanCode.addClassName("button");
        H1 header1 = new H1("Last Dance Panel");
        header1.addClassName("header-title");
        Button btnDoNothing = new Button("Nic nie robie");
        btnDoNothing.addClassName("button");
        HorizontalLayout buttonContainer = new HorizontalLayout(btnScanCode, btnDoNothing);
        VerticalLayout parentContainer = new VerticalLayout(header1, buttonContainer);
        buttonContainer.addClassName("button-container");
        parentContainer.setAlignItems(Alignment.CENTER);
        parentContainer.setHeightFull();

        add(parentContainer);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    User getUserFromDatabase(String userId){
        return userRepository.findById(userId).get();
    }

}
