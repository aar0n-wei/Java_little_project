package com.gw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1、scanner.nextInt()可以让程序阻塞，等待用户输入
 * 2、while(true)配合scanner.nextInt()让程序循环监听
 */
public class DishApp {

    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> dishes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int num;

    public static void init() {
        Dish dish1 = new Dish(1, "油爆虾", 23.0);
        dishList.add(dish1);
        dishList.add(new Dish(2, "小炒肉", 25.0));
        dishList.add(new Dish(3, "红烧肉", 40.0));
        dishList.add(new Dish(4, "番茄炒蛋", 15.0));
    }

    public static void mainMenu() {
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t1");
        System.out.println("已点菜品\t\t2");
        System.out.println("买单\t\t\t3");
        System.out.println("----按0返回主菜单----");
        while (true) {
            num = scanner.nextInt();
            if (num == 0) {
                System.out.println("----主菜单----");
                System.out.println("菜单\t\t\t1");
                System.out.println("已点菜品\t\t2");
                System.out.println("买单\t\t\t3");
                System.out.println("----按0返回主菜单----");
            }
            if (num == 1) {
                menu();
            }
            if (num == 2) {
                for (Dish dish :
                        dishes) {
                    System.out.println(dish);
                }
            }
            if (num == 3) {
                Double bill=0.0;
                for (Dish dish :
                        dishes) {
                    bill = bill + dish.getPrice();
                }
                System.out.println("本次消费共："+bill);
            }
        }


    }

    public static void menu() {
        System.out.println("----请您点菜----");
        for (Dish dish :
                dishList) {
            System.out.println(dish.getId() + "  " + dish.getName() + "  " + dish.getPrice());
        }
        System.out.println("----序号点菜，按0返回主菜单----");
        while (true) {
            num = scanner.nextInt();
            if (num != 0) {
                for (Dish dish :
                        dishList) {
                    if (dish.getId() == num) {
                        dishes.add(dish);
                    }
                }
            }else{
                break;
            }
        }
        mainMenu();
    }


    public static void main(String[] args) {
        init();
        System.out.println(dishList);

        mainMenu();
    }
}
