Телеграм-бот, который помогает планировать путешествия. Сервис позволяет запрашивать данные к ценам по авиабилетам, сохранять данные по выбранным направлениям. Также сервис позволяет добавлять событие перелета для конкретного пользователя и учитывать уже существующие перелеты. В идеале - будет позволять заказывать билеты.
В проекте используется travelpayouts pubilc API.

Проект многомодульный, построен на микровервисном взимодействии (РЕСТ). На настоящий момент, функционал не совершенен и его еще нужно допиливать (см. todo). 
Главные модулеи - это Бот, Сеарчер и Байер. Дто как вспомогательный.

Начинается все с команд в боте, на настоящий момент главное что можно сделать - это показывать билеты и сохранять их. Плюс опционально делать выборки города/страны/аэропорты.
Показ идет через сервис в соответствующий контроллер (модуль Сеарчер) и ловит данные в стороннем АПИ, возвращая в конечном итоге данные в ТГ. Дополнительно работает со своей БД (флайвей), чтобы не ходить в нее лишнее количество раз.
Далее эти билеты и данные юзера можно сохранять в отдельную БД, чтобы работать с ними.

searcher: run postgres on port 5433 (docker container)
```docker run -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=flightsearcher -p5433:5432 -d --name otus_flightsearcher postgres:latest```
Важно: для запуска нужно убедиться что порты выставлены верно.


![изображение](https://user-images.githubusercontent.com/25296074/204279880-32739265-f153-4843-92ad-ad45b3db6c93.png)

ToDo:

0. Групайди, вынос всех зависимостей
1. проверить нормальную сохранность данных в Н2 (+посмотреть в идеи и консоле)
2. сеарч по данным - посмотреть как работает эксчендж
3. разобраться с мелкими ошибками в идее 
4. разобраться с датой и как она обрабатывается (сейчас - никак)
5. "поискать билеты"
6. допилить (переделать на свитч-кейс мейн блок в боте), + добавить туда 5 и "показать аэропорты" (и показать страны не работало вроде?)
7. перелопатить проект - особенно бот мне не нравились методы и как ноо организовано
8. подключить валидацию данных (контроллеры преждме всего)
9. причесать проект
- а. посмортеть респонс от пэйаута (как я в контроллере - хендлере - так же)
- б. посмотреть неверные данные от АЙДИ (не уверн что я тут выписал, как идею, надо посмотреть)
- в. подумать насчет проверок одинаковых билетов (тут прям... не знаю)
- г. (срочно) хардкод в пути где + 
- д. (менее срочно) - голый токен бота в ямле 
- е. (срочно!) дата захардкожена
