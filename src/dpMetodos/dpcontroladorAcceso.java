package dpMetodos;

import java.util.Scanner;

public class dpcontroladorAcceso {

    private dpvalidadorUsuarios dpValUser;
    private dpvalidadorContrasena dpValPass;
    private Scanner dpScanner;
    private String dpRol;
    private String dpNombre;
    private String dpCedula;

    public dpcontroladorAcceso() {
        dpValUser = new dpvalidadorUsuarios();
        dpValPass = new dpvalidadorContrasena();
        dpScanner = new Scanner(System.in);
        dpRol     = null;
        dpNombre  = null;
        dpCedula  = null;
    }

    public boolean dpAutenticar() {
        int dpIntentos = 3;

        while (dpIntentos > 0) {
            System.out.print("\n[+] Usuario: ");
            String dpInputUser = dpScanner.nextLine().trim();

            System.out.print("[+] Contraseña: ");
            String dpInputPass = dpScanner.nextLine().trim();

            int dpEstadoUser = dpValUser.dpValidar(dpInputUser);
            int dpEstadoPass = dpValPass.dpValidar(dpInputPass);

            boolean dpPassOk = (dpEstadoPass == dpValPass.ESTADO_ACCEPT);

            if (dpEstadoUser == dpValUser.ESTADO_ALUMNO && dpPassOk) {
                dpRol    = "alumno";
                dpNombre = "Pedro Donoso";
                dpCedula = "0850195793";
                dpMostrarAcceso();
                return true;

            } else if (dpEstadoUser == dpValUser.ESTADO_PROFESOR && dpPassOk) {
                dpRol    = "profesor";
                dpNombre = "Patricio Paccha";
                dpCedula = "pat_mic";
                dpMostrarAcceso();
                return true;

            } else {
                dpIntentos--;
                System.out.println("[!] Donoso eres un intruso...");
                if (dpIntentos > 0) {
                    System.out.println("[!] Intentos restantes: " + dpIntentos);
                }
            }
        }

        System.out.println("\n[!] Accesos agotados. Cerrando sistema...");
        System.exit(0);
        return false;
    }

    private void dpMostrarAcceso() {
        System.out.println("\n[+] ACCESO:");
        System.out.println("    " + dpCedula + " - " + dpNombre);
    }

    public String dpGetRol()    { return dpRol; }
    public String dpGetNombre() { return dpNombre; }
    public String dpGetCedula() { return dpCedula; }
}