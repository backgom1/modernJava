package learn.chapter2.quiz;

import learn.chapter2.MotionParameter;

import java.util.ArrayList;
import java.util.List;

import static learn.chapter2.MotionParameter.Color.GREEN;
import static learn.chapter2.MotionParameter.Color.RED;

public class QuizMotionParameter {
    public static void main(String[] args) {

        List<MotionParameter.Apple> initAppleList = new ArrayList<>();
        initAppleList.add(new MotionParameter.Apple(GREEN, 100));
        initAppleList.add(new MotionParameter.Apple(GREEN, 130));
        initAppleList.add(new MotionParameter.Apple(GREEN, 140));
        initAppleList.add(new MotionParameter.Apple(GREEN, 160));
        initAppleList.add(new MotionParameter.Apple(GREEN, 170));
        initAppleList.add(new MotionParameter.Apple(RED, 110));
        initAppleList.add(new MotionParameter.Apple(RED, 170));
        initAppleList.add(new MotionParameter.Apple(RED, 180));
        initAppleList.add(new MotionParameter.Apple(RED, 190));
        initAppleList.add(new MotionParameter.Apple(RED, 200));

        prettyPrintApple(initAppleList, new SimpleFormatter());

    }

    public interface AppleFormatter {
        String accept(MotionParameter.Apple a);
    }

    public static class AppleFancyFormatter implements AppleFormatter{

        @Override
        public String accept(MotionParameter.Apple a) {
            String sizeChk = a.getSize() > 150 ? "heavy " : "light ";
            return "A " + sizeChk + a.getColor() +" apple";
        }
    }


    public static class SimpleFormatter implements AppleFormatter{

        @Override
        public String accept(MotionParameter.Apple a) {
            return "An apple of "+ a.getSize() +"g";
        }
    }

    public static void prettyPrintApple (List<MotionParameter.Apple> inventory,AppleFormatter appleFormatter){
        for (MotionParameter.Apple apple : inventory) {
            String accept = appleFormatter.accept(apple);
            System.out.println(accept);
        }
    }

}
