package com.register.model;

import com.register.model.base.BaseUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
    public static User dao = new User();
    //静态成员，调用成员方法，不用每次new一个新成员再调用

}
