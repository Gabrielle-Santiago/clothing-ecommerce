# 🛒 E-commerce Multi-Vendor Engine

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![Architecture](https://img.shields.io/badge/Architecture-Hexagonal-blue)
![Database](https://img.shields.io/badge/Database-PostgreSQL-336791)

Sistema de e-commerce robusto focado no nicho de moda, desenvolvido com **Arquitetura Hexagonal (Ports & Adapters)**. O sistema é projetado para ser um marketplace real, onde múltiplos vendedores gerenciam seus estoques e clientes realizam compras com processamento de pagamento assíncrono.

---

## 🏗️ Arquitetura do Sistema

O projeto utiliza os princípios da Arquitetura Limpa para garantir o desacoplamento total entre as regras de negócio e os serviços externos.



### Componentes Principais:
- **Domínio (Core):** Contém a lógica de negócio pura, entidades e regras de transição de status.
- **Adapters de Entrada:** REST Controllers (Spring MVC) e Listeners de Webhooks.
- **Adapters de Saída:** Repositórios (Spring Data JPA) e Gateways de integração com Mercado Pago e Spring Mail.

---

## 🔒 Autenticação e Autorização

Implementamos um fluxo rigoroso baseado em **OIDC (OpenID Connect)** e **OAuth 2.0**:

1. **MFA (Multi-Factor Authentication):** Cadastro e login validados via código enviado pelo `Spring Mail`.
2. **RBAC Dinâmico (Role-Based Access Control):** - As permissões não estão "hardcoded". Elas são carregadas do banco de dados via tabelas de relacionamento (`user_roles`, `role_permissions`).
   - Papéis principais: `SELLERS` (Gestão de produtos e pedidos) e `CLIENTS` (Compra e histórico).

---

## 💳 Fluxo de Pagamento (Mercado Pago)

O sistema prioriza a **consistência eventual** para evitar falhas por timeout e melhorar a experiência do usuário.

1. **Pedido Criado:** Status inicial `PENDING`.
2. **Integração:** Cliente é direcionado ao checkout.
3. **Webhook:** O sistema expõe um endpoint para receber notificações assíncronas do Mercado Pago.
4. **Atualização:** O status é atualizado apenas após a confirmação do Webhook.

**Ciclo de Vida do Pedido:**
`PENDING` ➔ `CONFIRMED` ➔ `PROCESSING` ➔ `SHIPPED` ➔ `DELIVERED`
*(Fluxo alternativo: `CANCELED` em caso de falha no pagamento ou estorno).*

---

## 📊 Estrutura de Dados (ERD)

Abaixo, a organização das tabelas no **PostgreSQL**:

| Tabela | Função |
| :--- | :--- |
| `users` | Dados centrais de acesso e identificação. |
| `roles` & `permissions` | Definições dinâmicas de acesso (ex: `can_update_product`). |
| `stock` | Controle de inventário vinculado ao `product` e ao `seller_id`. |
| `orders` | Cabeçalho do pedido com status e IDs de transação externa. |

---

## 🚀 Roadmap de Desenvolvimento

- [x] Autenticação com TOken/Refresh token.
- [x] Gestão de Produtos Multi-Vendedor.
- [ ] **Futuro:** Integração com Webhook do Mercado Pago.
- [ ] **Futuro:** Implementação de Carrinho de Compras persistido no Postgres.
- [ ] **Futuro:** Sistema de sugestão de novas categorias por vendedores (Fluxo de Aprovação).
- [ ] **Futuro:** Dashboard administrativo para comissionamento de vendas.

---

## 🤝 Contribuição

Este projeto está em constante evolução. Para contribuir:

1. Faça um **Fork** do projeto.
2. Crie sua Feature Branch (`git checkout -b feature/NovaFuncionalidade`).
3. Commit suas mudanças (`git commit -m 'Add: Descrição da funcionalidade'`).
4. Push para a Branch (`git push origin feature/NovaFuncionalidade`).
5. Abra um **Pull Request**.

---
