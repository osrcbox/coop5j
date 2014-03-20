/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coop5j.controller.periodo;

import coop5j.controller.socio.*;
import coop5j.controller.AbstractController;
import coop5j.controller.ContextBean;
import coop5j.model.core.Periodo;
import coop5j.model.core.Socio;
import coop5j.service.PeriodoService;
import coop5j.service.SocioService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;


/**
 * Controlador de usuarios
 * @author Danny Muñoz
 */

@ManagedBean
@ViewScoped
public class ListPeriodoController extends AbstractController{
    
    @EJB
    private PeriodoService service;       
    
    @Inject
    private ContextBean context;       
    
    /**
     * Listado de usuarios a mostrar en la vista
     */
    private List<Periodo> listaDatos = new ArrayList<Periodo>();        
    
    /**
     * Texto para filtrar los datos al presionar el botón buscar
     */
    private String textoBusqueda;

    public ListPeriodoController() {
    }
    
    @PostConstruct
    public void init(){        
    }           
    
    /**
     * Evento invocada al presionar el botón buscar
     * @param evento 
     */
    public void eventoBuscar(ActionEvent event){                   
        listaDatos = service.buscarPor(textoBusqueda);
    }        

    /**
     * @return the listaDatos
     */
    public List<Periodo> getListaDatos() {
        return listaDatos;
    }

    /**
     * @param listaDatos the listaDatos to set
     */
    public void setListaDatos(List<Periodo> listaDatos) {
        this.listaDatos = listaDatos;
    }    

    /**
     * @return the textoBusqueda
     */
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * @param textoBusqueda the textoBusqueda to set
     */
    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }
    
    

    
}
