package com.meier.marina.library;

public class EmptySizeException extends RuntimeException {
    public EmptySizeException() {
        super("Size of images is 0 !");
    }
}
