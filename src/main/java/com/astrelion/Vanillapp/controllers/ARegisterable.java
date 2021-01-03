package com.astrelion.Vanillapp.controllers;

import org.bukkit.event.Listener;

public abstract class ARegisterable implements Listener
{
    /**
     * If this object has been registered yet
     */
    protected boolean registered = false;

    public abstract void register();
}
