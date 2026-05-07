package Problema3;

import java.util.List;
import java.util.Objects;

public class PeriodoVisible implements Comparable<PeriodoVisible> {

    private String periodo;

    public PeriodoVisible(String periodo) throws MesInvalidoException {
        validarMeses(periodo);
        this.periodo = periodo;
    }

    private void validarMeses(String periodo) throws MesInvalidoException {
        List<String> mesesValidos = MesInvalidoException.getMesesValidos();
        String[] partes = periodo.split(" - ");
        for (String parte : partes) {
            String mes = parte.trim();
            if (!mesesValidos.contains(mes)) {
                throw new MesInvalidoException(mes);
            }
        }
    }

    public String getPeriodo() { return periodo; }

    @Override
    public String toString() {
        return "PeriodoVisible{periodoObservado='" + periodo + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoVisible that = (PeriodoVisible) o;
        return Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(periodo);
    }

    @Override
    public int compareTo(PeriodoVisible otro) {
        return this.periodo.compareTo(otro.periodo);
    }
}
