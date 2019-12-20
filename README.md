# BusinessSolutionsLabTestApp

Вопросы:
1. Как организовать возможность смены стиля отображения карт?
2. Как открывать детализацию определенной карты по получению PUSH-уведомления?
3. Как минимальными изменениями в коде загружать данные с другого сервера (формат тот же)
4. Как при этом организовать кеширование для загружаемых данных?

Ответы:
1. Создать переменную, в которой будет хранится тип отображения карт. Сохранить её в shared preferences.
В адаптере списка карт переопределить метод getItemViewType, который будет отвечать за вариант отображения карты.
В зависимости от типа отображения присваивать необходимый шаблон в onCreateViewHolder
2. Создать сервис, работающий в фоне, наследующийся от FirebaseMessagingService.
При нажатии на пуш будет открываться приложение и во время открытия первой активити отлавливать диплинк, в котором есть
id карты, которую нужно открывать
3. Перезапустить REST-клиент с другим base url
4. Если данных много, можно хранить их в shared preferences. Если много - можно создать базу данных на устройстве и хранить
информацию. Для этого хорошо подходит Room
