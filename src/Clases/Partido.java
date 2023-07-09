/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author alons
 */
public class Partido implements Serializable {
    Equipo local;
    Equipo visita;
    Date fecha;

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisita() {
        return visita;
    }

    public void setVisita(Equipo visita) {
        this.visita = visita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Partido(Equipo local, Equipo visita) {
        this.local = local;
        this.visita = visita;
        this.fecha = null;
    }
    
    public Partido() {
        this.local = null;
        this.visita = null;
        this.fecha = null;
    }
    
    @Override
    public String toString() {
        if("Descanso".equals(local.getNombre())){
            return ("Equipo "+visita+" descansa");
        }else if("Descanso".equals(visita.getNombre())){
            return ("Equipo "+local+" descansa");
        }else{
            return local + " vs " + visita;
        }
    }

}
