package com.example.demo.contract.insurance.nonLife;

public enum TypeOfRealEstate {
    FLAT, WOODEN_HOUSE, BRICK_HOUSE;


    private char toUpper(final char character) {
        return (char) ((int) character - 32); // in ascii table is difference between Upper and Lower 32.
    }

    private char toSmaller(final char character) {
        if (isSpace(character))
            return ' ';
        return (char) ((int) character + 32); // in ascii table is difference between Upper and Lower 32.
    }

    public String toWord() {
        String insurance = "" + this.name().charAt(0);
        for (int i = 1; i < this.name().length(); i++) {
            insurance += toSmaller(this.name().charAt(i));
        }
        return insurance;
    }

    private boolean isSpace(char character) {
        if (character == '_')
            return true;
        else {
            return false;
        }
    }
}
