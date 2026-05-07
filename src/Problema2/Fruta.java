package Problema2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Fruta implements Comparable<Fruta> {

    private static final double MIN_HECTAREAS = 0.5;
    private static final double MAX_HECTAREAS_ABSOLUTO = 10.0;
    private static final double MIN_PRECIO_FACTOR = 1.05;
    private static final double MAX_PRECIO_FACTOR = 1.30;

    private String nombreFruta;
    private double hectareas;
    private double costoProduccionTon;
    private double precioVentaTon;
    private List<PeriodoDeCosecha> periodos;
    private double limiteHectareas;

    public Fruta(String nombreFruta, double hectareas, double costoProduccionTon,
                 double precioVentaTon, double limiteHectareas)
            throws ExtensionTerrenoInvalidaException, PrecioVentaInvalidoException {


        double limiteReal = Math.min(limiteHectareas, MAX_HECTAREAS_ABSOLUTO);

        validarHectareas(hectareas, limiteReal);
        validarPrecioVenta(precioVentaTon, costoProduccionTon);

        this.nombreFruta = nombreFruta;
        this.hectareas = hectareas;
        this.costoProduccionTon = costoProduccionTon;
        this.precioVentaTon = precioVentaTon;
        this.limiteHectareas = limiteReal;
        this.periodos = new ArrayList<>();
    }

    private void validarHectareas(double hectareas, double limite) throws ExtensionTerrenoInvalidaException {
        if (hectareas < MIN_HECTAREAS || hectareas > limite) {
            throw new ExtensionTerrenoInvalidaException(hectareas, limite);
        }
    }

    private void validarPrecioVenta(double precio, double costo) throws PrecioVentaInvalidoException {
        double min = costo * MIN_PRECIO_FACTOR;
        double max = costo * MAX_PRECIO_FACTOR;
        if (precio < min || precio > max) {
            throw new PrecioVentaInvalidoException(precio, costo);
        }
    }

    public void agregarPeriodo(PeriodoDeCosecha periodo) throws TiempoCosechaInvalidoException {
        if (periodos.size() >= 6) {
            throw new TiempoCosechaInvalidoException(periodos.size() + 1);
        }
        periodos.add(periodo);
    }

    public void eliminarPeriodo(PeriodoDeCosecha periodo) {
        periodos.remove(periodo);
    }

    public String getNombreFruta() { return nombreFruta; }
    public double getHectareas() { return hectareas; }
    public double getCostoProduccionTon() { return costoProduccionTon; }
    public double getPrecioVentaTon() { return precioVentaTon; }
    public List<PeriodoDeCosecha> getPeriodos() { return periodos; }

    @Override
    public String toString() {
        return "Fruta{nombre='" + nombreFruta + '\'' +
                ", hectareas=" + hectareas +
                ", costoProduccionTon=" + costoProduccionTon +
                ", precioVentaTon=" + precioVentaTon + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fruta fruta = (Fruta) o;
        return Double.compare(hectareas, fruta.hectareas) == 0 &&
                Double.compare(costoProduccionTon, fruta.costoProduccionTon) == 0 &&
                Double.compare(precioVentaTon, fruta.precioVentaTon) == 0 &&
                Objects.equals(nombreFruta, fruta.nombreFruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFruta, hectareas, costoProduccionTon, precioVentaTon);
    }

    @Override
    public int compareTo(Fruta otra) {
        return this.nombreFruta.compareTo(otra.nombreFruta);
    }
}
