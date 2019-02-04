# WeatherAppBackend

Sistema de cadastro de cidades e consulta sobre o clima da das cidades cadastradas

**Softwares necessários para rodar o projeto**

```
* MongoDB v4.0.5 [Download](https://www.mongodb.com/download-center/community
* após a instalação do MongoDB criar o repositório C:/data/db e adicionar a váriavel de ambiente PATH o seguinte caminho 
  "C:\Program Files\MongoDB\Server\4.0\bin"
* Eclipse v4.9.0 ou superior [Download](https://www.eclipse.org/downloads/)
```

**Processos para iniciar o projeto**
```
* Importar o projeto para seu repositório local
* Executar o Eclipse e importar o projeto para em File> Import> Maven> Existing Maven Projects> Seleciona o projeto> Finish
* Após a importação do projeto rodar o maven update (Alt+F5), selecionar o projeto e atualizar, esse processo baixará todas as dependências
* Abrir o prompt de comando e executar o seguinte comando: mongo. Manter esse terminal aberto
* Abrir um novo prompt de comando e executar o seguinte comando: mongod. Manter esse terminal aberto
* No eclipse, criar um Run Configuration no campo Project prencher com weather-app-backend e no campo Main class com.weather.api.WeatherAppBackendApplication
* Selecionar o projeto e executar com a configuração criada anteriormente
