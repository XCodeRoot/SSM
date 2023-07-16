package com.atguigu.spring.service;

public interface CheckOutService  {
    //结账
    void check(Integer userId, Integer[] bookIds);
}
