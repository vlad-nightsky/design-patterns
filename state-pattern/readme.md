## Паттерн состояние | State Pattern

Паттерн состояние управляет изменением поведения объекта при изменении его внутреннего состояния.
Внешне это выглядит так, словно объект меняет свой класс.

Для этого паттерна объявляется общий интерфейс состояние (`State`).
Все состояния наследуются от этого интерфейса, а следовательно становятся взаимозаменяемыми.

Объявляется `Context` - класс с несколькими внутренними состояниями.
Действия c `Context` делегируются объектам состояний для обработки.

Классы состояний обрабатывают запросы от `Context`.
Каждый класс предоставляет свою реализацию запроса.
Таким образом при изменении состояния, меняется и поведение.