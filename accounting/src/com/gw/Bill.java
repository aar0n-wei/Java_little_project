package com.gw;

/**
 * ID   类别  账户  类型  金额  时间  备注
 */
public class Bill {

    private String name;
    private String account;
    //支出、收入
    private String type;
    private Double total;
    private String time;
    private String desc;

    @Override
    public String toString() {
        return ("\t\t" + name + "\t\t\t" + account + "\t\t" + type + "\t\t" + total + "\t\t" + time + "\t\t" + desc);
    }

    public Bill(String name, String account, String type, Double total, String time, String desc) {
        this.name = name;
        this.account = account;
        this.type = type;
        this.total = total;
        this.time = time;
        this.desc = desc;
    }

    public Bill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
