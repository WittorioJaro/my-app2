package com.example.application.views.scan;

import com.example.application.data.model.User;
import com.example.application.services.UserService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.PermitAll;
import org.vaadin.addons.pjp.html5qrcode.Html5Qrcode;

import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@PageTitle("scan")
@Route(value = "/scan", layout = MainLayout.class)
@PermitAll
public class ScanView extends VerticalLayout {


    UserService userService;
    User currentUser;
    String userId;
    Paragraph hUserId;
    Paragraph puserTicket;

    public ScanView(UserService providedUserService) {
        userService = providedUserService;
        
        hUserId = new Paragraph(userId);
        puserTicket = new Paragraph("Bilet?");
        Button btnCheckQrCode = new Button("Sprawdź bilet");
        btnCheckQrCode.addClickListener(e -> {
            add(createScanner());
        });
        Paragraph nameAndSurname = new Paragraph("Imie i nazwisko:");
        nameAndSurname.addClassName("about-user");
        btnCheckQrCode.addClassName("button");
        hUserId.addClassName("name-surname");
        HorizontalLayout userDetails = new HorizontalLayout(nameAndSurname, hUserId);
        userDetails.addClassName("user-details");
        add(btnCheckQrCode);
        add(userDetails);
        add(puserTicket);
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }
    Html5Qrcode createScanner() {
        Map<String, Object> options = new HashMap<>();

        options.put(Html5Qrcode.Option.fps.name(), 10);
        options.put(Html5Qrcode.Option.qrbox.name(), 250);
        options.put(Html5Qrcode.Option.supportedScanTypes.name(), "[Html5QrcodeScanType.SCAN_TYPE_CAMERA]");

        Html5Qrcode component = new Html5Qrcode(scanner -> {
            userId = scanner.getValue();
            currentUser = userService.getUserFromDatabase(userId);
            hUserId.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
            if (currentUser.getHasTicket()) {
                puserTicket.setText("Bilet ważny");
                puserTicket.addClassName("ticket-info-ticket");
            } else {
                puserTicket.setText("Brak biletu");
                puserTicket.addClassName("ticket-info-noticket");
            }
        }, options);

        return component;

    }

}
