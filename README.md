# spring-boot-project-pede-ai
Projeto para aprendizado e consolidação de conhecimento em Spring Boot

# Proposta de Projeto
Uma solução com uma arquitetura em camadas com domínios detalhados, serviços, controllers e casos de uso, usando o Spring Boot em Java.

## 1. Domínios:
- Usuário: representa os usuários do marketplace, incluindo clientes e restaurantes. Pode conter informações como nome, endereço, informações de contato, preferências alimentares, etc.
- Pedido: representa um pedido feito por um cliente. Contém informações sobre os itens do pedido, status do pedido, endereço de entrega, detalhes de pagamento, etc.
- Restaurante: representa os restaurantes que oferecem comida no marketplace. Pode conter informações como nome, localização, tipo de cozinha, horários de funcionamento, etc.
- Item de Menu: representa os pratos ou produtos disponíveis no menu de um restaurante. Pode conter informações como nome, descrição, preço, disponibilidade, etc.
- Avaliação: representa as avaliações de um usuário feitas sobre um determinado pedido

A seguir os domínios em detalhes para uma aplicação de um site de marketplace de comida, usando o Spring Boot em Java:

### Usuário:

#### Descrição: 
Representa os usuários do marketplace, incluindo clientes e restaurantes.

#### Atributos:

- ID: Identificador único do usuário.  
- Nome: Nome do usuário.
- E-mail: Endereço de e-mail do usuário. 
- Senha: Senha do usuário (geralmente armazenada de forma criptografada).
- Papel: Indica o papel do usuário (cliente ou restaurante).
- Endereços: Lista de endereços associados ao usuário (endereço de entrega para clientes e endereço do restaurante para restaurantes).
 
#### Relacionamentos:
- Pedidos: Relacionamento um-para-muitos com os pedidos feitos pelo usuário.
- Avaliações: Relacionamento um-para-muitos com as avaliações deixadas pelo usuário.

### Pedido:

#### Descrição: 
Representa um pedido feito por um cliente.
#### Atributos:
- ID: Identificador único do pedido.
- Data e Hora: Data e hora em que o Como seria em Java, com Spring Boot, lombok e persistencia em Mongodb o dominio    pedido foi feito.
- Itens: Lista de itens do pedido, contendo informações como nome, quantidade, preço, etc.
- Endereço de Entrega: Endereço de entrega fornecido pelo cliente.
- Status: Status do pedido (em preparação, em rota, entregue, etc.).
- Valor Total: Valor total do pedido.

#### Relacionamentos:
- Cliente: Relacionamento muitos-para-um com o cliente que fez o pedido.
- Restaurante: Relacionamento muitos-para-um com o restaurante responsável pelo pedido.

### Avaliação:

#### Descrição:
Representa as avaliações dos usuários.

#### Atributos:
- ID: Identificador único da avaliação.
- Nota: Nota de 1 a 5.
- Comentário: o comentário sobre o pedido.

#### Relacionamentos:
- Itens de Menu: Relacionamento um-para-muitos com os itens disponíveis no menu do restaurante.
- Pedidos Recebidos: Relacionamento um-para-muitos com os pedidos feitos pelos clientes.

### Restaurante:

#### Descrição: 
Representa os restaurantes que oferecem comida no marketplace.

#### Atributos:
- ID: Identificador único do restaurante.
- Nome: Nome do restaurante.
- Endereço: Endereço do restaurante.
- Horários de Funcionamento: Horários de abertura e fechamento do restaurante.
- Tipo de Cozinha: Tipo de culinária oferecida pelo restaurante.

#### Relacionamentos:
- Itens de Menu: Relacionamento um-para-muitos com os itens disponíveis no menu do restaurante.
- Pedidos Recebidos: Relacionamento um-para-muitos com os pedidos feitos pelos clientes.

### Item de Menu:

#### Descrição: 
Representa os pratos ou produtos disponíveis no menu de um restaurante.

#### Atributos:
- ID: Identificador único do item de menu.
- Nome: Nome do item.
- Descrição: Descrição do item.
- Preço: Preço do item. 
- Disponibilidade: Indica se o item está disponível ou não.
 
#### Relacionamentos:
- Restaurante: Relacionamento muitos-para-um com o restaurante ao qual o item de menu pertence.

Esses são exemplos de domínios que podem ser utilizados em uma aplicação de marketplace de comida usando o Spring Boot em Java. Lembre-se de ajustar esses domínios de acordo com os requisitos específicos do seu projeto, adicionando ou removendo atributos e relacionamentos conforme necessário.

## 2. Controllers:
- AutenticaçãoController: gerencia endpoints relacionados à autenticação, como login e logout.
- UserController: trata as requisições relacionadas aos usuários, como endpoints para registro, atualização de perfil e gerenciamento de endereços.
- PedidoController: lida com as requisições relacionadas aos pedidos, como criar um novo pedido, rastrear status, cancelar um pedido, etc.
- RestauranteController: gerencia as requisições relacionadas a restaurantes, como registro de restaurante, adição e atualização de itens de menu.
- PagamentoController: lida com as requisições de pagamento, como processar um pagamento para um pedido.

A seguir os controllers em detalhes para uma aplicação de um site de marketplace de comida, semelhante ao iFood, usando o Spring Boot em Java:

### AutenticaçãoController:

#### Descrição: 
Gerencia endpoints relacionados à autenticação, como login e logout.

#### Endpoints:
- POST /api/login: Recebe as credenciais de login (e-mail e senha) do usuário, verifica a autenticidade das credenciais e gera um token de autenticação válido.
- POST /api/logout: Invalida o token de autenticação atual, efetuando o logout do usuário.

### UsuarioController:

#### Descrição: 
Trata as requisições relacionadas aos usuários, como registro, atualização de perfil e gerenciamento de endereços.

#### Endpoints:
- POST /api/users: Registra um novo usuário no sistema, recebendo informações como nome, e-mail e senha.
- GET /api/users/{userId}: Obtém os detalhes do perfil de um usuário específico com base no ID do usuário.
- PUT /api/users/{userId}: Atualiza as informações do perfil de um usuário específico com base no ID do usuário.
- GET /api/users/{userId}/addresses: Obtém a lista de endereços associados a um usuário específico.
- POST /api/users/{userId}/addresses: Adiciona um novo endereço ao perfil de um usuário específico.
- PUT /api/users/{userId}/addresses/{addressId}: Atualiza as informações de um endereço específico de um usuário.

### PedidoController:

#### Descrição: 
Lida com as requisições relacionadas aos pedidos, como criação, rastreamento de status, cancelamento e histórico de pedidos.

#### Endpoints:
- POST /api/orders: Cria um novo pedido para um usuário autenticado, recebendo informações como itens do pedido, endereço de entrega, detalhes de pagamento, etc.
- GET /api/orders/{orderId}: Obtém os detalhes de um pedido específico com base no ID do pedido.
- GET /api/orders: Obtém o histórico de pedidos de um usuário autenticado.
- PUT /api/orders/{orderId}/cancel: Cancela um pedido específico com base no ID do pedido.
- GET /api/orders/{orderId}/track: Obtém o status atual de um pedido específico com base no ID do pedido.

### RestauranteController:

#### Descrição: 
Gerencia as requisições relacionadas a restaurantes, como registro, adição e atualização de itens de menu.
    
#### Endpoints:
- POST /api/restaurants: Registra um novo restaurante no sistema, recebendo informações como nome, endereço, horários de funcionamento, etc.
- POST /api/restaurants/{restaurantId}/menu: Adiciona um novo item ao menu de um restaurante específico com base no ID do restaurante.
- PUT /api/restaurants/{restaurantId}/menu/{itemId}: Atualiza as informações de um item específico do menu de um restaurante com base nos IDs do restaurante e do item.

### PagamentoController:

#### Descrição: 
Lida com as requisições de pagamento, processando o pagamento para um pedido.
    
#### Endpoints:
- POST /api/payments/process: Recebe as informações de pagamento, como o token de pagamento, valor total e ID do pedido, e processa o pagamento.
- GET /api/payments/{paymentId}: Obtém os detalhes de um pagamento específico com base no ID do pagamento.

Esses são exemplos de controllers que podem ser utilizados em uma aplicação de marketplace de comida usando o Spring Boot em Java. Lembre-se de ajustar esses controllers de acordo com os requisitos específicos do seu projeto, adicionando ou removendo endpoints e funcionalidades conforme necessário.

## 3. Serviços:
- Serviço de Autenticação: gerencia a autenticação e autorização de usuários.
- Serviço de Usuário: lida com operações relacionadas a usuários, como registro, login, atualização de perfil e gerenciamento de endereços.
- Serviço de Pedido: gerencia operações relacionadas a pedidos, como criação de pedidos, rastreamento de status, histórico de pedidos e cancelamento de pedidos.
- Serviço de Restaurante: lida com operações relacionadas a restaurantes, como registro de restaurante, adição e atualização de itens de menu, gerenciamento de pedidos recebidos, etc.
- Serviço de Pagamento: processa pagamentos para os pedidos, integra-se com provedores de pagamento externos e lida com a confirmação de pagamento.
- Serviço de Geolocalização: fornece funcionalidades de geolocalização para ajudar na busca e filtragem de restaurantes com base na localização do usuário.

A seguir os serviços em detalhes para uma aplicação de um site de marketplace de comida, usando o Spring Boot em Java:

### Serviço de Autenticação:

#### Descrição: 
Gerencia a autenticação e autorização de usuários.
#### Funcionalidades:
- authenticateUser(username, password): Verifica as credenciais de login do usuário e gera um token de autenticação válido.
- validateToken(token): Valida a autenticidade de um token de autenticação.
- logout(token): Invalida um token de autenticação, efetuando o logout do usuário.

### Serviço de Usuário:

#### Descrição: 
Lida com operações relacionadas a usuários, como registro, atualização de perfil e gerenciamento de endereços.
#### Funcionalidades:
- registerUser(userDetails): Registra um novo usuário no sistema, salvando as informações fornecidas.
- getUserById(userId): Obtém os detalhes do perfil de um usuário com base no ID do usuário.
- updateUser(userId, userDetails): Atualiza as informações do perfil de um usuário com base no ID do usuário.
- getUserAddresses(userId): Obtém a lista de endereços associados a um usuário específico.
- addAddress(userId, addressDetails): Adiciona um novo endereço ao perfil de um usuário específico.
- updateAddress(userId, addressId, addressDetails): Atualiza as informações de um endereço específico de um usuário.

### Serviço de Pedido:

#### Descrição: 
Gerencia operações relacionadas a pedidos, como criação, rastreamento de status, cancelamento e histórico de pedidos.
#### Funcionalidades:
- createOrder(userId, orderDetails): Cria um novo pedido para um usuário, salvando as informações fornecidas.
- getOrderById(orderId): Obtém os detalhes de um pedido específico com base no ID do pedido.
- getUserOrders(userId): Obtém o histórico de pedidos de um usuário específico.
- cancelOrder(orderId): Cancela um pedido específico com base no ID do pedido.
- trackOrder(orderId): Obtém o status atual de um pedido específico com base no ID do pedido.

### Serviço de Restaurante:

#### Descrição: 
Lida com operações relacionadas a restaurantes, como registro, adição e atualização de itens de menu.
#### Funcionalidades:
- registerRestaurant(restaurantDetails): Registra um novo restaurante no sistema, salvando as informações fornecidas.
- addMenuItem(restaurantId, menuItemDetails): Adiciona um novo item ao menu de um restaurante específico com base no ID do restaurante.
- updateMenuItem(restaurantId, itemId, menuItemDetails): Atualiza as informações de um item específico do menu de um restaurante com base nos IDs do restaurante e do item.

### Serviço de Pagamento:

#### Descrição: 
Lida com as operações relacionadas ao processamento de pagamentos para os pedidos.
#### Funcionalidades:
- processPayment(paymentDetails): Processa o pagamento para um pedido, verificando as informações fornecidas e interagindo com provedores de pagamento externos.
- getPaymentById(paymentId): Obtém os detalhes de um pagamento específico com base no ID do pagamento.

Esses são exemplos de serviços que podem ser utilizados em uma aplicação de marketplace de comida usando o Spring Boot em Java. Lembre-se de ajustar esses serviços de acordo com os requisitos específicos do seu projeto, implementando as funcionalidades necessárias para a sua aplicação.

## 4. Casos de Uso:
- Registro de Usuário: o usuário cria uma conta no marketplace, fornecendo informações básicas e credenciais de login.
- Login de Usuário: o usuário autentica-se no marketplace com suas credenciais de login.
- Atualização de Perfil do Usuário: o usuário atualiza suas informações de perfil, como nome, endereço e número de telefone.
- Gerenciamento de Endereços: o usuário pode adicionar, remover e atualizar endereços de entrega.
- Pesquisar Restaurantes: o usuário pesquisa restaurantes disponíveis com base em localização ou filtros.
- Visualizar Menu de Restaurante: o usuário seleciona um restaurante e visualiza seu menu.
- Adicionar Item ao Pedido: o usuário adiciona itens de menu ao seu pedido.
- Fazer Pedido: o usuário revisa o pedido, fornece detalhes adicionais (como observações) e confirma o pedido.
- Rastrear Pedido: o usuário acompanha o status do pedido em tempo real.
- Cancelar Pedido: o usuário solicita o cancelamento de um pedido, desde que esteja dentro do prazo permitido.
- Atualizar Item de Menu: o restaurante atualiza as informações de um item de menu existente.
- Gerenciamento de Pedidos do Restaurante: o restaurante visualiza os pedidos recebidos, atualiza o status do pedido (como confirmação, preparação, entrega) e gerencia as notificações de pedidos.
- Processar Pagamento: o sistema processa o pagamento para o pedido e atualiza o status do pedido.
- Avaliar Restaurante: o usuário pode deixar uma avaliação e feedback sobre a experiência com o restaurante.

Abaixo, apresento uma lista de casos de uso detalhados para uma aplicação de um site de marketplace de comida, semelhante ao iFood, usando o Spring Boot em Java:

### Registro de Usuário:
#### Descrição: 
Um usuário interessado em usar o marketplace de comida cria uma conta.
#### Fluxo:
- O usuário acessa a página de registro e fornece informações pessoais, como nome, e-mail e senha.
- O sistema valida as informações fornecidas e cria uma conta de usuário.
- O usuário recebe uma confirmação de registro.

### Login de Usuário:

#### Descrição: 
Um usuário autentica-se na plataforma usando suas credenciais.
#### Fluxo:
- O usuário acessa a página de login e fornece seu e-mail e senha.
- O sistema verifica as credenciais e autentica o usuário.
- O usuário é redirecionado para a página inicial da plataforma.

### Pesquisar Restaurantes:

#### Descrição: 
Um usuário procura restaurantes com base em sua localização ou critérios específicos.
#### Fluxo:
- O usuário acessa a página de pesquisa de restaurantes.
- O usuário insere sua localização ou critérios de pesquisa, como tipo de cozinha ou nome do restaurante.
- O sistema exibe uma lista de restaurantes que correspondem aos critérios de pesquisa.

### Visualizar Detalhes do Restaurante:

#### Descrição: 
Um usuário visualiza informações detalhadas sobre um restaurante específico.
#### Fluxo:
- O usuário seleciona um restaurante na lista de resultados da pesquisa.
- O sistema exibe informações sobre o restaurante, como nome, endereço, horários de funcionamento, avaliações e menu.

### Adicionar Item ao Pedido:

#### Descrição: 
Um usuário seleciona itens de menu de um restaurante e os adiciona ao seu pedido.
#### Fluxo:
- O usuário navega pelo menu do restaurante e seleciona os itens desejados.
- O sistema permite ao usuário personalizar os itens, como escolher opções adicionais ou especificar observações.
- O usuário adiciona os itens personalizados ao seu pedido.

### Fazer Pedido:

#### Descrição: 
Um usuário revisa seu pedido, fornece detalhes de entrega e confirma a finalização do pedido.
#### Fluxo:
- O usuário visualiza o resumo do seu pedido, incluindo os itens selecionados, preços e total.
- O usuário fornece detalhes de entrega, como endereço e horário desejado.
- O usuário confirma o pedido e o sistema registra o pedido com um status inicial.

### Rastrear Pedido:

#### Descrição: 
Um usuário acompanha o status do seu pedido em tempo real.
#### Fluxo:
- O usuário acessa a página de rastreamento de pedidos.
- O sistema exibe o status atual do pedido, como "em preparação", "em rota" ou "entregue".
- O sistema atualiza o status do pedido à medida que ele progride no processo de entrega.

### Cancelar Pedido:

#### Descrição: 
Um usuário solicita o cancelamento de um pedido antes que ele seja entregue.
#### Fluxo:
- O usuário acessa a página de histórico de pedidos.
- O usuário seleciona o pedido desejado.
- O usuário solicita o cancelamento do pedido.
- O sistema verifica se o pedido pode ser cancelado com base nas políticas de cancelamento.
- Se o cancelamento for permitido, o sistema atualiza o status do pedido para "cancelado".

### Gerenciamento de Pedidos do Restaurante:

#### Descrição: 
O restaurante gerencia os pedidos recebidos e atualiza seu status.
#### Fluxo:
- O restaurante recebe uma notificação sobre um novo pedido.
- O restaurante acessa a plataforma e visualiza os detalhes do pedido.
- O restaurante atualiza o status do pedido para "confirmado", "em preparação", "em rota" ou "entregue".
- O sistema notifica o usuário sobre as atualizações de status do pedido.

### Avaliar Restaurante:

#### Descrição: 
Um usuário deixa uma avaliação e feedback sobre a experiência com o restaurante.
#### Fluxo:
- O usuário acessa a página de histórico de pedidos.
- O usuário seleciona o pedido concluído para o qual deseja deixar uma avaliação.
- O usuário atribui uma classificação e escreve um comentário opcional sobre o restaurante e a experiência geral.
- O sistema registra a avaliação e a associa ao restaurante correspondente.

Esses são apenas alguns casos de uso comuns para um marketplace de comida usando o Spring Boot em Java. Lembre-se de que você pode adaptar esses casos de uso para atender às necessidades específicas do seu projeto, adicionando ou removendo funcionalidades conforme necessário.

## TODO: 
- Segurança
