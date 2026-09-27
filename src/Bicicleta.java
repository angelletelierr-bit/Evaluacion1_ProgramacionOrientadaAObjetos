public abstract class Bicicleta {

    private String codigo;
    private int anioFabricacion;
    private double peso;

    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        // Validacion para que el codigo no venga vacio
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        this.codigo = codigo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        // Validar rango de años
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año debe estar entre 2000 y 2026");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }
        this.peso = peso;
    }

    // Metodo abstracto para calcular la mantencion segun cada tipo
    public abstract double calcularCostoMantencion();

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}