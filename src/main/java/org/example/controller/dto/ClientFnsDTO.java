package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientFnsDTO {
    @JsonProperty("items")
    private List<Item> items;
    @Data
    public static class Item {
        @JsonProperty("ИП")
        private Entrepreneur entrepreneur;
    }
    @Data
    public static class Entrepreneur {
        @JsonProperty("ФИОПолн")
        private String fullName;
        @JsonProperty("ИННФЛ")
        private String inn;
        @JsonProperty("ОГРНИП")
        private String ogrnip;
        @JsonProperty("ДатаОГРН")
        private String ogrnDate;
        @JsonProperty("ДатаРег")
        private String regDate;
        @JsonProperty("ВидИП")
        private String type;
        @JsonProperty("Пол")
        private String gender;
        @JsonProperty("ВидГражд")
        private String citizenship;
        @JsonProperty("Статус")
        private String status;
        @JsonProperty("НО")
        private TaxAuthority taxAuthority;
        @JsonProperty("ПФ")
        private PensionFund pensionFund;
        @JsonProperty("КодыСтат")
        private StatusCodes statusCodes;
        @JsonProperty("Адрес")
        private Address address;
        @JsonProperty("E-mail")
        private String email;
        @JsonProperty("Контакты")
        private Contacts contacts;
        @JsonProperty("ОснВидДеят")
        private MainActivity mainActivity;
        @JsonProperty("ДопВидДеят")
        private String[] additionalActivities;
        @JsonProperty("СПВЗ")
        private RegistrationAction[] registrationActions;
        @JsonProperty("История")
        private History history;
    }

    @Data
    public static class TaxAuthority {
        @JsonProperty("Рег")
        private String registration;
        @JsonProperty("РегДата")
        private String regDate;
        @JsonProperty("Учет")
        private String accounting;
        @JsonProperty("УчетДата")
        private String accountingDate;
    }

    @Data
    public static class PensionFund {
        @JsonProperty("РегНомПФ")
        private String registrationNumber;
        @JsonProperty("ДатаРегПФ")
        private String regDate;
        @JsonProperty("КодПФ")
        private String code;
    }

    @Data
    public static class StatusCodes {
        @JsonProperty("ОКПО")
        private String okpo;
        @JsonProperty("ОКТМО")
        private String oktmo;
        @JsonProperty("ОКФС")
        private String okfs;
        @JsonProperty("ОКОГУ")
        private String okogu;
    }

    @Data
    public static class Address {
        @JsonProperty("КодРегион")
        private String regionCode;
        @JsonProperty("Индекс")
        private String index;
        @JsonProperty("АдресПолн")
        private String fullAddress;
        @JsonProperty("Дата")
        private String date;
    }

    @Data
    public static class Contacts {
        @JsonProperty("e-mail")
        private String[] email;
    }

    @Data
    public static class MainActivity {
        @JsonProperty("Код")
        private String code;
        @JsonProperty("Текст")
        private String text;
        @JsonProperty("Дата")
        private String date;
    }

    @Data
    public static class RegistrationAction {
        @JsonProperty("Дата")
        private String date;
        @JsonProperty("Текст")
        private String text;
    }

    @Data
    public static class History {
        @JsonProperty("E-mail")
        private HistoryEmail email;
    }

    @Data
    public static class HistoryEmail {
        @JsonProperty("2023-09-15 ~ 2023-09-19")
        private String firstPeriod;
        @JsonProperty("2023-09-20 ~ 2023-12-21")
        private String secondPeriod;
    }
}
