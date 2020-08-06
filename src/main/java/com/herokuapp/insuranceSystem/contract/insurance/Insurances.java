package com.herokuapp.insuranceSystem.contract.insurance;

public enum Insurances {
    ACCIDENT,
    TRAVEL,
    APARTMENT,
    HOME;


    private char toUpper(final char character) {
        return (char) ((int) character - 32); // in ascii table is difference between Upper and Lower 32.
    }

    private char toSmaller(final char character) {
        return (char) ((int) character + 32); // in ascii table is difference between Upper and Lower 32.
    }

    public String toWord() {
        String insurance = "" + this.name().charAt(0);
        for (int i = 1; i < this.name().length(); i++) {
            insurance += toSmaller(this.name().charAt(i));
        }
        return insurance;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
