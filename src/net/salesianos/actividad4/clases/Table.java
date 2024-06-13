package net.salesianos.actividad4.clases;

import java.io.Serializable;

public class Table  implements Serializable {
    private String color;
    private int legs;

    public Table(String color, int legs) {
        this.color = color;
        this.legs = legs;
    }


    @Override
    public String toString() {
        return "********************Mesa*********************" +
        "\nColor:" +  this.color + "\nNumero de patas:" +  this.legs ;
    }F
}
