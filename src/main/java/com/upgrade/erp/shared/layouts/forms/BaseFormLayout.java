package com.upgrade.erp.shared.layouts.forms;

import com.upgrade.erp.shared.components.buttons.ButtonComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.vaadin.flow.component.html.H1;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseFormLayout extends VerticalLayout {

    private final H1 title;
    private final ButtonComponent buttonComponent;

    public BaseFormLayout() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START);
        setClassName("base-form-layout");

        title = new H1();
        title.setClassName("form-title");

        buttonComponent = new ButtonComponent();
        add(this.title, buttonComponent);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getTitle() {
        return this.title.getText();
    }

}
