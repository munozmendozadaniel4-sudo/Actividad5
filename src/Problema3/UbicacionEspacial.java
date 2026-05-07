package Problema3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UbicacionEspacial implements Comparable<UbicacionEspacial> {

    private static final double MAX_GRADOS = 180.0;
    private static final List<String> HEMISFERIOS_LAT = Arrays.asList("Norte", "Sur");
    private static final List<String> HEMISFERIOS_LON = Arrays.asList("Este", "Oeste");

    private double latitud;
    private String hemisferioLatitud;
    private double longitud;
    private String hemisferioLongitud;

    public UbicacionEspacial(double latitud, String hemisferioLatitud,
                             double longitud, String hemisferioLongitud)
            throws LatitudInvalidaException, LongitudInvalidaException {

        validarLatitud(latitud);
        validarLongitud(longitud);

        this.latitud = latitud;
        this.hemisferioLatitud = hemisferioLatitud;
        this.longitud = longitud;
        this.hemisferioLongitud = hemisferioLongitud;
    }

    private void validarLatitud(double latitud) throws LatitudInvalidaException {
        if (latitud < 0 || latitud > MAX_GRADOS) {
            throw new LatitudInvalidaException(latitud);
        }
    }

    private void validarLongitud(double longitud) throws LongitudInvalidaException {
        if (longitud < 0 || longitud > MAX_GRADOS) {
            throw new LongitudInvalidaException(longitud);
        }
    }

    public double getLatitud() { return latitud; }
    public String getHemisferioLatitud() { return hemisferioLatitud; }
    public double getLongitud() { return longitud; }
    public String getHemisferioLongitud() { return hemisferioLongitud; }

    @Override
    public String toString() {
        return "UbicacionEspacial{" +
                "latitud=" + latitud + " " + hemisferioLatitud +
                ", longitud=" + longitud + " " + hemisferioLongitud +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UbicacionEspacial that = (UbicacionEspacial) o;
        return Double.compare(latitud, that.latitud) == 0 &&
                Double.compare(longitud, that.longitud) == 0 &&
                Objects.equals(hemisferioLatitud, that.hemisferioLatitud) &&
                Objects.equals(hemisferioLongitud, that.hemisferioLongitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, hemisferioLatitud, longitud, hemisferioLongitud);
    }

    @Override
    public int compareTo(UbicacionEspacial otra) {
        return Double.compare(this.latitud, otra.latitud);
    }
}
