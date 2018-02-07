public class RomanToInt {
    public int romanToInt(String s) {
        char p = 'M';
        int result = 0;
        for (char c : s.toCharArray()) {
            if (!compare(p, c)) {
                result -= getIntOfRoman(p) * 2;
            }
            result += getIntOfRoman(c);
            p = c;
        }
        return result;
    }
    
    public static int getIntOfRoman(char c) {
        switch(c) {
            case('M'):
                return 1000;
            case('D'):
                return 500;
            case('C'):
                return 100;
            case('L'):
                return 50;
            case('X'):
                return 10;
            case('V'):
                return 5;
            case('I'):
                return 1;
        }
        return 1;
    }
                 
    public static boolean compare(char c1, char c2) {
        return getIntOfRoman(c1) >= getIntOfRoman(c2);
    }
}
