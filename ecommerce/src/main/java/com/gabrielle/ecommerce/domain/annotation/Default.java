package com.gabrielle.ecommerce.domain.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.CONSTRUCTOR;

@Retention(RetentionPolicy.CLASS)
@Target(CONSTRUCTOR)
public @interface Default {}