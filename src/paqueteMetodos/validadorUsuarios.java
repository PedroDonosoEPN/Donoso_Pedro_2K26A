package paqueteMetodos;

public class validadorUsuarios {

    public final int ER = -1;
    public final int ESTADO_ALUMNO   = 7;
    public final int ESTADO_PROFESOR = 14;

    // 0=D, 1=o, 2=n, 3=s, 4=p, 5=e, 6=d, 7=r, 8=_, 9=a, 10=t, 11=i, 12=c, 13=\n
    final int[][] pdMt = {
    //   D      o      n      s      p      e      d      r      _      a      t      i      c     \n
      {  1,    ER,    ER,    ER,     8,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q0
      { ER,     2,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q1  D
      { ER,    ER,     3,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q2  Do
      { ER,     4,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q3  Don
      { ER,    ER,    ER,     5,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q4  Dono
      { ER,     6,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q5  Donos
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,     7 }, // q6  Donoso
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,     7 }, // q7  ACCEPT Donoso
      { ER,    ER,    ER,    ER,    ER,     9,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q8  p
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    10,    ER,    ER,    ER,    ER }, // q9  pe -> pa
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    11,    ER,    ER,    ER }, // q10 pat
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    12,    ER,    ER,    ER,    ER,    ER }, // q11 pat_
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER }, // q12 pat_m -> necesito m
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    14,    ER,    ER }, // q13 pat_mi
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    15,    ER }, // q14 pat_mic  
      { ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    ER,    15 }, // q15 ACCEPT pat_mic
    };

    private int pdGetIndex(char c) {
        switch (c) {
            case 'D':  return 0;
            case 'o':  return 1;
            case 'n':  return 2;
            case 's':  return 3;
            case 'p':  return 4;
            case 'e':  return 5;
            case 'd':  return 6;
            case 'r':  return 7;
            case '_':  return 8;
            case 'a':  return 9;
            case 't':  return 10;
            case 'i':  return 11;
            case 'c':  return 12;
            case '\n': return 13;
            default:   return ER;
        }
    }

    public int pdValidar(String input) {
        if (!input.endsWith("\n")) input += "\n";
        int q = 0;
        for (int i = 0; i < input.length(); i++) {
            int idx = pdGetIndex(input.charAt(i));
            if (idx == ER || pdMt[q][idx] == ER) return ER;
            q = pdMt[q][idx];
        }
        return q;
    }
}