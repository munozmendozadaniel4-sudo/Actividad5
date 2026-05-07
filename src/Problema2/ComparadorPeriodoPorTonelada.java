package Problema2;
import java.util.Comparator;
public class ComparadorPeriodoPorToneladas implements Comparator<PeriodoDeCosecha> {

    @Override
    public int compare(PeriodoDeCosecha p1, PeriodoDeCosecha p2) {
        return Double.compare(p1.getCantidadToneladas(), p2.getCantidadToneladas());
    }
}
