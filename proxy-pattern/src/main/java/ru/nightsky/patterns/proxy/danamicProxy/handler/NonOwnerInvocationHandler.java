package ru.nightsky.patterns.proxy.danamicProxy.handler;

import ru.nightsky.patterns.proxy.danamicProxy.person.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Класс предоставляет защищённый доступ к классу person
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    //Передаём реальный объект и сохраняем ссылку на него
    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    //при каждом вызове метода заместителя вызываеться метод invoke
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try{
        if(method.getName().startsWith("get"))//доступ ко всем геторам открыт
            return method.invoke(person, args);
        else if(method.getName().equals("setHotOrNotRating"))//вот рейтинг другой может ставить
            return method.invoke(person, args);
        else if(method.getName().startsWith("set"))//а инфу менять не может
            throw new IllegalAccessException();
        }catch (InvocationTargetException e){//в случае если реальный объект выкинет ошибку
            e.printStackTrace();
        }

        //при вызове любого другого метода мы возвращаем ноль чтобы не рисковать
        return null;
    }
}
