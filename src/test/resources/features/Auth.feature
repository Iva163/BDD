#language:ru

Функциональность: Авторизация

  # пример теста с одним набором параметров
  Сценарий: : Авторизация в личном кабинете  и перевод с карты на карту (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    Когда пользователь вводит проверочный код 'из смс' "12345"
    Когда пользователь выбирает 1 карту для пополнения
    Когда пользователь указывает 5000 рублей и счет списания "5559 0000 0000 0002"
    Тогда баланс его 1 карты из списка на главной странице должен стать 15000 рублей

