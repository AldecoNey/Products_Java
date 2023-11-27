function cargarDatos() {
    var tiempoFabricacion = document.getElementById("tiempoFabricacion").value;
    var denominacion = document.getElementById("denominacion").value;
    var codigo = document.getElementById("codigo").value;
    var precioVenta = document.getElementById("precio").value;
    var margenGanancia = document.getElementById("margenGanancia").value;
    var rubro = document.getElementById("rubro").value;
    if (
        tiempoFabricacion.trim() === "" ||
        denominacion.trim() === "" ||
        codigo.trim() === "" ||
        precioVenta.trim() === "" ||
        margenGanancia.trim() === ""
    ) {
        alert("Todos los campos son obligatorios.");
        return;
    }

    if (isNaN(tiempoFabricacion) || isNaN(precioVenta) || isNaN(margenGanancia)) {
        alert("Los campos numéricos deben contener números válidos.");
        return;
    }

    if (/\s/.test(codigo)) {
        alert("El campo de código no debe contener espacios.");
        return;
    }

    console.log("Tiempo de fabricación: " + tiempoFabricacion);
    console.log("Denominación: " + denominación);
    console.log("Código: " + codigo);
    console.log("Precio de venta: " + precioVenta);
    console.log("Margen de ganancia: " + margenGanancia);
    console.log("Rubro: " + rubro);

}