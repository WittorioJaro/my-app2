package com.example.application.views.onsitetickets;

import com.example.application.data.model.User;
import com.example.application.services.UserService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;

@PageTitle("OnsiteTickets")
@Route(value = "/onsitetickets", layout = MainLayout.class)
@PermitAll
public class OnSiteTicketsView extends VerticalLayout {

    UserService userService;
    User currentUser;
    String userId;

    public OnSiteTicketsView(UserService providedUserService) {
        userService = providedUserService;

        H1 ticketTitle = new H1("Sprzedaż biletów");
        Button submitButton = new Button("Wyślij");
        submitButton.addClassNames("button-small");
        ticketTitle.addClassName("ticket-header");
        TextField userId = new TextField("ID");
        TextField firstName = new TextField("Imie");
        TextField lastName = new TextField("Nazwisko");
        TextField userClass = new TextField("Klasa");
        Select<String> paymentType = new Select<>();
        paymentType.setLabel("Sposób płatności");
        paymentType.setItems("Gotówka", "Blik");
        TextField staffSeller = new TextField("Sprzedający");
        FormLayout formLayout = new FormLayout();

        EmailField emailSearch = new EmailField("Email");
        EmailField emailField = new EmailField("Email");
        Button findUserButton = new Button("Szukaj");

        findUserButton.addClickListener(e -> {
            currentUser = userService.getUserByEmail(emailSearch.getValue());
            emailField.setValue(currentUser.getEmail());
            firstName.setValue(currentUser.getFirstName());
            lastName.setValue(currentUser.getLastName());
            userClass.setValue(currentUser.getUserClass());
            emailField.setReadOnly(true);
            firstName.setReadOnly(true);
            lastName.setReadOnly(true);
            userClass.setReadOnly(true);
        });
        submitButton.addClickListener(e -> {
            currentUser.setHasTicket(true);
            userService.updateUserTicket(currentUser.getId(), currentUser.getHasTicket());
        });

        formLayout.add(emailField, firstName, lastName, userClass, paymentType);

        add(ticketTitle);
        add(emailSearch);
        add(findUserButton);
        add(formLayout);
        add(submitButton);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
