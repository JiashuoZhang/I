public class Strings {
    public static int parseInt(String n) {
        char[] nChar = n.toCharArray();
        int result = 0;
        for (int i = 0; i < nChar.length; i++) {
            result = result * 10 + (nChar[i] - '0');
        }
        return result;
    }

    public static int compareVersions(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int p1 = 0, p2 = 0, n1 = 0, n2 = 0;
        while (p1 < v1.length || p2 < v2.length) {
            while (p1 < v1.length && v1[p1] != '.') {
                n1 = n1 * 10 + v1[p1++] - '0';
            }
            while (p2 < v2.length && v2[p2] != '.') {
                n2 = n2 * 10 + v2[p2++] - '0';
            }
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            } else {
                n1 = 0;
                n2 = 0;
                p1++;
                p2++;
            }
        }
        return 0;
    }

    public static String removeSpace(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.trim();
        int i = 0;
        boolean foundWord = false;
        while (i < str.length()) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
                foundWord = true;
            } else {
                if (foundWord) {
                    sb.append(" ");
                    foundWord = false;
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(1234 + " is equal to " + parseInt("1234"));
        System.out.println("12.2.3 > 12.2.1" + " " + compareVersions("12.2.3", "12.2.1"));
        System.out.println("2.1 < 2.2" + " " + compareVersions("2.1", "2.2"));

        // Test remove space
        System.out.println("  a  b  c d  " + ":" + removeSpace("  a  b  c d  "));
    }
}
