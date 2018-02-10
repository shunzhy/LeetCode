public class LengthOfLongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
        char[] cArray = s.toCharArray();
        List<Character> list1 = new ArrayList<>();
        int result = 0;
        for (char c : cArray) {
            if (!list1.contains(c)) {
                list1.add(c);
            } else {
                if (list1.size() > result) {
                    result = list1.size();
                }
                if (list1.indexOf(c) + 1 <= list1.size()) {
                    list1 = list1.subList(list1.indexOf(c) + 1, list1.size());
                }

                list1.add(c);
            }
        }
        if (list1.size() > result) {
            result = list1.size();
        }
        return result;
    }
}
