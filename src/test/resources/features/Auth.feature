#language:ru

Функциональность: Авторизация

  # пример теста с одним набором параметров
  Сценарий: : Авторизация в личном кабинете  и перевод с карты на карту (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    Когда пользователь вводит проверочный код 'из смс' "12345"
    Когда пользователь выбирает первую карту для пополнения
    Когда пользователь указывает "5000" рублей и счет списания
    Тогда баланс его первой карты из списка на главной странице должен стать "15000" рублей

