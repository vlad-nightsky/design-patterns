package ru.nightsky.patterns.proxy.danamicProxy;

import ru.nightsky.patterns.proxy.danamicProxy.handler.NonOwnerInvocationHandler;
import ru.nightsky.patterns.proxy.danamicProxy.handler.OwnerInvocationHandler;
import ru.nightsky.patterns.proxy.danamicProxy.person.PersonBean;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    /* Метод получает реальный объект (данные конкретного человека)
    и возвращает для него заместителя. Так как заместитель обладает
    тем же интерфейсом, что и реальный объект, мы возвращаем PersonBean
     */
    static PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    static PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }
}
