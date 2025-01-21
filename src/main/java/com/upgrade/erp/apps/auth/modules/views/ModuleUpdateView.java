package com.upgrade.erp.apps.auth.modules.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.upgrade.erp.apps.auth.modules.controllers.ModuleController;
import com.upgrade.erp.apps.auth.modules.controllers.dto.CreateModuleDtoRequest;
import com.upgrade.erp.shared.layouts.forms.BaseFormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.UUID;

@PageTitle("Update Module")
@Route("update")
@Menu(order = 2, icon = LineAwesomeIconUrl.ACCUSOFT)
public class ModuleUpdateView extends VerticalLayout {

    private final ModuleController moduleController;
    private final BaseFormLayout baseFormLayout;

    public ModuleUpdateView(ModuleController moduleController, BaseFormLayout baseFormLayout) {
        this.moduleController = moduleController;
        this.baseFormLayout = baseFormLayout;
        this.baseFormLayout.cleanComponents();
        baseFormLayout.setTitle("Update Module");

        // Obtener el ID del módulo, puedes obtenerlo desde la URL, un parámetro o de otra forma.
        UUID moduleId = UUID.randomUUID(); // Aquí debes obtener el ID real.

        // Cargar los datos del módulo
        moduleController.getModuleById(moduleId).ifPresent(module -> {
            baseFormLayout.getFormComponent().addTextField("Number", "Update Enter module number", module.getNumber().toString());
            baseFormLayout.getFormComponent().addTextField("Name", "Update Enter module name", module.getName());
            baseFormLayout.getFormComponent().addTextField("Description", "Update Enter module description", module.getDescription());
            baseFormLayout.getFormComponent().addCheckbox("Update Is Active", module.isActive());
        });

        // ButtonComponent
        baseFormLayout.getButtonComponent().addButton("Guardar", () -> saveModule(moduleId));
        add(baseFormLayout);
    }

    private void saveModule(UUID moduleId) {
        Long moduleNumber = Long.valueOf(baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Number"));
        String moduleName = baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Name");
        String moduleDescription = baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Description");
        boolean isActive = baseFormLayout.getFormComponent().getFormResponsesComponent().getCheckboxValue("Is Active");

        CreateModuleDtoRequest dto = new CreateModuleDtoRequest(moduleNumber, moduleName, moduleDescription, isActive);
        moduleController.updateModule(moduleId, dto);  // Llamar al controlador para actualizar el módulo

        Notification.show(moduleName + " actualizado correctamente!", 3000, Notification.Position.TOP_CENTER);
    }
}
