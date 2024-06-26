# API
API - application program interface
Интерфейсы представляют собой контракты, определяющие, как две системы должны взаимодействовать.

API - это особые интерфейсы, которые определяют правила взаимодействия двух компьютерных систем.

Реализуются в виде библиотек и веб-API.

Веб-API - предоставляют функциональность по сети, 
скрывая конкретную реализацию или вычислительные требования, необходимые для выполнения.

Ресурсно-ориентированные API - это способ проектирования программных интерфейсов, 
позволяющие снизить сложность за счет использования стандартного набора действий, называемого _методами_, среди ограниченного набора компонентов, называемых _ресурсами._

## Примеры качественных веб-API:

- [stripe](https://docs.stripe.com/api)
- [yoomoney](https://yoomoney.ru/page?id=524892)

# API-First

> API-first — это подход к разработке программного обеспечения, основанный на API.   
> Должна быть возможность выполнять каждое действие с помощью API. 
> Функциональности должна быть доступна для использования другими системами.

1. Ваш API — это продукт
2. Фундаментальный дизайн, а не специальная модернизация.  
   > Проектирование, ориентированное на API, требует от разработчиков думать об API с самого начала.
3. Сотрудничество и влияние
   > Это способ работы и сотрудничества. 
   > Вместо того, чтобы просто интересоваться спецификацией каждого API, 
   > подход «API-first» больше ориентирован на ваши команды и операции, связанные с этими API.
4. API-first поддерживает микросервисы
   > В мире разработки наблюдается огромное стремление к повторному использованию. Подобно тому, как автопроизводители используют стандартные детали, компании отходят от платформ «все в одном» к компонентам многократного использования.
5. Контракт API
   > Качественный API сделать не просто.
   > Нужно хорошо подумать, узнать лучшие практики,
   > Исследовать потребности клиентов твоего API. 
   > Взаимодействовать с потребителями и улучшать API своего продукта. 

# Качество API

Хороший API обычно отличается

- функциональностью
  - система функциональна и делает то, что пользователю нужно. 
- варазительностью
  - система предоставляет интерфейс, который позволяет выражать пользователям свои намерения просто и ясно
- простотой
  - Вместо одного универсального интерфейса (RPC), API стремиться раскрывать нужную функциональность пользователям доступно.
    > Помни про interface segregation principle - много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения
  - делай обработку стандартного случая быстрой
- предсказуемостью
  - API, которые опираются на повторяющиеся и предсказуемые паттерны (согласованное именование полей), 
    применяемые и к внешнему определению API и к его поведению, проще и быстрее освоить, а значит они лучше.

## Предсказуемость и простота
- Используйте описательные и последовательные соглашения об именах.
- Именуйте части адреса (DTO, Events) так, чтобы не допускать двусмысленного восприятия. Смысл выполняемого действия должен быть понятен из адреса.
- Следует отделять действия от ресурсов, это повысит читаемость и удобство использования
  Например:
   - В REST - один ресурс это один путь и использование http методов как действий
   - Для взаимодействия через очереди можно в наименовании очередей использовать имена ресурсов, а в теле сообщения описание действия
- Используйте логически структурированные адреса - /сад/1/яблоня/10/яблоко/12/черенок/1
- Минимизируйте объем передаваемых данных, передавайте только то, что непосредственно необходимо
- Не забывайте о идемпотентности

## Поддерживаемость
- Описывайте ваши API используя подход Документация как код (OpenAPI, AsyncAPI)
- Обязательно версионируйте API, это позволит вам поддерживать обратную совместимость и безболезненно модифицировать API
- Поддерживайте обратную совместимость:
   - не допускайте изменений адресов, переименования или удаления параметров
   - новые или модифицированные методы добавляйте в новую версию
   - позволяйте клиентам самостоятельно мигрировать на новые версии
   - продолжайте поддержку старых версий в течении разумного срока, опираясь на количество их пользователей
- Оптимизируйте полезные данные запросов и ответов, включая только необходимые данные
- Разумно выбирайте параметры и их типы данных в соответствии с ресурсами
- Тщательно проверяйте точность ответов, предоставляя точные коды состояния HTTP

# REST API лучшие практики

1. Используйте рекомендуемые соглашения об именах endpoint-ов
2. Используйте подходящий метод HTTP

  - GET запросы используются для получения ресурсов.
  - PUT запросы обычно используются для создания или замены ресурсов  
  - POST запросы подходят для создания ресурсов, когда сервер присваивает уникальный идентификатор  
  - PATCH запросы допускают частичное обновление ресурсов  
  - DELETE запросы, как следует из названия, удаляют указанный ресурс  

> Что делаем, если передаем ПДН?

POST

>Что делаем если данные в запросе кешируются proxy?

timestamp в ответе, POST
``` client
{
  "id" : "uuid",
  "updateDate" : 1715874463, timestamp utc
  
}
```

## Нэйминг

Получение списка клиентов: GET /api/clients/  
Получение информации о клиенте: GET /api/clients/{id}  
Создать клиента продукта: POST /api/clients  
Обновить данные о клиенте: PUT /api/clients/{id}  
Удалить информация о клиенте: DELETE /api/clients/{id}  

3. Эффективно управляйте запросами и ответами REST API

После того как вы спроектировали API, необходимо эффективно управлять запросами и ответами API.
Мониторинг.
Это обеспечит бесперебойную и безопасную работу пользователя и эффективную связь между клиентом и сервером.  

4. Когда использовать параметры, а когда параметры запроса

Параметры пути обычно используются для идентификации или получения определенного ресурса.
>/api/clients/{id}

Параметры запроса больше подходят для сортировки данных запроса. Вы также можете использовать его для фильтрации и нумерации страниц.
>/api/clients/?status=blocked

## Рекомендации и типы
TBD

# Альянс в который стоит вступить

MARCH

- **Microservices**: Отдельные части бизнес-функциональности, которые независимо разрабатываются, развертываются и управляются.
- **API-First**: Вся функциональность предоставляется через API.
- **Cloud Native**: SaaS(software as a service ), подход к разработке в облаках:
  - эластичное масштабирование и автоматическое обновление
  - требует знания [12 fqctor app](https://12factor.net/ru/) к разработке сервиса 
- **Headless**: Представление внешнего интерфейса отделено от внутренней логики и канала, языка программирования и в конечном итоге не зависит от платформы.

##

# Полезные ресурсы
 - API First
   - **Книга** [Паттерны проектирования API](https://www.piter.com/product/patterny-proektirovaniya-api)
   - [статья на хабр](https://habr.com/ru/articles/205560/)
   - [the 5 principles of api first development](https://www.algolia.com/blog/product/the-5-principles-of-api-first-development-and-what-does-api-first-even-mean/)
   - [api-principles architecture](https://schweizerischebundesbahnen.github.io/api-principles/architecture/)
   - [semver](https://semver.org/lang/ru/) 
   - [12 fаctor app](https://12factor.net/ru/)
