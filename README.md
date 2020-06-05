# topic-exchange-rabbitmq-spring-boot

Este projeto contém é um produtor e um consumidor de mensagens para o Topic Exchange desenvolvido com o Spring Boot.

O projeto implementa criação de filas (queues), exchanges e bindings via cdigo da aplicação. Para criar um container RabbitMQ, você pode criar um arquivo e renomeá-lo-pra

docker-compose.yml
O conteúdo do arquivo pode ser:

version '3.7' 
    rabbitmq3-topic 
    image: rabbitmq:3-management
    ports:
        - 5673: 5672
        - 15673: 15672     

O arquivo deve ser executado com o comando:

docker-compose up

O projeto consiste em uma fila de transferências que serão processadas. Utilize o postman para enviar requisições do tipo POST para http://localhost:8083/topic

entrada: 
{
	"credito":{
		"cliente": "Isaac Newton",
	    "agencia": "1111-1",
	    "conta": "1111-1"
	},
	"debito":{
		"cliente": "Amadeus Mozart",
	    "agencia": "2222-2",
	    "conta": "2222-2"
	},
	"codigoTranferencia": 1,
    "valor": 1000.0,
    "horario": "10:30:00"
}


entrada: 
{
	"credito":{
		"cliente": "Isaac Newton",
	    "agencia": "1111-1",
	    "conta": "1111-1"
	},
	"debito":{
		"cliente": "Amadeus Mozart",
	    "agencia": "2222-2",
	    "conta": "2222-2"
	},
	"codigoTranferencia": 1,
    "valor": 10000000.0,
    "horario": "10:30:00"
}


entrada: 
{
	"credito":{
		"cliente": "Isaac Newton",
	    "agencia": "1111-1",
	    "conta": "1111-1"
	},
	"debito":{
		"cliente": "Amadeus Mozart",
	    "agencia": "2222-2",
	    "conta": "2222-2"
	},
	"codigoTranferencia": 1,
    "valor": 1000.0,
    "horario": "01:00:00"
}

Agora execute o projeto consumer. As requisições lidas pelo consumer serão impressas no console da sua IDE. As mensagens serão direcionadas para a fila correta através das routings keys. As requisições que tiverem um valor acima de 1.000.000 serão redirecionadas para a fila topi.valor.fraude, as trasferências feitas antes das 05h ou depois das 2h serão direcionadas para a fila topic.horario.fraude. Sempre que uma mensagem for direcionada para as filas topic.valor.fraude ou topic.horario.fraude Uma cópia dessa mensagem será enviada para a fila de topic.fraudes.
