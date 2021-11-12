package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBase;

import java.util.List;

public class VFalojamientosPage extends SeleniumBase {
    public VFalojamientosPage(WebDriver driver) {
        super(driver);
    }
    // atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By desplegableHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");
    // Equipo 1 By:
    By categorias = By.cssSelector("div.header-products-container ul li a");
    By darClickNoHeDecidoFecha=By.cssSelector("label.checkbox-label");
    By campoDestino=By.cssSelector("div.sbox-place-container input");
    By esperaDestino=By.cssSelector("div.ac-container span");
    By botonBuscar = By.cssSelector("div.sbox-button");
    By busqueda = By.cssSelector("div.results-cluster-container");
    By clickEntrada=By.xpath("//input[@placeholder='Entrada']");
    By clickHabitaciones=By.cssSelector("div.sbox-distri-input-container");
    By ocupantesHabitacion = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By calendario = By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number");



    By darClickVuelo1Alojamiento = By.xpath("//input[@value='vh']");
    By campoOrigen = By.cssSelector("div.sbox-place-container input");
    By esperaCampoOrigen = By.cssSelector("div.ac-container span");
   // By campoDestino = By.cssSelector("div.sbox-second-place-container input");
   //By esperaCampoDestino = By.cssSelector("div.ac-container span");
    By darClickCampoFechaIda = By.cssSelector("[placeholder='Ida']");
    By darClickPasajeros = By.cssSelector("div.sbox-distri-input-container");
    By pasajeros = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By btnBuscar = By.cssSelector("div.sbox-button-container a");
    By contenedorResultados = By.cssSelector("div.results-cluster-container");

    public void irAlojamientosDesdeHome(){
        // generar la lista categorias
        List <WebElement> listaCategorias = generarLista(categorias);
        // seleccionar el elemento paquetes de la lista
        busquedaElemento(listaCategorias,"Alojamientos");
    }
    public void seleccionarNoHedecidoFecha(){darClick(darClickNoHeDecidoFecha);}

    public void llenarCasillaDestino(String destino, String seleccion){
        ingresarDestino(destino,seleccion,campoDestino,esperaDestino);

    }

    public void darClickBotonBuscar(){darClick(botonBuscar);}

    public int resultadosBusquedaAlojamientos(){
        return contarElementos(busqueda);
    }

    public void seleccionarFechas(int fecha1, int fecha2){
        darClick(clickEntrada);
        buscarEnCalendario(fecha1,fecha2,calendario);
    }

    public void seleccionarCantidadOcupantesHabitacion(int numero){
        darClick(clickHabitaciones);
        cantidadOcupantesHabitacion(numero,ocupantesHabitacion);
    }






    public void seleccionarVuelo1Alojamiento(){
        darClick(darClickVuelo1Alojamiento);
    }

    public void llenarCasillaOrigen(String origen, String seleccion){
        // llenar la casilla Origen
        ingresarDestino(origen,seleccion,campoOrigen,esperaCampoOrigen);
    }

    /*public void llenarCasillaDestino(String destino, String seleccion){
        //llenar la casilla Destino
        ingresarDestino(destino,seleccion,campoDestino,esperaCampoDestino);
    }*/



    public void darClickBuscar(){
        darClick(btnBuscar);
        esperaImplicita();
    }

    public int resultadosBusqueda(){
        return contarElementos(contenedorResultados);
    }

    public String validarLugarHotel(String lugar){
        return lugarHotel(lugar);
    }
    public void confirmarSeleccionHabitacionMenor(){
        darClick(btnAplicar);
    }
}
