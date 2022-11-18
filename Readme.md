Телеграм-бот, который помогает планировать путешествия. Сервис позволяет запрашивать данные к ценам по авиабилетам, сохранять данные по выбранным направлениям. Также сервис позволяет добавлять событие перелета для конкретного пользователя и учитывать уже существующие перелеты.
В проекте используется travelpayouts pubilc API.

searcher: run postgres on port 5433 (docker container)
```docker run -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=flightsearcher -p5433:5432 -d --name otus_flightsearcher postgres:latest```