package dpMetodos;

public class dpvalidadorUsuarios {

    public final int ER = -1;
    public final int ESTADO_ALUMNO   = 7;
    public final int ESTADO_PROFESOR = 14;

    // 0=D, 1=o, 2=n, 3=s, 4=p, 5=a, 6=t, 7=_, 8=m, 9=i, 10=c, 11=\n
    final int[][] dpMt = {
    //   D      o      n      s      p      a      t      _      m      i      c     \n
      {  1,    ER,    ER,    ER,     8,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q0
      { ER,     2,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q1  D
      { ER,    ER,     3,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q2  Do
      { ER,     4,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q3  Don
      { ER,    ER,    ER,     5,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q4  Dono
      { ER,     6,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q5  Donos
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,     7 }, // q6  Donoso
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,     7 }, // q7  ACCEPT Donoso
      { ER,    ER,    ER,    ER,    ER,     9,    ER,    ER,    ER,    ER,    ER,    ER }, // q8  p
      { ER,    ER,    ER,    ER,    ER,    ER,    10,    ER,    ER,    ER,    ER,    ER }, // q9  pa
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    11,    ER,    ER,    ER,    ER }, // q10 pat
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    12,    ER,    ER,    ER }, // q11 pat_
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    13,    ER,    ER }, // q12 pat_m
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    14,    ER }, // q13 pat_mi
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    14 }, // q14 ACCEPT pat_mic
    };

    private int dpGetIndex(char c) {
        switch (c) {
            case 'D':  return 0;
            case 'o':  return 1;
            case 'n':  return 2;
            case 's':  return 3;
            case 'p':  return 4;
            case 'a':  return 5;
            case 't':  return 6;
            case '_':  return 7;
            case 'm':  return 8;
            case 'i':  return 9;
            case 'c':  return 10;
            case '\n': return 11;
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