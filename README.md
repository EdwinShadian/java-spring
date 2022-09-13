## Rest-сервис на Java Spring

### Что это?
****
REST-сервис по хранению логов в БД.
Позволяет оперировать логами в json формате.

#### Использовавшиеся технологии:
1. Java 18
2. Maven
3. Spring Boot
4. Spring JPA
5. Liquidbase
6. PostgreSQL
7. Adminer
8. Docker и Docker Compose

#### Лог имеет поля:
1. level - уровень лога
2. message - сообщение лога
3. context - дополнительная информация в виде строки в json формате

### Описание роутов
****
**GET /logs** - получить все логи, хранящиеся в базе в виде массива json объектов

**POST /logs** - добавить новый лог в формате json

**GET /logs/{id}** - получить один лог по его id. Выбрасывает исключение, если лог не найден.

**PUT /logs/{id}** - обновить информацию лога по его id

**DELETE /logs/{id}** - удалить лог по id. Выбрасывает исключение, если лог не найден.

### Как запустить локально?
****
1. Спуллить себе проект с гитхаб:
```shell
git pull https://github.com/EdwinShadian/java-spring.git
```
2. Перейти в директорию проекта:
```shell
cd ./java-spring
```
3. Запустить сборку проекта в docker-compose:
```shell
docker-compose up -d --build
```
Docker сам соберет jar, образ и поднимет сеть для работы

**Сервис будет доступен на [http://localhost:8080](http://localhost:8080).**

**Для управления базой данных через интерфейс в состав docker-compose включен контейнер Adminer, 
доступный на [http://localhost:8000](http://localhost:8000).**