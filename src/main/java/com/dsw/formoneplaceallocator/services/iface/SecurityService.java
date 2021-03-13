package com.dsw.formoneplaceallocator.services.iface;

public interface SecurityService {
    boolean authenticate(String username, String password);
}
