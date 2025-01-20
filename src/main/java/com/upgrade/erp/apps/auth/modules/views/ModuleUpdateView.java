package com.upgrade.erp.apps.auth.modules.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.upgrade.erp.shared.layouts.forms.BaseFormLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Update Module") // Título de la página
@Route("update") // Ruta para acceder a la vista
@Menu(order = 2, icon = LineAwesomeIconUrl.ACCUSOFT) // Configuración para el menú
public class ModuleUpdateView extends BaseFormLayout {

    public ModuleUpdateView() {
        // Establecer propiedades básicas para la vista
        setClassName("module-update-view");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Aquí no se agrega contenido, lo que deja la vista en blanco
        setTitle("Titulo Module Update View");
        getButtonComponent().addButton("Guardar", null);
        getButtonComponent().addButton("Eliminar", null);
        getButtonComponent().addButton("Reponer", null);
        getButtonComponent().addButton("Saltar", null);
    }
}
