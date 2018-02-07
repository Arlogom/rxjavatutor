package com.gft.tutorial;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by also on 30/11/2016.
 */
//This is supposed to be only available on Valiadted Development Branch
public class BufferExample {

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

        Func1<List<String>, String> conversor = new Func1<List<String>, String>() {
            public String call(List<String> listOfStrings) {
                String newStr = new String();
                for (String str: listOfStrings){
                    newStr = newStr + str.toUpperCase() + "_";
                }
                return newStr;
            }
        };

        Observable.from(list).buffer(2).map(conversor).subscribe(subscriber);
    }
}
