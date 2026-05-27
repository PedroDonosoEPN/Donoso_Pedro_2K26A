import paqueteMetodos.ControladorAcceso;
import paqueteMetodos.LectorCSV;

public class App {

    public static void main(String[] args) {
        ControladorAcceso pdCtrl = new ControladorAcceso();

        if (pdCtrl.pdAutenticar()) {
            LectorCSV pdLector = new LectorCSV("src/paqueteMetodos/DonosoPedro.csv");            pdLector.pdLeerArchivo();
        }
    }
}
