package com.gw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static List<Bill> billList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    //类加载的时候第一时间执行，在billList中初始化数据
    static{
        billList.add(new Bill("吃饭", "交行", "支出", 247.0, "2020-1-2", "家庭聚餐"));
        billList.add(new Bill("吃饭", "工行", "支出", 158.0, "2021-5-2", "家庭聚餐"));
        billList.add(new Bill("工资", "交行", "收入", 5000.0, "2020-3-2", "开工资"));
        billList.add(new Bill("股票", "现金", "收入", 8000.0, "2021-3-2", "股票大涨"));
        billList.add(new Bill("礼金", "交行", "支出", 500.0, "2020-1-1", "朋友结婚"));
        billList.add(new Bill("吃饭", "交行", "支出", 380.0, "2021-12-2", "牛排"));
        billList.add(new Bill("交通", "交行", "支出", 200.0, "2020-12-31", "公交地铁"));
    }

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        menu();

        boolean flag = true;
        while (true) {
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("添加账务");
                    addBill();
                    break;
                case 2:
                    System.out.println("删除帐务");
                    delBill();
                    break;
                case 3:
                    System.out.println("查询账务");
                    select();
                    break;
                case 4:
//                    flag = false;
//                    break;
                    System.out.println("退出系统");
                    return;
                //输入的其他情况执行
                default:
                    System.out.println("请重新输入：");
            }
        }
//        System.out.println("退出系统");
    }

    private static void delBill() {
        System.out.println("请输入删除账务的id：");
        int i = scanner.nextInt();
        billList.remove(i-1);
    }

    private static void addBill() {
        Bill bill = new Bill();

        System.out.println("请输入类别：");
        bill.setName(scanner.next());
        System.out.println("请输入账户：");
        bill.setAccount(scanner.next());
        System.out.println("请输入支出收入类型：");
        bill.setType(scanner.next());
        System.out.println("请输入金额：");
        bill.setTotal(scanner.nextDouble());
        System.out.println("请输入时间：");
        bill.setTime(scanner.next());
        System.out.println("请输入备注：");
        bill.setDesc(scanner.next());

        billList.add(bill);
        System.out.println("添加账务成功！！");
    }

    private static void menu() {
        System.out.println("------------随手记-----------");
        System.out.println("1.添加账务 2.删除帐务 3.查询账务 4.退出系统");
        System.out.println("请输入功能序号【1-4】：");
    }

    private static void select() {
        System.out.println("1.查询全部 2.按支出收入类型查询 3.按时间范围查询");
        System.out.println("---------请输入功能序号------------");
        int op = scanner.nextInt();
        switch (op) {
            case 1:
                System.out.println("查询全部");
                selectAll();
                break;
            case 2:
                System.out.println("支出收入");
                selectType();
                break;
            case 3:
                System.out.println("时间范围");
                selectTime();
                break;
            default:
                System.out.println("请重新输入：");
        }
        menu();
    }

    private static void selectTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("请输入开始时间：");
        String start = scanner.next();
        System.out.println("请输入结束时间：");
        String end = scanner.next();
        List<Bill> bills = billList.stream().filter(bill -> {
            String time = bill.getTime();
            try {
                Date startDate = format.parse(start);
                Date endDate = format.parse(end);
                Date timeDate = format.parse(time);
                if (timeDate.after(startDate) && timeDate.before(endDate)) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;

        }).toList();
        System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            System.out.print(i+1);
            System.out.println(bill);
        }
    }

    private static void selectType() {
        System.out.println("请输入查询支出收入类型：");
        String type = scanner.next();
        System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
        List<Bill> billList1 = billList.stream().filter(bill -> {
            return bill.getType().equals(type);
        }).toList();
        for (int i = 0; i < billList1.size(); i++) {
            Bill bill = billList1.get(i);
            System.out.print(i+1);
            System.out.println(bill);
        }
    }

    private static void selectAll() {
        System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
        for (int i = 0; i < billList.size(); i++) {
            Bill bill = billList.get(i);
            System.out.print(i+1);
            System.out.println(bill);
        }
    }
}
