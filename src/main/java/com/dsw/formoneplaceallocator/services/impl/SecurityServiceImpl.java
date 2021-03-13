package com.dsw.formoneplaceallocator.services.impl;

import com.dsw.formoneplaceallocator.services.iface.SecurityService;

public class SecurityServiceImpl implements SecurityService {
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }
}
