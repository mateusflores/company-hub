package br.unesp.mateusflores.companyhubapp.application.util;

public class RegexUtil {

    public static final String BRAZILIAN_PHONE_REGEX = "/^(55)?(?:([1-9]{2})?)(\\d{4,5})(\\d{4})$/";
    public static final String BRAZILIAN_POSTAL_CODE_REGEX = "(^[0-9]{5})-?([0-9]{3}$)";
    public static final String CNPJ_REGEX = "[A-Z0-9]{12}[0-9]{2}";

}
