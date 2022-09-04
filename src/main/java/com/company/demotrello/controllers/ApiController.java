package com.company.demotrello.controllers;

import lombok.RequiredArgsConstructor;

/**
 * @author ""
 * @since 22/08/22/09:24 (Monday)
 * spring-boot-features/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class ApiController<S> {
    protected static final String API = "/api";
    protected static final String VERSION = "/v1";
    protected static final String PATH = API + VERSION;
    protected final S service;

}
