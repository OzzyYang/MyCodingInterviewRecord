package strings.solution5;

/**
 * @author Ozzy Yang
 * Finished time:2021-04-13
 */
public class Solution5 {
    public String replaceSpace(String s) {
        return this.solution2(s);
    }

    /**
     * 第一种方案，创建一个新的字符串
     *
     * @param s 原来的字符串
     * @return 替换后的字符串
     */
    public String solution1(String s) {
        if (s == null) return null;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * 第二种方法，在原来的字符串上进行替换
     *
     * @param s 原来的字符串
     * @return 替换后的字符串
     */
    public String solution2(String s) {
        return s.replaceAll(" ", "%20");
    }
}
