package Problema1;

import java.util.*;
import java.time.LocalDate;
import java.util.Objects;

public class Prenda implements Comparable<Prenda> {

    private String modelo;
    private String tela;
    private double costoProduccion;
    private String genero;
    private String temporada;

    public Prenda(String modelo, String tela, double costoProduccion, String genero, String temporada) {
        this.modelo = modelo;
        this.tela = tela;
        this.costoProduccion = costoProduccion;
        this.genero = genero;
        this.temporada = temporada;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTela() {
        return tela;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getTemporada() {
        return temporada;
    }

    public double calcularPrecioVenta() {
        return costoProduccion * 1.15;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo + '\'' +
                ", tela='" + tela + '\'' +
                ", costoProduccion=$" + costoProduccion +
                ", genero='" + genero + '\'' +
                ", temporada='" + temporada + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prenda)) return false;
        Prenda prenda = (Prenda) o;
        return Double.compare(costoProduccion, prenda.costoProduccion) == 0 &&
                Objects.equals(modelo, prenda.modelo) &&
                Objects.equals(tela, prenda.tela) &&
                Objects.equals(genero, prenda.genero) &&
                Objects.equals(temporada, prenda.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, tela, costoProduccion, genero, temporada);
    }

    @Override
    public int compareTo(Prenda otra) {
        return Double.compare(this.costoProduccion, otra.costoProduccion);
    }

    public static void main(String[] args) {

        List<Prenda> lista = new ArrayList<>();

        lista.add(new Prenda("Camisa", "Algodon", 120, "Masculino", "Verano"));
        lista.add(new Prenda("Pantalon", "Mezclilla", 200, "Masculino", "Invierno"));
        lista.add(new Prenda("Blusa", "Seda", 150, "Femenino", "Primavera"));

        Collections.sort(lista);
        System.out.println("Orden por costo:");
        System.out.println(lista);

        Collections.sort(lista, new ComparadorPrendaPorModelo());
        System.out.println("Orden por modelo:");
        System.out.println(lista);
    }
    }
