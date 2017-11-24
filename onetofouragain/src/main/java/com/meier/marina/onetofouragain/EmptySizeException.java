package com.meier.marina.onetofouragain;

public class EmptySizeException extends RuntimeException {
    public EmptySizeException() {
        super("Size of images is 0 !");
    }
}
