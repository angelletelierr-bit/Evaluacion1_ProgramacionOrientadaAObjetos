public class Main {

    public static void main(String[] args) {
        try {
            GestorTallerBicicletas gestor = new GestorTallerBicicletas();

            // Instanciación según los datos solicitados en la pauta
            BicicletaElectrica e01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60.0, false);
            BicicletaElectrica e02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45.0, true);
            BicicletaMontanya m01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
            BicicletaMontanya m02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

            // Garantía extendida solicitada para BIC-E01
            e01.activarGarantiaExtendida();

            // Registro en la colección
            gestor.registrarBicicleta(e01);
            gestor.registrarBicicleta(e02);
            gestor.registrarBicicleta(m01);
            gestor.registrarBicicleta(m02);

            System.out.println();

            // Búsqueda por código solicitada
            System.out.println("=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");
            Bicicleta buscada = gestor.buscarPorCodigo("BIC-E01");

            if (buscada instanceof BicicletaElectrica) {
                BicicletaElectrica elect = (BicicletaElectrica) buscada;
                String garantia = elect.tieneGarantiaExtendida() ? "Si" : "No";
                String certBateria = elect.isBateriaCertificada() ? "Si" : "No";

                System.out.printf("Tipo: Bicicleta Eléctrica | Código: %s | Año: %d | Peso: %.1f kg | Autonomia: %.0f km | Batería certificada: %s%n",
                        elect.getCodigo(), elect.getAnioFabricacion(), elect.getPeso(), elect.getAutonomiaKm(), certBateria);
                System.out.printf(" Garantia extendida: %s | Costo mantención: $%.0f%n",
                        garantia, elect.calcularCostoMantencion());
            }

            System.out.println("---");

            // Listado de todas las bicicletas registradas mediante toString()
            System.out.println("\n=== LISTADO DE BICICLETAS ===");
            for (Bicicleta b : gestor.getBicicletas()) {
                System.out.println(b.toString());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}