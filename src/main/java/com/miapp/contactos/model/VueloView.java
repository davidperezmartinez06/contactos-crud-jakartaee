package com.miapp.contactos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "vista_vuelos")
public class VueloView implements Serializable {

    @Id
    @Column(name = "id_vuelo")
    private Integer idVuelo;

    @Column(name = "codigo_vuelo")
    private String codigoVuelo;

    @Column(name = "compania")
    private String compania;

    @Column(name = "avion")
    private String avion;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @Column(name = "ciudad_destino")
    private String ciudadDestino;

    @Column(name = "terminal")
    private Integer terminal;

    @Column(name = "puerta")
    private String puerta;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(name = "hora_llegada")
    private LocalDateTime horaLlegada;

    // Getters y Setters
    public Integer getIdVuelo() { return idVuelo; }
    public void setIdVuelo(Integer idVuelo) { this.idVuelo = idVuelo; }
    public String getCodigoVuelo() { return codigoVuelo; }
    public void setCodigoVuelo(String codigoVuelo) { this.codigoVuelo = codigoVuelo; }
    public String getCompania() { return compania; }
    public void setCompania(String compania) { this.compania = compania; }
    public String getAvion() { return avion; }
    public void setAvion(String avion) { this.avion = avion; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(String ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }
    public Integer getTerminal() { return terminal; }
    public void setTerminal(Integer terminal) { this.terminal = terminal; }
    public String getPuerta() { return puerta; }
    public void setPuerta(String puerta) { this.puerta = puerta; }
    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }
    public LocalDateTime getHoraLlegada() { return horaLlegada; }
    public void setHoraLlegada(LocalDateTime horaLlegada) { this.horaLlegada = horaLlegada; }
}