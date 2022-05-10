package br.com.home.utils;

import br.com.home.controller.exception.UnsupportedMathOperationException;

public class Utils {

    public static boolean isNumeric(String str) {
        return str.matches("[\\d]*");
    }

    /**
     * @return retorna um double caso seja um valor não nulo
     */
    public static Double convertToDouble(String str) {
        return Double.parseDouble(str);
    }

    /**
     * @return retorna um double caso o valor seja válido
     */
    public static Double sumInputs(String one, String two) {
        if (isNumeric(one) && isNumeric(two))
            return convertToDouble(one) + convertToDouble(two);
        throw new UnsupportedMathOperationException(String.format("Os valores não são do tipo Double   [%s] [%s] ", one, two));
    }

    public static Double subInputs(String one, String two) {
        if (isNumeric(one) && isNumeric(two))
            return convertToDouble(one) - convertToDouble(two);
        throw new UnsupportedMathOperationException(String.format("Os valores não são do tipo Double   [%s] [%s] ", one, two));
    }

    public static Double multiInputs(String one, String two) {
        if (isNumeric(one) && isNumeric(two))
            return   convertToDouble(one)  * convertToDouble(two);
        throw new UnsupportedMathOperationException(String.format("Os valores não são do tipo Double   [%s] [%s] ", one, two));
    }
}
