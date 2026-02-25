package com.miapp.contactos.dto;

public class VueloDTO {
    private String codigo;
    private String compania;
    private String avion;
    private String origen;
    private String destino;
    private String ubicacionPuerta;
    private String salida;
    private String llegada;

    public VueloDTO() {}

    public VueloDTO(String codigo, String compania, String avion, String origen, String destino, String ubicacionPuerta, String salida, String llegada) {
        this.codigo = codigo;
        this.compania = compania;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.ubicacionPuerta = ubicacionPuerta;
        this.salida = salida;
        this.llegada = llegada;
    }


    public String getCodigo() { return codigo; } public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getCompania() { return compania; } public void setCompania(String compania) { this.compania = compania; }
    public String getAvion() { return avion; } public void setAvion(String avion) { this.avion = avion; }
    public String getOrigen() { return origen; } public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; } public void setDestino(String destino) { this.destino = destino; }
    public String getUbicacionPuerta() { return ubicacionPuerta; } public void setUbicacionPuerta(String ubicacionPuerta) { this.ubicacionPuerta = ubicacionPuerta; }
    public String getSalida() { return salida; } public void setSalida(String salida) { this.salida = salida; }
    public String getLlegada() { return llegada; } public void setLlegada(String llegada) { this.llegada = llegada; }
}