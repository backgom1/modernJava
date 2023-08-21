package learn.chapter2;

import java.util.ArrayList;
import java.util.List;


import static learn.chapter2.MotionParameter.Color.RED;
import static learn.chapter2.MotionParameter.Color.GREEN;

public class MotionParameter {


    public static void main(String[] args) {
        List<Apple> initAppleList = new ArrayList<>();
        initAppleList.add(new Apple(GREEN, 100));
        initAppleList.add(new Apple(GREEN, 130));
        initAppleList.add(new Apple(GREEN, 140));
        initAppleList.add(new Apple(GREEN, 160));
        initAppleList.add(new Apple(GREEN, 170));
        initAppleList.add(new Apple(RED, 110));
        initAppleList.add(new Apple(RED, 170));
        initAppleList.add(new Apple(RED, 180));
        initAppleList.add(new Apple(RED, 190));
        initAppleList.add(new Apple(RED, 200));

//        List<Apple> greenApples = filterGreenApples(initAppleList);
        List<Apple> redApple = filterApplesByColor(initAppleList, RED);
        List<Apple> greenApple = filterApplesByColor(initAppleList, GREEN);
        List<Apple> size = filterApplesByWeight(initAppleList, 150);


//        List<Apple> apples = filterApples(initAppleList, new filterApplesByColorImpl(){
//            @Override
//            public boolean test(Apple apple) {
//                return  RED.equals(apple.getColor());
//            }
//        });
        List<Apple> result =
                filterApples(initAppleList, (Apple apple)->RED.equals(apple.getColor()));



    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int size) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getSize() > size) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
          if(applePredicate.test(apple)) result.add(apple);
        }
        return result;
    }

    public static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor()) &&
                    apple.getSize() > 150;
        }
    }

    public static class filterApplesByColorImpl implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor());
        }
    }

    public static class filterApplesByWeightImpl implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getSize() > 150;
        }

    }


    interface ApplePredicate {
        boolean test(Apple apple);
    }

    public enum Color {
        RED, GREEN
    }

    public static class Apple {


        private Color color;
        private int size;


        public Apple(Color color, int size) {
            this.color = color;
            this.size = size;
        }


        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}