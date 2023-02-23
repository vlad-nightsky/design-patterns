package ru.nightsky.patterns.proxy.danamicProxy.person;

/**
 * Имплементация пользователя, теперь мы хотим сделать этот объект защищенным.
 * Только пользователь может менять свои персональные данные.
 * А оценку должны менять только другие пользователи.
 */
public class PersonBeanImpl implements PersonBean {
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;

    public PersonBeanImpl(String name, String gender, String interests) {
        this.name = name;
        this.gender = gender;
        this.interests = interests;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) return 0;
        return (rating / ratingCount);
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}
