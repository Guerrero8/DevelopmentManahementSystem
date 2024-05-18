package org.example.service;

import org.example.controller.dto.CreateClientDTO;
import org.example.entity.Client;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientFnsRepository;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = ClientService.class)
class ClientServiceTest {
    @MockBean
    ClientMapper clientMapper;
    @MockBean
    ClientRepository clientRepository;
    @MockBean
    ClientFsnService clientFsnService;
    @MockBean
    ClientFnsRepository clientFnsRepository;
    @MockBean
    OrderRepository orderRepository;

    ClientService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ClientService(clientMapper, clientRepository, clientFsnService, clientFnsRepository, orderRepository);
    }

    @Test
    void createClient() {
        // Создаем тестовые данные
        CreateClientDTO createClientDTO = new CreateClientDTO();
        Client client = new Client();
        // Настраиваем моки
        when(clientMapper.toClientFromSetupClientDTO(createClientDTO)).thenReturn(client);

        // Вызываем тестируемый метод
        underTest.createClient(createClientDTO);

        // Захватываем аргументы
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository, times(1)).save(clientArgumentCaptor.capture());
        verify(clientMapper, times(1)).toClientFromSetupClientDTO(any());

        // Проверяем результат
        Client capturedClient = clientArgumentCaptor.getValue();
        assertEquals(client, capturedClient);
    }
}