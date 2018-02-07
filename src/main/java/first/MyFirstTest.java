package first;

import data.TestData;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by maangel on 03/11/2016.
 */
public class MyFirstTest {

    public static void main(String[] args) {

        /*Observable.from(TestData.words).filter(new Func1<String, Boolean>() {
                public Boolean call(String s) {
                    return s.contains("a");
                }
            }).subscribe(new Action1<String>() {
                public void call(String s) {
                    System.out.println("word = " + s);
                }
        });*/

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Observable.empty().subscribe(new Action1<Object>() {
            public void call(Object o) {
                System.out.println("Emtpy observable!!! " + o.toString());
            }
        });

        Observable.just("Kirk Hammet").subscribe(new Action1<Object>() {
            public void call(Object o) {
                System.out.println("One element observable!!! " + o.toString());
            }
        });

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Subscriber subscriber = new Subscriber() {
            public void onCompleted() {
                System.out.println("Completed!!!");
            }

            public void onError(Throwable e) {
                System.out.println("Error!!!");
            }

            public void onNext(Object o) {
                System.out.println("El objeto actual es ... " + o.toString());
                System.out.println("Next!!!");
            }
        };

        Observable.from(Arrays.asList("Juan", "Perico", "Andres")).filter(new Func1<String, Boolean>() {
            public Boolean call(String s) {
                System.out.println("Filtrando ...");
                return s.contains("n");
            }
        }).subscribe(subscriber);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        ConnectableObservable connectableObservable = Observable.just("Kirk Hammet").publish();

        Subscriber subscriberA = new Subscriber() {
            public void onCompleted() {
                System.out.println("A - Completed!!!");
            }

            public void onError(Throwable e) {
                System.out.println("A - Error!!!");
            }

            public void onNext(Object o) {
                String s = (String) o;
                System.out.println(s.toLowerCase());
                System.out.println("A - Next!!!");
            }
        };
        connectableObservable.subscribe(subscriberA);

        Subscriber subscriberB = new Subscriber() {
            public void onCompleted() {
                System.out.println("B - Completed!!!");
            }

            public void onError(Throwable e) {
                System.out.println("B - Error!!!");
            }

            public void onNext(Object o) {
                String s = (String) o;
                System.out.println(s.toUpperCase());
                System.out.println("B - Next!!!");
            }
        };
        connectableObservable.subscribe(subscriberB);
        connectableObservable.connect();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Observable.from(Arrays.asList("Juan", "Perico", "Andres")).forEach(new Action1<String>() {
            public void call(String s) {
                System.out.println("s = " + s);
            }
        });
    }
}
