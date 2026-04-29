package Problema1;
import java.util.Comparator;

public class ComparadorPrendaPorModelo implements Comparator<Prenda> {

    @Override
    public int compare(Prenda p1, Prenda p2) {
        return p1.getModelo().compareTo(p2.getModelo());
    }
}
