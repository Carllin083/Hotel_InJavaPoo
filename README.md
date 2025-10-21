# 🚀 Hotel_InJavaPoo: Sistema de Gerenciamento Hoteleiro

Este repositório contém o código-fonte de um Sistema de Gerenciamento Hoteleiro, desenvolvido inteiramente em Java. O projeto foi concebido como um estudo de caso prático para aplicar e aprofundar os conceitos fundamentais da Programação Orientada a Objetos (POO) em um cenário do mundo real.

O objetivo principal não foi criar uma interface gráfica complexa, mas sim focar na **modelagem de domínio**, nas **regras de negócio** e na **interação estruturada entre objetos**, simulando o fluxo de trabalho de um hotel.

## 🏨 Visão Geral e Funcionalidades

O sistema simula as operações diárias de um hotel, permitindo o gerenciamento de quartos, hóspedes e o ciclo de vida de uma estadia, desde a reserva até o check-out.

### 1. Gerenciamento de Quartos
A base do hotel. Cada quarto é um objeto com estado e comportamento próprios.
* **Cadastro de Quartos:** Permite adicionar novos quartos ao sistema, especificando atributos essenciais como número, andar, tipo (Ex: Simples, Casal, Suíte de Luxo) e valor da diária.
* **Controle de Status:** O sistema gerencia o estado de cada quarto (Ex: `DISPONIVEL`, `OCUPADO`, `EM_LIMPEZA`, `EM_MANUTENCAO`). Esse status é crucial e atualizado automaticamente pelas outras operações do sistema.
* **Consultas:** É possível listar todos os quartos ou filtrar apenas pelos que estão disponíveis, facilitando o processo de reserva.

### 2. Gerenciamento de Hóspedes
O sistema mantém um registro centralizado de todos os clientes.
* **CRUD de Hóspedes:** Permite o cadastro completo (Nome, CPF, Telefone, Email) de novos hóspedes, bem como a atualização, consulta e remoção de seus dados.
* **Histórico de Estadias:** Cada objeto `Hospede` pode ter uma lista de `Reservas` associadas, permitindo consultar o histórico de visitas do cliente.

### 3. Ciclo de Vida da Reserva e Estadia
Esta é a funcionalidade central que conecta Hóspedes e Quartos.
* **Efetuar Reserva:** O sistema permite criar uma `Reserva`, que vincula um `Hospede` a um `Quarto` específico para um período (datas de entrada e saída). O sistema valida se o quarto está disponível naquele período antes de confirmar.
* **Realizar Check-in:** Quando o hóspede chega, a `Reserva` é convertida em uma `Hospedagem` ativa. O status do `Quarto` é imediatamente alterado para `OCUPADO`.
* **Realizar Check-out:** Ao final da estadia, o sistema realiza o processo de check-out, que:
    1.  Calcula o valor total a ser pago (com base no número de diárias e serviços/consumo extras).
    2.  Registra o pagamento.
    3.  Libera o `Hospede` da `Hospedagem`.
    4.  Altera o status do `Quarto` para `EM_LIMPEZA` ou `DISPONIVEL`, deixando-o pronto para o próximo cliente.

## ☕ Foco Principal: Aplicação Prática de POO

Mais do que um sistema de hotel, este projeto é um laboratório de POO. Cada decisão de design foi tomada para refletir os pilares da orientação a objetos:

* **Abstração:** Foco em definir as entidades essenciais (`Hospede`, `Quarto`, `Reserva`, `Funcionario`) e quais atributos e métodos elas deveriam ter para representar o sistema real.
* **Encapsulamento:** Os atributos das classes são privados. Por exemplo,
