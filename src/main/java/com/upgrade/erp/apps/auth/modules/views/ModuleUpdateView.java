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
            //FormComponent
            this.baseFormLayout.getFormComponent().addTextField("Number", "Update Enter module number");
            this.baseFormLayout.getFormComponent().addTextField("Name", "Update Enter module name");
            this.baseFormLayout.getFormComponent().addTextField("Description", "Update Enter module description");
            this.baseFormLayout.getFormComponent().addCheckbox("Update Is Active");
            //ButtonComponent
            baseFormLayout.getButtonComponent().addButton("Guardar", this::saveModule);
            add(baseFormLayout);
        }

        private void saveModule() {
            Long moduleNumber = Long.valueOf(baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Number"));
            String moduleName = baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Name");
            String moduleDescription = baseFormLayout.getFormComponent().getFormResponsesComponent().getTextFieldValue("Description");
            boolean isActive = baseFormLayout.getFormComponent().getFormResponsesComponent().getCheckboxValue("Is Active");
            CreateModuleDtoRequest dto = new CreateModuleDtoRequest(moduleNumber, moduleName, moduleDescription, isActive);
            moduleController.createModule(dto);
            Notification.show(moduleName + " guardado correctamente!", 2000, Notification.Position.TOP_CENTER);
        }
    }
