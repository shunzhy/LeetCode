public class IsMatch {

  /**
   第三个版本，依然准备用硬逻辑的方式来处理
   思路是：首先尽可能的使用掉不含*的字符，不断递减s与p的需要对应的字符数
   遍历s的每个字符，假设当前s的字符为a，遍历p，若p中当前对比字符为ab这样的，就使用掉s的a字符，无需进行下一次的对比，若p中是b*,则需要跳过b*进行下一步比较
   若p中为a*a，则不使用a*，首先使用掉第二个a，并且保存a的个数可以为无限个
   最后若p包含了s，则还需要判断s是否包含p，通过判断p多出的字符串是否满足a*b*这样的可省略掉的字符，如果全部省略之后，s==p，则满足，否则不满足
   这个思路，无法解决"aaca", "ab*a*c*a"，这样的匹配
   废弃
  */
  public static boolean isMatch(String s, String p) {
        if (".*".equals(p)) {
            return true;
        }
        // p的最后一个使用的字符
        char pb = 0;
        // 当前可以无限数量的字符
        char asterisk = 0;
        // 判断当前是否允许有无限数量的字符
        boolean flag = false;
        // 判断前一个p字符是否与当前s字符相等
        boolean preFlag = false;

        boolean goFlag = false;
        int idx = 0;
        s_loop:
        for (int i = 0; i < s.length(); i++) {
            int j;
            for (j = idx; j < p.length(); j++) {
                idx++;
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    pb = p.charAt(j);
                    // 为了判断当然字符不为*时，使用掉前一个字符，即前一个字符在p中已经有对应的值，并且确认不会再次使用
                    if (preFlag) {
                        preFlag = false;
                        idx--;
                        flag = false;
                        continue s_loop;
                    }
                    preFlag = true;
                    flag = pb == asterisk;
                    continue;
                } else {
                    if (p.charAt(j) == '*') {
                        goFlag = false;
                        // 保存前一个字符的对应权利，用于下一个字符的对应
                        if (pb == '.' || pb == s.charAt(i)) {
                            preFlag = false;
                            asterisk = pb;
                            flag = true;
                            continue;
                        }
                    } else {
                        if (preFlag) {
                            preFlag = false;
                            idx--;
                            continue s_loop;
                        }
                        if (idx == p.length()) {
                            idx--;
                        }
                        if (!goFlag) {
                            goFlag = true;
                        } else {
                            if (!flag || asterisk != '.' && asterisk != s.charAt(i)) {
                                return false;
                            }
                        }
                    }
                }
                pb = p.charAt(j);
            }
            if (!preFlag && (!flag || asterisk != '.' && asterisk != s.charAt(i))) {
                return false;
            }
            if (preFlag) {
                preFlag = false;
            }
        }

        goFlag = false;
        for (int j = idx; j < p.length(); j++) {
            if (goFlag) {
                if (p.charAt(j) == '*') {
                    goFlag = false;
                    idx += 2;
                } else {
                    break;
                }
            } else {
                goFlag = true;
            }
        }

        return idx == p.length();
    }
}
