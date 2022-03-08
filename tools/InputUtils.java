package tools;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author anztim
 */
public class InputUtils {
    private InputUtils() {
    }

    public static String readString(Class<?> aClass, String path) {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader reader =
                     new InputStreamReader(
                             Objects.requireNonNull(aClass.getResourceAsStream(path)),
                             StandardCharsets.UTF_8)) {
            char[] buffer = new char[64];
            int buffered;
            while ((buffered = reader.read(buffer, 0, 64)) >= 0) {
                sb.append(buffer, 0, buffered);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    public static int[] parseArray(String str) {
        str = str.replace(" ", "");
        if (!str.matches("[{\\[]([+-]?\\d*(,[+-]?\\d*)*)?[]}]")) {
            System.out.println("not match");
            return null;
        }
        return basicParseArray(str.substring(1, str.length() - 1));
    }

    public static int[][] parse2dArray(String str) {
        str = str.replace(" ", "");
        if (!str.matches("[{\\[]([{\\[]([+-]?\\d*(,[+-]?\\d*)*)?[\\]}](,[{\\[]([+-]?\\d*(,[+-]?\\d*)*)?[\\]}])*)?[\\]}]")) {
            System.out.println("not match 2d");
            return null;
        }
        String[] split = str.substring(2, str.length() - 2).split("\\] *, *\\[");
        int len = split.length;
        int[][] result = new int[len][];
        for (int i = 0; i <len;i++) {
            result[i] = basicParseArray(split[i]);
        }
        return result;
    }

    private static int[] basicParseArray(String str) {
        String[] split = str.split(",");
        int len = split.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.parseInt(split[i].trim());
        }
        return result;
    }
}
