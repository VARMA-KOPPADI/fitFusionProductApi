package com.fitFusion.productsApi.exception;

public class NoProductsFoundException extends RuntimeException{
    public NoProductsFoundException(){

    }
    public NoProductsFoundException(String s){
        super(s);
    }
}
