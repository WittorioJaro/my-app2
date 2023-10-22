package com.example.application.views.onsitetickets;

import com.example.application.views.MainLayout;
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

    public OnSiteTicketsView() {
        TextField userId = new TextField("ID");
        TextField firstName = new TextField("Imie");
        TextField lastName = new TextField("Nazwisko");
        EmailField emailField = new EmailField("Email");
        TextField userClass = new TextField("Klasa");
        Select<String> paymentType = new Select<>();
        paymentType.setLabel("Sposób płatności");
        paymentType.setItems("Gotówka", "Blik");
        TextField staffSeller = new TextField("Sprzedający");
        FormLayout formLayout = new FormLayout();
        formLayout.add(userId, firstName, lastName, emailField, userClass, paymentType, staffSeller);
        add(formLayout);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
