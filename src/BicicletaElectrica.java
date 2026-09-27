public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    private double autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;

    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, double autonomiaKm, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    public double getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(double autonomiaKm) {
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser mayor a 0 km.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaExtendidaActiva = true;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000;
        if (!bateriaCertificada) {
            costoBase += costoBase * 0.25;
        }
        return costoBase;
    }
}