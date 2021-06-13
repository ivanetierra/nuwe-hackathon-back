package com.nuwe.exceptions;


public class PlayerNotFoundException extends RuntimeException
{
    public PlayerNotFoundException(String id)
    {
        super("Could not find Player with ID: " + id);
    }
}
