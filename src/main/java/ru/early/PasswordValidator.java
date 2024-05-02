package ru.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    /**
     * Метод проверят пароль по правилам:
     *  1. Если password null, то выбросить исключение "Password can't be null";
     *  2. Длина пароля находится в диапазоне [8, 32],
     *     если нет то "Password should be length [8, 32]";
     *  3. Пароль содержит хотя бы один символ в верхнем регистре,
     *     если нет то "Password should contain at least one uppercase letter");
     *  4. Пароль содержит хотя бы один символ в нижнем регистре,
     *     если нет то "Password should contain at least one lowercase letter";
     *  5. Пароль содержит хотя бы одну цифру,
     *     если нет то"Password should contain at least one figure");
     *  6. Пароль содержит хотя бы один спец. символ (не цифра и не буква),
     *     если нет то "Password should contain at least one special symbol");
     *  7. Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user.
     *     Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п.
     *     если да, то "Password shouldn't contain substrings: qwerty, 12345, password, admin, user".
     * @param password Пароль
     * @return Вернет пароль или выбросит исключение.
     */
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean registerUp = false;
        boolean registerLow = false;
        boolean isDigit = false;
        boolean isSymbol = false;
        char[] symbols = password.toCharArray();
        for (char symbol : symbols) {
            if (registerUp && registerLow && isDigit && isSymbol) {
                break;
            }
            if (Character.isUpperCase(symbol)) {
                registerUp = true;
            }
            if (Character.isLowerCase(symbol)) {
                registerLow = true;
            }
            if (Character.isDigit(symbol)) {
                isDigit = true;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                isSymbol = true;
            }
        }
        if (!registerUp) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!registerLow) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit) {
            throw  new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String passLower = password.toLowerCase();
        if (passLower.contains("qwerty") || passLower.contains("12345")
                || passLower.contains("password") || passLower.contains("admin")
                || passLower.contains("user")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    public static boolean find(String text, String pattern) {
        char[] textCh = text.toCharArray();
        char[] patternCh = pattern.toCharArray();
        int t = 0;
        int last = patternCh.length - 1;
        while (t < text.length() - last) {
            int p = 0;
            while (p <= last && (Character.compare(textCh[ t + p ], Character.toLowerCase(patternCh[p])) == 0 || Character.compare(textCh[ t + p ], Character.toUpperCase(patternCh[p])) == 0)) {
                p++;
            }
            if (p == pattern.length()) {
                return true;
            }
            t++;
        }
        return false;
    }
}
