package com.fesine.payment.po;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/26
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/26
 */
public class Balance {
    private int id;
    private int diamond;
    private int ticket;
    private String message;

    public Balance() {
    }

    public Balance(int id, int diamond, int ticket) {
        this(id, diamond, ticket, "OK");
    }

    public Balance(int id, int diamond, int ticket, String message) {
        this.id = id;
        this.diamond = diamond;
        this.ticket = ticket;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
