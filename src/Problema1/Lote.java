package Problema1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.*;

public class Lote implements Comparable<Lote> {

    private int numeroLote;
    private int numeroPiezas;
    private LocalDate fechaFabricacion;
    private Prenda prenda;

    public Lote(int numeroLote, int numeroPiezas, LocalDate fechaFabricacion, Prenda prenda) {
        this.numeroLote = numeroLote;
        this.numeroPiezas = numeroPiezas;
        this.fechaFabricacion = fechaFabricacion;
        this.prenda = prenda;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public double calcularCostoProduccion() {
        return numeroPiezas * prenda.getCostoProduccion();
    }

    public double calcularMontoRecuperacion() {
        double precioVenta = prenda.calcularPrecioVenta();
        double precioLote = precioVenta * 1.05;
        return numeroPiezas * precioLote;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "numeroLote=" + numeroLote +
                ", numeroPiezas=" + numeroPiezas +
                ", fechaFabricacion=" + fechaFabricacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lote)) return false;
        Lote lote = (Lote) o;
        return numeroLote == lote.numeroLote &&
                numeroPiezas == lote.numeroPiezas &&
                Objects.equals(fechaFabricacion, lote.fechaFabricacion) &&
                Objects.equals(prenda, lote.prenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLote, numeroPiezas, fechaFabricacion, prenda);
    }

    @Override
    public int compareTo(Lote otro) {
        return Integer.compare(this.numeroLote, otro.numeroLote);
    }

    public static void main(String[] args) {

        Prenda prenda = new Prenda(
                "Camisa deportiva",
                "Algodon",
                120,
                "Masculino",
                "Verano"
        );

        List<Lote> lista = new ArrayList<>();

        lista.add(new Lote(3, 200, LocalDate.of(2024, 5, 1), prenda));
        lista.add(new Lote(1, 500, LocalDate.of(2024, 1, 10), prenda));
        lista.add(new Lote(2, 300, LocalDate.of(2024, 3, 15), prenda));

        Collections.sort(lista);
        System.out.println("Orden por numero de lote:");
        System.out.println(lista);
        Collections.sort(lista, new ComparadorLotePorFecha());
        System.out.println("Orden por fecha:");
        System.out.println(lista);
    }
}


