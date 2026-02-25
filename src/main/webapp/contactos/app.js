const API_URL = '/api/vuelos';

document.addEventListener('DOMContentLoaded', () => {
    const tablaBody = document.getElementById('tabla-vuelos');

    cargarVuelos();

    async function cargarVuelos() {
        try {
            const respuesta = await fetch(API_URL);
            if (!respuesta.ok) throw new Error('Error al conectar con la API');
            const vuelos = await respuesta.json();

            // Revisa la consola (F12) para ver los nombres reales de los campos
            console.log("Datos recibidos:", vuelos);

            pintarTabla(vuelos);
        } catch (error) {
            console.error(error);
        }
    }

    function pintarTabla(vuelos) {
        tablaBody.innerHTML = '';
        if (!vuelos || vuelos.length === 0) {
            tablaBody.innerHTML = '<tr><td colspan="8" class="no-results">No hay vuelos disponibles</td></tr>';
            return;
        }

        vuelos.forEach(vuelo => {
            const tr = document.createElement('tr');


            const codigo = vuelo.codigoVuelo || vuelo.codigo || "---";
            const compania = vuelo.compania || "---";
            const avion = vuelo.avion || "---";
            const origen = vuelo.ciudadOrigen || vuelo.origen || "---";
            const destino = vuelo.ciudadDestino || vuelo.destino || "---";
            const puerta = vuelo.puerta || vuelo.ubicacionPuerta || "---";

            let salida = "---";
            let llegada = "---";

            if (vuelo.horaSalida) salida = vuelo.horaSalida.replace('T', ' ').substring(0, 16);
            else if (vuelo.salida) salida = vuelo.salida.replace('T', ' ').substring(0, 16);

            if (vuelo.horaLlegada) llegada = vuelo.horaLlegada.replace('T', ' ').substring(0, 16);
            else if (vuelo.llegada) llegada = vuelo.llegada.replace('T', ' ').substring(0, 16);

            tr.innerHTML = `
                <td data-label="Vuelo"><strong>${codigo}</strong></td>
                <td data-label="Compañía">${compania}</td>
                <td data-label="Avión">${avion}</td>
                <td data-label="Origen">${origen}</td>
                <td data-label="Destino">${destino}</td>
                <td data-label="Embarque">${puerta}</td>
                <td data-label="Salida">${salida}</td>
                <td data-label="Llegada">${llegada}</td>
            `;
            tablaBody.appendChild(tr);
        });
    }
});