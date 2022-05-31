package base.model;

/**
 * The type Email generator.
 */
public class EmailGenerator {
    /**
     * Uuid string.
     *
     * @return the string
     */
    public static String uuid() {
        String result = java.util.UUID.randomUUID().toString();
        result = result.replaceAll("-", "");
        result = result.substring(0, 7);
        return result;
    }
}
