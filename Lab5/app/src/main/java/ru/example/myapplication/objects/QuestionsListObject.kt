package ru.example.myapplication.objects

import ru.example.myapplication.model.AnswerData
import ru.example.myapplication.model.QuestionData

// source - https://kupidonia.ru/viktoriny/viktorina-lisy

object QuestionsListObject {
    var questionsList = listOf<QuestionData>(
        QuestionData(
            "В каком городе лисицы живут на окраинах и иногда появляются в центре?",
            listOf(
                AnswerData("Архангельск"),
                AnswerData("Тюмень"),
                AnswerData("Рим"),
                AnswerData("Лондон"),
            ),
            AnswerData("Архангельск"),
        ),
        QuestionData(
            "Сколько у лис лап?",
            listOf(
                AnswerData("1"),
                AnswerData("2"),
                AnswerData("3"),
                AnswerData("4"),
            ),
            AnswerData("4"),
        ),
        QuestionData(
            "К какому семейству относятся лисы?",
            listOf(
                AnswerData("Псовые"),
                AnswerData("Лисьи"),
                AnswerData("Волчьи"),
                AnswerData("Собачьи"),
            ),
            AnswerData("Псовые"),
        ),
        QuestionData(
            "Какой вид лисиц является самым крупным?",
            listOf(
                AnswerData("Африканская"),
                AnswerData("Обыкновенная"),
                AnswerData("Афганская"),
                AnswerData("Европейская"),
            ),
            AnswerData("Обыкновенная"),
        ),
        QuestionData(
            "Какого цвета лапы у обыкновенной лисицы?",
            listOf(
                AnswerData("Рыжие"),
                AnswerData("Белые"),
                AnswerData("Темные"),
                AnswerData("Коричневые"),
            ),
            AnswerData("Темные"),
        ),
        QuestionData(
            "На какое животное внешне и по поведению похожа афганская лисица?",
            listOf(
                AnswerData("Собака"),
                AnswerData("Кошка"),
                AnswerData("Волк"),
                AnswerData("Койот"),
            ),
            AnswerData("Кошка"),
        ),
        QuestionData(
            "Какой вид лисиц считается очен скрытным?",
            listOf(
                AnswerData("Африканская"),
                AnswerData("Бенгальская"),
                AnswerData("Песчаная"),
                AnswerData("Европейская"),
            ),
            AnswerData("Африканская"),
        ),
        QuestionData(
            "Какая лисица обитает в предгорьях Южных Гималаев?",
            listOf(
                AnswerData("Корсак"),
                AnswerData("Бенгальская"),
                AnswerData("Тибетская"),
                AnswerData("Европейская"),
            ),
            AnswerData("Бенгальская"),
        ),
        QuestionData(
            "Как называется самый маленький представитель семейства псовых?",
            listOf(
                AnswerData("Корсак"),
                AnswerData("Песчаная"),
                AnswerData("Тибетская"),
                AnswerData("Фенек"),
            ),
            AnswerData("Фенек"),
        ),
        QuestionData(
            "На какой монете изображен Фенек?",
            listOf(
                AnswerData("На алжирском дукате"),
                AnswerData("На байсе"),
                AnswerData("На миле"),
                AnswerData("На сольдо"),
            ),
            AnswerData("На алжирском дукате"),
        ),
        QuestionData(
            "Кто из перечисленных видов лисиц питается в основном термитами?",
            listOf(
                AnswerData("Большеухая"),
                AnswerData("Африканская"),
                AnswerData("Фенек"),
                AnswerData("Тибетская"),
            ),
            AnswerData("Большеухая"),
        ),
    )
}