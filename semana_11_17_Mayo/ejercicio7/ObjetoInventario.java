package semana_11_17_Mayo.ejercicio7;

import java.util.Objects;

public abstract class ObjetoInventario { //abstract para no instanciar objetos de esta clase

    private String fechaCompra;

    public ObjetoInventario(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetoInventario that = (ObjetoInventario) o;
        return Objects.equals(getFechaCompra(), that.getFechaCompra());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFechaCompra());
    }

    @Override
    public String toString() {
        return "ObjetoInventario{" +
                "fechaCompra='" + fechaCompra + '\'' +
                '}';
    }
}
