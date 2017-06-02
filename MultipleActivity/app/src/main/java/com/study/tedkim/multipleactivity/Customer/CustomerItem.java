package com.study.tedkim.multipleactivity.Customer;

/**
 * Created by tedkim on 2017. 5. 30..
 */

public class CustomerItem {

    String name;
    int age, customer_id;
    String address;
    String tel;

    public CustomerItem(){

        customer_id = 0;
        name = " ";
        age = 0;
        address = " ";
        tel = " ";
    }

    public int getCustomer_id(){
        return customer_id;
    }

    public void setCustomer_id(int id){
        this.customer_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
