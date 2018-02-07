public class IsMatch {
      /**
       第一版，思路是将s遍历，如果前后字符==psCode相同，则字符数psCount+1，若字符不同，则与p进行比较
       同理遍历p，得到pbCode和PbCount
       这样psCode == pbCode，比较psCount与pbCount，如果存在*号，则要满足pbCount<=psCount，如果没有*号，则pbCount=psCount
       可能是我思路不够清晰，很多情况并无法正确解决，故废弃这个思路
      */
      public static boolean isMatch(String s, String p) {
        if (".*".equals(p)) {
            return true;
        }
        char pbCode = 0;
        int pbCount = 0;
        char psCode = 0;
        int psCount = 0;
        int idx = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (j < s.length() && (psCode == 0 || s.charAt(j) == psCode)) {
                psCode = s.charAt(j);
                psCount++;
                continue;
            }

            boolean variable = false;
            for (int i = idx; i <= p.length(); i++) {
                if (i < p.length()) {
                    char pc = p.charAt(i);
                    if (pbCode != 0 && pc != pbCode) {
                        if (pc == '*') {
                            pbCount--;
                            idx++;
                            variable = true;
                            continue;
                        }
                        if (pc == '.') {
                            pbCount++;
                            idx++;
                            continue;
                        }
                    } else {
                        pbCode = pc;
                        pbCount++;
                        idx++;
                        continue;
                    }
                }

                if (psCode == pbCode || pbCode == '.') {
                    if (variable) {
                        if (pbCount > psCount) {
                            return false;
                        }
                    } else {
                        if (pbCount > 0 && pbCount != psCount) {
                            if (pbCount < psCount) {
                                if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                                    //pbCode = p.charAt(i - 1);
                                    //pbCount = 0;
                                    i++;
                                    idx += 2;
                                    continue;
                                }
                            }
                            return false;
                        }
                    }
                } else {
                    if (pbCount > 0 || i == p.length()) {
                        return false;
                    } else {
                        pbCode = 0;
                        pbCount = 0;
                        i--;
                        continue;
                    }
                }
                pbCode = 0;
                pbCount = 0;
                break;
            }
            if (j < s.length()){
                psCode = s.charAt(j);
            }
            psCount = 1;
            if (idx > p.length()) {
                return false;
            }
        }
        return idx == p.length();
    }
}
