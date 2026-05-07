package Problema2;
import java.util.Comparator;

public class ComparadorFrutaPorHectareas implements Comparator<Fruta> {

    @Override
    public int compare(Fruta f1, Fruta f2) {
        return Double.compare(f1.getHectareas(), f2.getHectareas());
    }
}
