## INSTRUÇÕES PARA API JOGO CARTAS ##

Para executar a api basta ter o java jre 8 ou superior instalado. No target do projeto já existe um .jar compilado pronto para teste.
Para executá-lo basta acessar o diretório target do projeto e rodar:

$> java -jar cartas-0.0.1-SNAPSHOT.jar

O servidor irá rodar em http://localhost:8080 que é o padrão.

# END-POINTS

GET  http://localhost:8080/cartas    - Lista todas as cartas cadastradas

GET  http://localhost:8080/cartas/id - Retorna a carta pesquisada pelo ID

POST http://localhost:8080/cartas    - Inserir carta passando no corpo da 
					requisição o seguinte formato:

	{
    	"nome": "Rainha de Copas",
    	"descricao": "Segunda carta jogo",
    	"ataque": 2,
    	"defesa": 2,
    	"tipo": 1,
    	"classe": 2
	}

PUT http://localhost:8080/cartas/id - Atualiza carta com ID específico
					passando os dados no corpo da requisição:
	{
        "nome": "Rainha de Copas",
        "descricao": "Segunda carta jogo",
        "ataque": 2,
        "defesa": 2,
        "tipo": 1,
        "classe": 2
        }


DELETE  http://localhost:8080/cartas/2 - Exclui carta com id específico


OBS:
	Na raiz do repositório encontra-se uma collection para teste no postman
	em json.






