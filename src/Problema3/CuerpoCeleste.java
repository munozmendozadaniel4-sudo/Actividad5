package Problema3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuerpoCeleste implements Comparable<CuerpoCeleste> {

    private String nombre;
    private String composicion;
    private double distanciaTierra;
    private String unidadTierra; // "años luz" o "km/s"
    private UbicacionEspacial ubicacion;
    private List<PeriodoVisible> periodos;

    public CuerpoCeleste(String nombre, String composicion, double distanciaTierra,
                         String unidadTierra, UbicacionEspacial ubicacion) {
        this.nombre = nombre;
        this.composicion = composicion;
        this.distanciaTierra = distanciaTierra;
        this.unidadTierra = unidadTierra;
        this.ubicacion = ubicacion;
        this.periodos = new ArrayList<>();
    }

    public void agregarPeriodo(PeriodoVisible periodo) {
        periodos.add(periodo);
    }

    public double calcularDesplazamiento(UbicacionEspacial otraUbicacion) {
        double dLat = this.ubicacion.getLatitud() - otraUbicacion.getLatitud();
        double dLon = this.ubicacion.getLongitud() - otraUbicacion.getLongitud();
        return Math.sqrt(dLat * dLat + dLon * dLon);
    }

    public String getNombre() { return nombre; }
    public String getComposicion() { return composicion; }
    public double getDistanciaTierra() { return distanciaTierra; }
    public String getUnidadTierra() { return unidadTierra; }
    public UbicacionEspacial getUbicacion() { return ubicacion; }
    public List<PeriodoVisible> getPeriodos() { return periodos; }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", composicion='" + composicion + '\'' +
                ", distancia=" + distanciaTierra + " " + unidadTierra +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Double.compare(distanciaTierra, that.distanciaTierra) == 0 &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(composicion, that.composicion) &&
                Objects.equals(unidadTierra, that.unidadTierra) &&
                Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, composicion, distanciaTierra, unidadTierra, ubicacion);
    }

    @Override
    public int compareTo(CuerpoCeleste otro) {
        return Double.compare(this.distanciaTierra, otro.distanciaTierra);
    }
}

