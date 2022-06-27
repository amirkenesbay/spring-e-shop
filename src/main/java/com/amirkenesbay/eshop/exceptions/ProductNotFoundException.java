package com.amirkenesbay.eshop.exceptions;

public class ProductNotFoundException extends Throwable{
    public ProductNotFoundException(String message){
        super(message);
    }
}
