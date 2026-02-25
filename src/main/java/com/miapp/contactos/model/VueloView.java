package com.miapp.contactos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vista_vuelos")
public class VueloView {

    @Id
    @Column(name = "id_vuelo")
    private Integer idVuelo;

    @Column(name = "codigo_vuelo")
    private String codigoVuelo;

    private String compania;
    private String avion;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @Column(name = "ciudad_destino")
    private String ciudadDestino;

    private Integer terminal;
    private String puerta;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(name = "hora_llegada")
    private LocalDateTime horaLlegada;

    public Integer getIdVuelo() { return idVuelo; }
    public String getCodigoVuelo() { return codigoVuelo; }
    public String getCompania() { return compania; }
    public String getAvion() { return avion; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public Integer getTerminal() { return terminal; }
    public String getPuerta() { return puerta; }
    public LocalDateTime getHoraSalida() { return horaSalida; }
    public LocalDateTime getHoraLlegada() { return horaLlegada; }


    public void setIdVuelo(Integer idVuelo) { this.idVuelo = idVuelo; }
    public void setCodigoVuelo(String codigoVuelo) { this.codigoVuelo = codigoVuelo; }
    public void setCompania(String compania) { this.compania = compania; }
    public void setAvion(String avion) { this.avion = avion; }
    public void setCiudadOrigen(String ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }
    public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }
    public void setTerminal(Integer terminal) { this.terminal = terminal; }
    public void setPuerta(String puerta) { this.puerta = puerta; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }
    public void setHoraLlegada(LocalDateTime horaLlegada) { this.horaLlegada = horaLlegada; }
}