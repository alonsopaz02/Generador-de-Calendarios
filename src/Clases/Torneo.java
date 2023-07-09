/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alons
 */
public class Torneo implements Serializable {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroJornadas() {
        return numeroJornadas;
    }

    public void setNumeroJornadas(int numeroJornadas) {
        this.numeroJornadas = numeroJornadas;
    }

    public int getNumeroEquipos() {
        return numeroEquipos;
    }

    public void setNumeroEquipos(int numeroEquipos) {
        this.numeroEquipos = numeroEquipos;
    }

    public int getNumeroPartidosXJornada() {
        return numeroPartidosXJornada;
    }

    public void setNumeroPartidosXJornada(int numeroPartidosXJornada) {
        this.numeroPartidosXJornada = numeroPartidosXJornada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Partido[][] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[][] partidos) {
        this.partidos = partidos;
    }

    public int[][] getTablaEncuentros() {
        return tablaEncuentros;
    }

    public void setTablaEncuentros(int[][] tablaEncuentros) {
        this.tablaEncuentros = tablaEncuentros;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String nombre;
    public int numeroJornadas;
    public int numeroEquipos;
    public int numeroPartidosXJornada;
    public Date fechaInicio;
    public Partido partidos[][];
    public int[][] tablaEncuentros;
    public ArrayList<Equipo> equipos;

    public Torneo(ArrayList<Equipo> equipos, Date fechaInicio, String nombre) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        if (equipos.size() % 2 != 0) {
            equipos.add(new Equipo("Descanso"));
        }
        this.equipos = equipos;
        this.numeroEquipos = equipos.size();
        this.numeroJornadas = (numeroEquipos - 1) * 2;
        this.numeroPartidosXJornada = numeroEquipos / 2;
        System.out.println(equipos.size());
        this.numeroJornadas = equipos.size() - 1;
        if ((equipos.size() & (equipos.size() - 1)) == 0 && equipos.size() != 0) {
            tablaEncuentros = new int[equipos.size() + 1][equipos.size()];
            formarTabla(tablaEncuentros, 1, equipos.size());
            String[][] tablamodificada = modificarTabla(tablaEncuentros);
            partidos = crearPartidosConDivisionYConquista(tablamodificada);
        } else {
            partidos = crearPartidosSinDivisionYConquista();
        }
    }

    private void formarTabla(int[][] t, int primero, int ultimo) {
        if (ultimo - primero == 1) {
            // Caso base: competirán entre ambos (el mismo día)
            t[primero][1] = ultimo;
            t[ultimo][1] = primero;
        } else {
            int medio = (primero + ultimo) / 2;

            // Primera subsolución: participantes de 1 a 2k-1
            formarTabla(t, primero, medio);

            // Segunda subsolución: participantes de 2k-1+1 a 2n
            formarTabla(t, medio + 1, ultimo);

            // Completa la tabla de los participantes de la primera subsolución con los de la segunda
            completarTabla(t, primero, medio, medio - primero + 1, ultimo - primero, medio + 1);

            // Completa la tabla de los participantes de la segunda subsolución con los de la primera
            completarTabla(t, medio + 1, ultimo, medio - primero + 1, ultimo - primero, primero);
        }
    }

    private void completarTabla(int[][] t, int eqInf, int eqSup, int diaInf, int diaSup, int eqInicial) {
        for (int j = diaInf; j <= diaSup; j++) {
            t[eqInf][j] = eqInicial + j - diaInf;
        }

        for (int i = eqInf + 1; i <= eqSup; i++) {
            t[i][diaInf] = t[i - 1][diaSup];

            for (int j = diaInf + 1; j <= diaSup; j++) {
                t[i][j] = t[i - 1][j - 1];
            }
        }
    }

    private String[][] modificarTabla(int matrizOriginal[][]) {
        int numRows = matrizOriginal.length - 1;  // Número de filas de la nueva matriz
        int numCols = matrizOriginal[0].length - 1;  // Número de columnas de la nueva matriz

        int[][] nuevaMatriz = new int[numRows][numCols];

        //Limpiamos la matriz
        for (int i = 1; i < matrizOriginal.length; i++) {
            for (int j = 1; j < matrizOriginal[i].length; j++) {
                nuevaMatriz[i - 1][j - 1] = matrizOriginal[i][j] - 1;
            }
        }

        String[][] matriz = new String[nuevaMatriz.length][nuevaMatriz[0].length];
        String[][] matrizI = new String[nuevaMatriz[0].length][nuevaMatriz.length];

        //Creamos una nueva matriz con los enfrentamientos
        for (int i = 0; i < nuevaMatriz.length; i++) {
            for (int j = 0; j < nuevaMatriz[i].length; j++) {
                matriz[i][j] = i + " vs " + nuevaMatriz[i][j];
            }
        }

        //Invertimos la matriz
        for (int i = 0; i < matrizI.length; i++) {
            System.out.println("Jornada " + i);
            for (int j = 0; j < matrizI[i].length; j++) {
                matrizI[i][j] = matriz[j][i];
            }
        }

        // Crear la matriz matrizPartidos con las mismas dimensiones que matrizI
        String[][] matrizPartidos = new String[matrizI.length][matrizI[0].length];

        for (int i = 0; i < matrizI.length; i++) {
            System.out.println("Jornada " + i);
            Set<String> partidosYaImpresos = new HashSet<>();

            for (int j = 0; j < matrizI[i].length; j++) {
                String partidoActual = matrizI[i][j];
                String[] equipos = partidoActual.split(" vs ");
                String partidoInverso = equipos[1] + " vs " + equipos[0];

                if (!partidosYaImpresos.contains(partidoInverso)) {
                    partidosYaImpresos.add(partidoActual);

                    // Guardar el partido en matrizPartidos
                    matrizPartidos[i][j] = partidoActual;
                }
            }
        }

        return matrizPartidos;
    }

    private Partido[][] crearPartidosConDivisionYConquista(String[][] matrizPartidos) {
        int totalEquipos = equipos.size();
        int totalJornadas = totalEquipos - 1;
        int partidosPorJornada = totalEquipos / 2;
        int indiceJor=0;
        int indicePxJ=0;
        Partido[][] jornadas = new Partido[totalJornadas][partidosPorJornada];
        for (int i = 0; i < matrizPartidos.length; i++) {
            for (int j = 0; j < matrizPartidos[i].length; j++) {
                if (matrizPartidos[i][j] != null) {
                    String[] encuentros = matrizPartidos[i][j].split(" vs ");
                    int indiceLocal = Integer.parseInt(encuentros[0]);
                    int indiceVisita = Integer.parseInt(encuentros[1]);
                    Equipo local = equipos.get(indiceLocal);
                    Equipo visita = equipos.get(indiceVisita);
                    if (i % 2 == 0) {
                        Partido partido = new Partido(local, visita);
                        jornadas[indiceJor][indicePxJ] = partido;
                        indicePxJ++;
                    } else {
                        Partido partido = new Partido(visita, local);
                        jornadas[indiceJor][indicePxJ] = partido;
                        indicePxJ++;
                    }
                }
            }
            indicePxJ=0;
            indiceJor++;
        }

        Partido[][] partidosTotales = new Partido[totalJornadas * 2][partidosPorJornada];
        for (int i = 0; i < jornadas.length; i++) {
            for (int j = 0; j < jornadas[i].length; j++) {
                partidosTotales[i][j] = new Partido();
                partidosTotales[i][j] = jornadas[i][j];
                partidosTotales[i][j].fecha = calcularFechaPartido(i, j, partidosPorJornada);

            }
        }

        for (int i = totalJornadas; i < totalJornadas * 2; i++) {
            for (int j = 0; j < partidosPorJornada; j++) {
                Partido partidoSigMitad = new Partido();
                partidoSigMitad.local = jornadas[i - totalJornadas][j].visita;
                partidoSigMitad.visita = jornadas[i - totalJornadas][j].local;
                partidoSigMitad.fecha = calcularFechaPartido(i, j, partidosPorJornada);
                partidosTotales[i][j] = partidoSigMitad;
            }
        }
        
        numeroJornadas = totalJornadas*2;
        numeroPartidosXJornada = partidosPorJornada;
        return partidosTotales;
    }

    //CASO SIN DIVISION Y CONQUISTA
    private Partido[][] crearPartidosSinDivisionYConquista() {
        int totalEquipos = equipos.size();
        int totalJornadas = totalEquipos - 1;
        int partidosPorJornada = totalEquipos / 2;

        Partido[][] jornadas = new Partido[totalJornadas][partidosPorJornada];

        ArrayList<Equipo> equiposCopia = new ArrayList<>(equipos);

        // Variables para controlar las condiciones de localía y visita
        int maxPartidosConsecutivos = 3;
        int partidosConsecutivosLocal = 0;
        int partidosConsecutivosVisita = 0;
        boolean local = true; // Indica si el próximo partido debe ser como local o visita

        for (int i = 0; i < totalJornadas; i++) {
            for (int j = 0; j < partidosPorJornada; j++) {
                Partido partido = new Partido();

                // Asignar equipos al partido
                partido.local = local ? equiposCopia.get(j) : equiposCopia.get(totalEquipos - 1 - j);
                partido.visita = local ? equiposCopia.get(totalEquipos - 1 - j) : equiposCopia.get(j);

                jornadas[i][j] = partido;

                // Actualizar las condiciones de localía y visita
                if (local) {
                    partidosConsecutivosLocal++;
                    partidosConsecutivosVisita = 0;
                } else {
                    partidosConsecutivosLocal = 0;
                    partidosConsecutivosVisita++;
                }

                // Alternar entre local y visita si se han alcanzado los partidos consecutivos máximos
                if (partidosConsecutivosLocal == maxPartidosConsecutivos) {
                    local = false;
                } else if (partidosConsecutivosVisita == maxPartidosConsecutivos) {
                    local = true;
                }
            }

            // Rotar los equipos en el arreglo para generar las parejas de partidos
            equiposCopia.add(1, equiposCopia.remove(equiposCopia.size() - 1));
        }

        //REPETIMOS DE MANERA INVERTIDA PARA LA OTRA MITAD DE LA TEMPORADA
        Partido[][] partidosTotales = new Partido[totalJornadas * 2][partidosPorJornada];
        for (int i = 0; i < jornadas.length; i++) {
            for (int j = 0; j < jornadas[i].length; j++) {
                partidosTotales[i][j] = new Partido();
                partidosTotales[i][j] = jornadas[i][j];
                partidosTotales[i][j].fecha = calcularFechaPartido(i, j, partidosPorJornada);

            }
        }

        for (int i = totalJornadas; i < totalJornadas * 2; i++) {
            for (int j = 0; j < partidosPorJornada; j++) {
                Partido partidoSigMitad = new Partido();
                partidoSigMitad.local = jornadas[i - totalJornadas][j].visita;
                partidoSigMitad.visita = jornadas[i - totalJornadas][j].local;
                partidoSigMitad.fecha = calcularFechaPartido(i, j, partidosPorJornada);
                partidosTotales[i][j] = partidoSigMitad;
            }
        }
        
        numeroJornadas = totalJornadas*2;
        numeroPartidosXJornada = partidosPorJornada;
        return partidosTotales;
    }

    private Date calcularFechaPartido(int jornada, int partido, int partidosPorDia) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);

        // Sumar el número de semanas necesarias para la jornada actual
        int semanas = jornada;
        calendar.add(Calendar.WEEK_OF_YEAR, semanas);

        // Calcular el día de la semana de la fecha de inicio
        int diaInicio = calendar.get(Calendar.DAY_OF_WEEK);

        // Calcular el número de días adicionales necesarios para el primer partido del día
        int diasAdicionales = (partido / partidosPorDia) * 7;

        // Obtener el día de la semana correspondiente al primer partido del día
        int diaPartido = (diaInicio + diasAdicionales) % 7;

        // Calcular el número de días adicionales necesarios para el partido específico
        int diasAdicionalesPartido = diaPartido + (partido % partidosPorDia);

        // Sumar los días adicionales al primer partido del día
        calendar.add(Calendar.DAY_OF_YEAR, diasAdicionalesPartido);

        return calendar.getTime();
    }
    
    

}
