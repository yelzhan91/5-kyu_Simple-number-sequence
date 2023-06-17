public class CODEWARS {
    static final int MAX_DIGITS = 9;
    public static void main(String[] args) {
        String s = "123567";
        int res = 0;
        res = missing(s);
        System.out.println(res);//4
        s = "899091939495";
        res = 0;
        res = missing(s);
        System.out.println(res);//92
        s = "9899101102";
        res = 0;
        res = missing(s);
        System.out.println(res);//100
        s = "599600601602";
        res = 0;
        res = missing(s);
        System.out.println(res);//-1
        s = "8990919395";
        res = 0;
        res = missing(s);
        System.out.println(res);//-1
        s = "998999100010011003";
        res = 0;
        res = missing(s);
        System.out.println(res);//1002
        s = "99991000110002";
        res = 0;
        res = missing(s);
        System.out.println(res);//10000
        s = "979899100101102";
        res = 0;
        res = missing(s);
        System.out.println(res);//-1
        s = "900001900002900004900005900006";
        res = 0;
        res = missing(s);
        System.out.println(res);//900003
    }
    public static int getValue(String s, int i, int m) {
        if (i+m > s.length()) {
            return -1;
        }
        int value = 0;
        for (int j = 0; j < m; j++) {
            int c = s.charAt(i + j) - '0';
            if (c < 0 || c > 9) {
                return -1;
            }
            value = value * 10 + c;
        }
        return value;
    }
    public static int missing(String s) {
        for (int m = 1; m <= MAX_DIGITS; ++m) {
            int n = getValue(s, 0, m);
            if (n == -1) {
                break;
            }
            int missingNo = -1;
            boolean fail = false;
            for (int i = m; i != s.length(); i += 1 + Math.log10(n)) {
                if ((missingNo == -1) && (getValue(s, i, (int) (1 + Math.log10(n + 2))) == n + 2)) {
                    missingNo = n + 1;
                    n += 2;
                } else if (getValue(s, i, (int) (1 + Math.log10(n + 1))) == n + 1) {
                    n++;
                } else {
                    fail = true;
                    break;
                }
            }
            if (!fail) {
                return missingNo;
            }
        }
        return -1;
    }
}