package com.sparta.weatherapi;

public enum Languages
{ //using ISO 639-2 Language codes

    AFRIKAANS("afr"),
    ALBANIAN("alb"),
    ARABIC("ara"),
    AZERBAIJANI("aze"),

    BASQUE("baq"),
    BENGALI("bn"),
    BULGARIAN("bul"),

    CATALAN("cat"),
    CHINESE("zh"),
    CROATIAN("hr"),
    CZECH("cze"),

    DANISH("dan"),
    DUTCH("dut"),

    ENGLISH("en"),

    FARSI("fas"),
    FINNISH("fi"),
    FRENCH("fr"),

    GALICIAN("glg"),
    GERMAN("de"),
    GREEK("el"),

    HEBREW("he"),
    HINDI("hi"),
    HUNGARIAN("hu"),

    INDONESIAN("id"),
    ITALIAN("it"),

    JAPANESE("ja"),

    KOREAN("ko"),

    LATVIAN("lav"),
    LITHUANIAN("lit"),

    MACEDONIAN("mkd"),

    NORWEGIAN("nor"),

    POLISH("pl"),
    PORTUGUESE("por"),
    PUNJABI("pa"),

    ROMANIAN("ron"),
    RUSSIAN("rus"),

    SERBIAN("srp"),
    SLOVAK("sk"),
    SLOVENIAN("slk"),
    SPANISH("es"),
    SWEDISH("sv"),

    TAMIL("ta"),
    THAI("tha"),
    TURKISH("tur"),

    UKRAINIAN("ukr"),

    ZULU("zul");

    public final String languageCode;

    Languages(String lCode)
    {
        this.languageCode = lCode;
    }
}
