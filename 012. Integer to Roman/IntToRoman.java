public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = num / 1000;
        for (int i = 0; i < m; i++) {
            sb.append("M");
        }
        num -= m * 1000;
        
        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        } else if (num >= 500) {
            sb.append("D");
            num -= 500;
        } else if (num >= 400) {
            sb.append("CD");
            num -= 400;
        }
        int c = num / 100;
        for (int i = 0; i < c; i++) {
            sb.append("C");
        }
        num -= 100 * c;
        
        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        } else if (num >= 50) {
            sb.append("L");
            num -= 50;
        } else if (num >= 40) {
            sb.append("XL");
            num -= 40;
        }
        int x = num / 10;
        for (int i = 0; i < x; i++) {
            sb.append("X");
        }
        num -= 10 * x;
        
        if (num >= 9) {
            sb.append("IX");
            num -= 9;
        } else if (num >= 5) {
            sb.append("V");
            num -= 5;
        } else if (num == 4) {
            sb.append("IV");
            num -= 4;
        }
        for (int i = 0; i < num; i++) {
            sb.append("I");
        }
        
        return sb.toString();
    }
}
