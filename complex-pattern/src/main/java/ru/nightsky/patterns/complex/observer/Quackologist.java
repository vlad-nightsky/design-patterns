package ru.nightsky.patterns.complex.observer;

public class Quackologist implements Observer{
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Крякологист: "+ duck + " только что крякнул");
    }
}
