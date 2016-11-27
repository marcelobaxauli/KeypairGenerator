# Keypair Generator

Gera o par de chaves para ser usado pelos nós na rede para assinar digitalmente as mensagens.

## Execução

Para executar o programa primeiramente faça o build do mesmo na raiz do projeto

~~~ sh
$ mvn clean install 
~~~

Depois rode o Jar autoexecutavel

~~~ sh
$ java -jar target/keypair-generator-exec-1.0-SNAPSHOT.jar
~~~

Após execução, o par de chaves pública e privada serão criadas no path atual.
