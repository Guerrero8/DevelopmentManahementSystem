package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.controller.dto.ClientFnsDTO;
import org.example.entity.ClientFns;
import org.example.repository.ClientFnsRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientFsnService {
    private final ObjectMapper objectMapper;
    private final ClientFnsRepository clientFnsRepository;
    @SneakyThrows
    public ClientFns getClientFnsData(String req){
        if (clientFnsRepository.findClientFnsByInn(req) == null){
            String fnsData = //fnsClient.getClientFns(req, "a7b7cf9f349a9ebca9d3a4cec8183bb11a664ff4");
                    "{\n" +
                            "    \"items\": [\n" +
                            "        {\n" +
                            "            \"ИП\": {\n" +
                            "                \"ФИОПолн\": \"Попов Сергей Романович\",\n" +
                            "                \"ИННФЛ\": \"507407629014\",\n" +
                            "                \"ОГРНИП\": \"323508100493328\",\n" +
                            "                \"ДатаОГРН\": \"2023-09-15\",\n" +
                            "                \"ДатаРег\": \"2023-09-15\",\n" +
                            "                \"ВидИП\": \"Индивидуальный предприниматель\",\n" +
                            "                \"Пол\": \"Мужской\",\n" +
                            "                \"ВидГражд\": \"Гражданин РФ\",\n" +
                            "                \"Статус\": \"Действующее\",\n" +
                            "                \"НО\": {\n" +
                            "                    \"Рег\": \"5081 (Межрайонная инспекция Федеральной налоговой службы №23 по Московской области)\",\n" +
                            "                    \"РегДата\": \"2023-09-15\",\n" +
                            "                    \"Учет\": \"5074 (Межрайонная инспекция Федеральной налоговой службы №5 по Московской области)\",\n" +
                            "                    \"УчетДата\": \"2023-09-15\"\n" +
                            "                },\n" +
                            "                \"ПФ\": {\n" +
                            "                    \"РегНомПФ\": \"060036080311\",\n" +
                            "                    \"ДатаРегПФ\": \"2023-09-19\",\n" +
                            "                    \"КодПФ\": \"060036 (Отделение Фонда пенсионного и социального страхования Российской Федерации по г. Москве и Московской области)\"\n" +
                            "                },\n" +
                            "                \"КодыСтат\": {\n" +
                            "                    \"ОКПО\": \"2025967659\",\n" +
                            "                    \"ОКТМО\": \"46760000001\",\n" +
                            "                    \"ОКФС\": \"16\",\n" +
                            "                    \"ОКОГУ\": \"4210015\"\n" +
                            "                },\n" +
                            "                \"Адрес\": {\n" +
                            "                    \"КодРегион\": \"50\",\n" +
                            "                    \"Индекс\": null,\n" +
                            "                    \"АдресПолн\": \"обл. Московская, г Подольск\",\n" +
                            "                    \"Дата\": \"2023-09-15\"\n" +
                            "                },\n" +
                            "                \"E-mail\": \"NONPROFITXZBUSINESS@GMAIL.COM\",\n" +
                            "                \"Контакты\": {\n" +
                            "                    \"e-mail\": [\n" +
                            "                        \"nonprofitxzbusiness@gmail.com\"\n" +
                            "                    ]\n" +
                            "                },\n" +
                            "                \"ОснВидДеят\": {\n" +
                            "                    \"Код\": \"62.01\",\n" +
                            "                    \"Текст\": \"Разработка компьютерного программного обеспечения\",\n" +
                            "                    \"Дата\": \"2023-09-15\"\n" +
                            "                },\n" +
                            "                \"ДопВидДеят\": [],\n" +
                            "                \"СПВЗ\": [\n" +
                            "                    {\n" +
                            "                        \"Дата\": \"2023-09-20\",\n" +
                            "                        \"Текст\": \"Представление сведений о регистрации в качестве страхователя в территориальном органе Пенсионного фонда Российской Федерации\"\n" +
                            "                    },\n" +
                            "                    {\n" +
                            "                        \"Дата\": \"2023-09-15\",\n" +
                            "                        \"Текст\": \"Представление сведений об учете в налоговом органе\"\n" +
                            "                    },\n" +
                            "                    {\n" +
                            "                        \"Дата\": \"2023-09-15\",\n" +
                            "                        \"Текст\": \"Государственная регистрация физического лица в качестве индивидуального предпринимателя\"\n" +
                            "                    }\n" +
                            "                ],\n" +
                            "                \"История\": {\n" +
                            "                    \"E-mail\": {\n" +
                            "                        \"2023-09-15 ~ 2023-09-19\": \"NONPROFITXZBUSINESS@GMAIL.COM\",\n" +
                            "                        \"2023-09-20 ~ 2023-12-21\": \"NONPROFITXZBUSINESS@GMAIL.COM\"\n" +
                            "                    }\n" +
                            "                }\n" +
                            "            }\n" +
                            "        }\n" +
                            "    ]\n" +
                            "}";
            ClientFnsDTO clientFnsDTO = objectMapper.readValue(fnsData, ClientFnsDTO.class);
            ClientFns clientFns = setupClientFns(clientFnsDTO);
            clientFnsRepository.save(clientFns);
            return clientFns;
        } else {
            throw new RuntimeException("Клиент уже существует");
        }
    }

    public ClientFns setupClientFns(ClientFnsDTO clientFnsDTO){
        ClientFns clientFns = new ClientFns();
        clientFns.setInn(clientFnsDTO.getItems().get(0).getEntrepreneur().getInn());
        clientFns.setFullName(clientFnsDTO.getItems().get(0).getEntrepreneur().getFullName());
        clientFns.setOgrnip(clientFnsDTO.getItems().get(0).getEntrepreneur().getOgrnip());
        return clientFns;
    }
}
