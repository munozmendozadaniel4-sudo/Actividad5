package Problema2;

import java.util.Objects;

public class PeriodoDeCosecha implements Comparable<PeriodoDeCosecha> {

    private static final double MIN_TONELADAS = 0.5;
    private static final double MAX_TONELADAS = 200.0;

    private String nombrePeriodo;
    private double cantidadToneladas; // toneladas por hectarea
    private Fruta fruta;

    public PeriodoDeCosecha(String nombrePeriodo, double cantidadToneladas, Fruta fruta)
            throws CantidadCosechaInvalidaException {

        validarCantidad(cantidadToneladas);

        this.nombrePeriodo = nombrePeriodo;
        this.cantidadToneladas = cantidadToneladas;
        this.fruta = fruta;
    }

    private void validarCantidad(double cantidad) throws CantidadCosechaInvalidaException {
        if (cantidad < MIN_TONELADAS || cantidad > MAX_TONELADAS) {
            throw new CantidadCosechaInvalidaException(cantidad);
        }
    }
    
    public double produccionTotal() {
        return cantidadToneladas * fruta.getHectareas();
    }
    
    public double costoProduccion() {
        return produccionTotal() * fruta.getCostoProduccionTon();
    }
    
    public double gananciasEstimadas() {
        return produccionTotal() * fruta.getPrecioVentaTon() - costoProduccion();
    }

    public String getNombrePeriodo() { return nombrePeriodo; }
    public double getCantidadToneladas() { return cantidadToneladas; }
    public Fruta getFruta() { return fruta; }

    @Override
    public String toString() {
        return "PeriodoDeCosecha{" +
                "periodo='" + nombrePeriodo + '\'' +
                ", produccionEstimada=" + cantidadToneladas + " ton/ha" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoDeCosecha that = (PeriodoDeCosecha) o;
        return Double.compare(cantidadToneladas, that.cantidadToneladas) == 0 &&
                Objects.equals(nombrePeriodo, that.nombrePeriodo) &&
                Objects.equals(fruta, that.fruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePeriodo, cantidadToneladas, fruta);
    }

    @Override
    public int compareTo(PeriodoDeCosecha otro) {
        return this.nombrePeriodo.compareTo(otro.nombrePeriodo);
    }
}
