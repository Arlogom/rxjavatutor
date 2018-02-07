package com.gft.tutorial;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * Created by also on 30/11/2016.
 */
public class FromExample {

    public static void main(String[] args) {
        String[] list = {"Durrant", "McCoist", "McStay", "Malpas", "Goram", "McKimmie", "Leighton", "McCall"};


        Subscriber subscriber = new Subscriber() {
            public void onCompleted() {
                System.out.println("Completed!!!");
            }

            public void onError(Throwable throwable) {
                System.out.println("Error!!!");
            }

            public void onNext(Object o) {
                System.out.println(o);
            }
        };


        Observable.from(list).subscribe(subscriber);
    }
}
