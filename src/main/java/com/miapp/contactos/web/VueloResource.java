package com.miapp.contactos.web;

import com.miapp.contactos.dto.VueloDTO;
import com.miapp.contactos.model.VueloView;
import com.miapp.contactos.service.VueloService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/vuelos")
@Produces(MediaType.APPLICATION_JSON)
public class VueloResource {

    @Inject
    private VueloService servicio;

    @GET
    public List<VueloDTO> listar() {
        return servicio.listarVuelos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private VueloDTO toDTO(VueloView v) {
        return new VueloDTO(
                v.getCodigoVuelo(),
                v.getCompania(),
                v.getAvion(),
                v.getCiudadOrigen(),
                v.getCiudadDestino(),
                "T" + v.getTerminal() + " - Puerta " + v.getPuerta(),
                v.getHoraSalida().toString(),
                v.getHoraLlegada().toString()
        );
    }
}