import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Byte> c = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(me("{(({})[(){}])}"));
    }

    private static boolean me(String str) {
        if (!str.isEmpty()) {
            byte[] bytes = str.getBytes();
            for (byte b : bytes) {
                if (isOpen(b)) {
                    c.add(b);
                } else {
                    if (!c.isEmpty() && isValidClosed(c.get(c.size() - 1), b)) {
                        c.remove(c.size() - 1);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean isOpen(byte b) {
        return b == 123 || b == 91 || b == 40;
    }

    private static boolean isValidClosed(byte a, byte b) {
        if (a == 123 && b == 125) {
            return true;
        }
        if (a == 91 && b == 93) {
            return true;
        }
        return a == 40 && b == 41;
    }
}
