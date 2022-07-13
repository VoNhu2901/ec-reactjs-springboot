package com.example.assignment.utils;

import com.example.assignment.data.entities.ProductRate;

import java.util.Set;

public class Utils {

    //    JWT
    public static final String JWT_SECRET = "assignmentSecretKey";
    public static final long JWT_EXP = 86400000; // 24 * 60 * 60 * 1000

    //    Throw Message
    public static final Boolean PRODUCT_TRADING = true;
    public static final String CATEGORY_ACTIVE = "Active";
    public static final String CATEGORY_DEACTIVATE = "Deactive";
    public static final String PRODUCT_NOT_FOUND = "Product.not.found";
    public static final String NO_PRODUCT = "No.products.were.found";
    public static final String NO_CART = "No.product.in.cart";
    public static final String CREATE_ORDER = "Ordered.has.been.created";
    public static final String NO_ORDER = "No.order.founded.with.that.account";
    public static final String NO_ACCOUNT = "No.account.were.found";
    public static final String ACC_UPDATE = "Account.updated.successfully";
    public static final String ACC_DELETE = "Change.status.of.account.to.false";
    public static final String ACCOUNT_BLOCK = "Account.blocked";
    public static final String ACCOUNT_NOT_FOUND = "Account.not.found.or.wrong.username";
    public static final String WRONG_PASS = "Wrong.password";
    public static final String USERNAME_EXITS = "Username.already.exists";

    //    Operation Swagger
    public static final String CREATE_NEW = "Create.new.";
    public static final String LOGIN = "Login.";
    public static final String PUT = "Put.";
    public static final String PATCH = "Patch.";
    public static final String GET_LIST = "Get.list.";
    public static final String GET_ONE = "Get.one.by.id.";
    public static final String DELETE = "Delete.";
    public static final String NOT_FOUND = "Not.found.";
    public static final String SUCCESS = ".success";

    ///
    public static final String CATEGORY = "Category";
    public static final String CART = "Cart";
    public static final String PRODUCT_IMG = "Product.image";
    public static final String ORDER = "Order";
    public static final String PRODUCT = "Product";
    public static final String ACCOUNT = "Account";
    public static final String AUTH = "Authentication";


    public static double rate(Set<ProductRate> listRate) {
        double result = 0.0;
        if (listRate.isEmpty()) {
            return 0.0;
        }

        // calculate average of rate
        for(ProductRate rate: listRate){
            result += rate.getRate();
        }
        return result/listRate.size();
    }

}
