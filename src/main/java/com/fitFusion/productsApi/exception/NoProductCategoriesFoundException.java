package com.fitFusion.productsApi.exception;

public class NoProductCategoriesFoundException extends RuntimeException{
    public NoProductCategoriesFoundException(){

    }
    public NoProductCategoriesFoundException (String s){
        super(s);
    }
}
