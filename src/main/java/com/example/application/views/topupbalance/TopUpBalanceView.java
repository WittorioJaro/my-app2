package com.example.application.views.topupbalance;

import com.example.application.data.model.User;
import com.example.application.services.UserService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.vaadin.addons.pjp.html5qrcode.Html5Qrcode;

import java.util.HashMap;
import java.util.Map;

@PageTitle("TopUp")
@Route(value = "/topupbalance", layout = MainLayout.class)
@PermitAll
public class TopUpBalanceView extends VerticalLayout {

    UserService userService;
    User currentUser;
    String userId;
    Paragraph userData = new Paragraph("Imie i nazwisko: ");
    int currentBalance;
    NumberField topUpValueField;

    public TopUpBalanceView(UserService providedUserService) {
        userService = providedUserService;

        H1 title = new H1("Wpłaty gotówką");
        Button btnCheckQrCode = new Button("Skanuj kod");
        btnCheckQrCode.addClickListener(e -> {
            add(createScanner());
        });

        topUpValueField = new NumberField("Kwota");
        Button submitBtn = new Button("Potwierdź");

        submitBtn.addClickListener(e -> {
            try {
                int newBalance = currentBalance + topUpValueField.getValue().intValue();
                currentUser.setBalance(newBalance);
                userService.updateUserBalance(currentUser.getId(), newBalance);

                // Success notification
                Notification.show("Kwota dodana", 3000, Notification.Position.TOP_CENTER);

                topUpValueField.clear();
                currentUser = null;
                userData.setText("Imie i nazwisko: ");
            } catch (Exception ex) {
                ex.printStackTrace();
                Notification.show("Nie udało się dodać kwoty. Spróbuj jeszcze raz", 5000, Notification.Position.TOP_CENTER)
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        add(title);
        add(btnCheckQrCode);
        add(userData);
        add(topUpValueField);
        add(submitBtn);
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
            userData.setText("Imie i nazwisko: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            currentBalance = currentUser.getBalance();
        }, options);

        return component;

    }



}
