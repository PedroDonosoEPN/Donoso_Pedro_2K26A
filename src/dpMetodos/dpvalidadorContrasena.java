package dpMetodos;

public class dpvalidadorContrasena {

    public final int ER = -1;
    public final int ESTADO_ACCEPT = 4;

    // 0=1, 1=2, 2=3, 3=4, 4=\n
    final int[][] dpMt = {
    //   1      2      3      4     \n
      {  1,    ER,    ER,    ER,    ER }, // q0
      { ER,     2,    ER,    ER,    ER }, // q1  1
      { ER,    ER,     3,    ER,    ER }, // q2  12
      { ER,    ER,    ER,     4,    ER }, // q3  123
      { ER,    ER,    ER,    ER,     4 }, // q4  ACCEPT 1234
    };

    private int dpGetIndex(char c) {
        switch (c) {
            case '1':  return 0;
            case '2':  return 1;
            case '3':  return 2;
            case '4':  return 3;
            case '\n': return 4;
            default:   return ER;
        }
    }

    public int dpValidar(String input) {
        if (!input.endsWith("\n")) input += "\n";
        int q = 0;
        for (int i = 0; i < input.length(); i++) {
            int idx = dpGetIndex(input.charAt(i));
            if (idx == ER || dpMt[q][idx] == ER) return ER;
            q = dpMt[q][idx];
        }
        return q;
    }
}