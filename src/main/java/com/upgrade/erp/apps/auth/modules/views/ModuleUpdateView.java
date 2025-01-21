package com.upgrade.erp.apps.auth.modules.views;

import org.springframework.stereotype.Component;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.upgrade.erp.apps.auth.modules.controllers.ModuleController;
import com.upgrade.erp.apps.auth.modules.controllers.dto.CreateModuleDtoRequest;
import com.upgrade.erp.shared.layouts.forms.BaseFormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Component
@PageTitle("Update Module")
@Route("update")
@Menu(order = 2, icon = LineAwesomeIconUrl.ACCUSOFT)
public class ModuleUpdateView extends VerticalLayout {

    private final ModuleController moduleController;
    private final BaseFormLayout baseFormLayout;

    public ModuleUpdateView(ModuleController moduleController, BaseFormLayout baseFormLayout) {
        this.moduleController = moduleController;
        this.baseFormLayout = baseFormLayout;
        baseFormLayout.setTitle("Update Module");
        //Campos de FormComponent
        baseFormLayout.getFormComponent().addTextField("Number", "Enter module number");
        baseFormLayout.getFormComponent().addTextField("Name", "Enter module name");
        baseFormLayout.getFormComponent().addTextField("Description", "Enter module description");
        baseFormLayout.getFormComponent().addCheckbox("Is Active");
        //Botones de ButtonComponent
        baseFormLayout.getButtonComponent().addButton("Guardar", this::saveModule);
        add(baseFormLayout);
    }

    private void saveModule() {
        Long moduleNumber = Long.valueOf(baseFormLayout.getFormComponent().getTextFieldValue("Number"));
        String moduleName = baseFormLayout.getFormComponent().getTextFieldValue("Name");
        String moduleDescription = baseFormLayout.getFormComponent().getTextFieldValue("Description");
        boolean isActive = baseFormLayout.getFormComponent().getCheckboxValue("Is Active");
        CreateModuleDtoRequest dto = new CreateModuleDtoRequest(moduleNumber, moduleName, moduleDescription, isActive);
        moduleController.createModule(dto);
        Notification.show(moduleName + " guardado correctamente!", 2000, Notification.Position.TOP_CENTER);
    }
}
