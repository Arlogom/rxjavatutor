package com.gft.tutorial;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.Random;

/**
 * Created by also on 30/11/2016.
 */
public class FlatMap {

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

        Func1<String, Observable<?>> conversor = new Func1<String, Observable<?>>() {
            public Observable<?> call(String s) {
                if (s.contains("i")) {
                    return Observable.just(s.toUpperCase().concat("XXXXXX"));
                }else{
                    return Observable.just(new Integer(8));
                }
            }
        };

        Observable.from(list).flatMap(conversor).subscribe(subscriber);
    }
}
