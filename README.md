# sistemasDistribuidos-TR1

1) Faça um programa cliente/servidor multithread onde:
* O cliente leia o IP e a Porta que deva se conectar no servidor.
* O cliente envia três números ao servidor.
* O servidor recebe os números. Posteriormente, deve calcular o maior e o menor dos três.
* O servidor retorna mensagem para o cliente indicando qual o maior e qual o menor dos três.
* Se o primeiro número recebido pelo servidor for negativo, o mesmo deve ser finalizado.
* O cliente mostra a mensagem recebida do servidor na tela.

2) Faça um programa cliente/servidor multithread onde: 
* Tenha uma classe Quadrilatero com os seguintes atributos: lado1, lado2, lado3, lado4 e tipo do
quadrilatero. Esta classe deve ter os seguintes métodos:
-- ledados: que leia os atributos lado1, lado2, lado3 e lado4.
-- indicatipoquadrilatero: que indica o tipo do quadrilátero (retângulo, quadradro ou quadriátero) baseado nos valores dos lados. Depois atualiza o atributo tipo do quadrilátero.
-- mostradados: que mostre todos os dados do objeto.
* Cliente instancie objeto da classe Quadrilatero e leia os atributos do objeto.
* Cliente envia objeto para servidor.
* Servidor recebe objeto do cliente e chama método indicatipoquadrilatero.
* Servidor devolve objeto para o cliente.
* Cliente mostra os dados do objeto.

3) Faça um programa cliente/servidor multithread onde:
* O servidor funcione como um controle de estoque mantendo uma relação dos nomes dos produtos e das quantidades.
* O cliente envia para o servidor um nome e uma quantidade. Se o valor for positivo indica entrada no estoque e se for negativo indica saída do estoque.
* O servidor recebe os dados do cliente e procede da seguinte forma:
-- Se o nome do produto não existe ainda no cadastro, cadastrá-lo somente se for entrada no estoque. Caso contrário enviar mensagem para o cliente dizendo “produto inexistente”.
-- Se o produto existe realizar a operação de entrada ou saída no estoque, atualizando a quantidade e posteriormente enviando mensagem para o cliente dizendo “estoque atualizado e quantidade de -----”. Só realizar a operação de saída do estoque se a quantidade ficar maior ou igual a zero. Caso isto não seja possível, enviar mensagem para o cliente dizendo “não é possível fazer a saída de estoque – quantidade menor que o valor desejado”.
-- Se o nome do produto for “terminar” o servidor deve ser finalizado.

4) Fazer um programa cliente/servidor que faça um FTP, onde:
* Cliente pode escolher o diretório local e remoto.
* Cliente envia e recebe arquivo do servidor usando como base o diretório local e remoto corrente.
* Cliente pode executar comandos remotos.
