public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        if (digits.length() == 1) {
            for (char c : getStrByInt(digits.charAt(0)).toCharArray()) {
                result.add(c + "");
            }
            return result;
        } else {
            int mid = digits.length() / 2;
            return merge(letterCombinations(digits.substring(0, mid)), letterCombinations(digits.substring(mid, digits.length())));
        }
    }

    public static List<String> merge(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                result.add(list1.get(i) + list2.get(j));
            }
        }
        return result;
    }

    public static String getStrByInt(char c) {
        switch(c) {
            case '0':
                return "!";
            case '1':
                return "@";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return "";
    }
}
