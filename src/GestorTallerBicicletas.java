import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {

    private List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        this.bicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            bicicletas.add(bicicleta);
            System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName() + ") registrada correctamente.");
        }
    }

    public Bicicleta buscarPorCodigo(String codigo) {
        for (Bicicleta b : bicicletas) {
            if (b.getCodigo().equalsIgnoreCase(codigo)) {
                return b;
            }
        }
        return null;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }
}