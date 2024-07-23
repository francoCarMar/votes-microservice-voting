package com.spring.votingsystem.exceptions;

public class ExistVoteRegistryException extends RuntimeException{
    public ExistVoteRegistryException() {
        super("Usuario ya ha votado");
    }
}
