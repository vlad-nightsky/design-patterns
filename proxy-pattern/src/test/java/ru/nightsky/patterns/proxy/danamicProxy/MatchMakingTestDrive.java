package ru.nightsky.patterns.proxy.danamicProxy;

import ru.nightsky.patterns.proxy.danamicProxy.person.PersonBean;
import ru.nightsky.patterns.proxy.danamicProxy.person.PersonBeanImpl;

import java.util.ArrayList;
import java.util.List;

public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    private List<PersonBean> database;

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        database = new ArrayList<>(1);
        database.add(new PersonBeanImpl("Вася Бин", "Мальчик", ""));
    }

    private void drive() {
        PersonBean vasya = getPersonFromDatabase("Вася Бин");
        PersonBean ownerProxy = ProxyFactory.getOwnerProxy(vasya);
        System.out.println("Имя " + ownerProxy.getName());
        ownerProxy.setInterests("Боулинг и язык Go");
        System.out.println("Поставил интерес через прокси");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
            System.out.println("Пользователь не может сам себе поставить оценку");
        }
        System.out.println("Рейтинг " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = ProxyFactory.getNonOwnerProxy(vasya);
        System.out.println("Имя " + nonOwnerProxy.getName());
        try{
            nonOwnerProxy.setInterests("Боулинг и язык Go");
        }catch (Exception e){
            System.out.println("Нельзя установить интерес для не владельцу");
        }
            nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Поставили рейтинг не владельцем");
        System.out.println("Рейтинг " + vasya.getHotOrNotRating());
    }

    private PersonBean getPersonFromDatabase(String search) {
        if (search == null)
            return null;
        return database
                .stream()
                .filter(person -> search.equals(person.getName()))
                .findAny()
                .orElse(null);
    }
}
