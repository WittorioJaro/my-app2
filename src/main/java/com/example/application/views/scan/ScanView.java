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
    H1 hUserId;

    public ScanView(UserService providedUserService) {
        userService = providedUserService;

        hUserId = new H1(userId);

        Button btnCheckQrCode = new Button("Sprawdź bilet");
        btnCheckQrCode.addClickListener(e -> {
            add(createScanner());
        });

        add(hUserId);
        add(btnCheckQrCode);

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

        }, options);

        return component;

    }

}
