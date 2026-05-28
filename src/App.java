import dpMetodos.dpcontroladorAcceso;
import dpMetodos.dpLectorCSV;
import dpMetodos.dpBomba;

public class App {

    public static void main(String[] args) {
        dpcontroladorAcceso dpCtrl = new dpcontroladorAcceso();

        if (dpCtrl.dpAutenticar()) {
            dpLectorCSV dpLector = new dpLectorCSV("src/dpMetodos/DonosoPedro.csv");
            dpLector.dpLeerArchivo();

            dpBomba dpBomba = new dpBomba();
          dpBomba.dpEjecutar(dpLector.dpGetCoordenadas(), dpLector.dpGetTotalFilas());
        }
    }
}