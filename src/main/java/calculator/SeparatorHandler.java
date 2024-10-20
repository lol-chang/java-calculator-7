package calculator;

public class SeparatorHandler {
    public String[] getSeparatedNumbers(String input) {
        String[] parts = input.split("\\\\n");
        String separator = "[,:]";
        String numbers = parts[0];

        if (isCustomSeparator(parts)) {
            String custom = getCustomSeparator(parts[0]);
            separator = "[,:" + custom + "]";
            numbers = parts[1];
        }
        return numbers.split(separator);
    }

    private boolean isCustomSeparator(String[] parts) {
        if (parts.length == 1) {
            return false;
        }
        if (!parts[0].startsWith("//")) {
            throw new IllegalArgumentException("커스텀 구분자 입력 형식 틀림");
        }
        return true;
    }

    private String getCustomSeparator(String part) {
        if (part.length() != 3) {
            throw new IllegalArgumentException("커스텀 구분자 입력 길이 틀림");
        }
        return Character.toString(part.charAt(2));
    }
}
