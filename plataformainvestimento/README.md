### Contexto

Uma fintech deseja criar um sistema para simulação de investimentos em ações, fundos e renda fixa.

Usuários podem comprar/vender ativos, consultar extrato e monitorar evolução da carteira.

### Regras de Negócio

- Usuários precisam estar autenticados (JWT).
- CRUD de ativos (ações, fundos, títulos públicos).
- Saldo inicial fixo ao cadastrar usuário (ex: R$ 100.000).
- Compras só podem ocorrer se houver saldo suficiente.
- Vendas só podem ocorrer se o usuário possuir a quantidade de ativos.
- Atualização de preços deve ser feita por API externa (mock ou integração real).
- Risco do portfólio deve ser calculado:
    - **Baixo**: >70% renda fixa
    - **Médio**: 30–70% ações/fundos
    - **Alto**: >70% ações/fundos
- Relatórios:
    - Evolução diária do patrimônio.
    - Ativos mais negociados.
    - Usuários com maior rentabilidade.
- Não permitir operações simultâneas inconsistentes (usar transações ACID).

### Implementação

- Spring Boot + JPA + PostgreSQL.
- Módulo assíncrono para atualização de cotações (Scheduler).
- Cache para consultas de ativos.
- Spring Security + JWT.
- Testes unitários + testes de integração com WireMock (simulação da API externa).