package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagos")
public class Pago {

    @Id
    private String id;
    private String inscripcionId;  // ID de la inscripción asociada
    private String metodoPago;     // Tarjeta, Transferencia, etc.
    private double monto;          // Monto del pago
    private String fechaPago;

    public Pago() {}

    public Pago(String inscripcionId, String metodoPago, double monto, String fechaPago) {
        this.inscripcionId = inscripcionId;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getInscripcionId() { return inscripcionId; }
    public void setInscripcionId(String inscripcionId) { this.inscripcionId = inscripcionId; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getFechaPago() { return fechaPago; }
    public void setFechaPago(String fechaPago) { this.fechaPago = fechaPago; }
}
