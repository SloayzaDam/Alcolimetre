package com.alcoholimetro.indam.alcolimetrefree;

public class Countries
{
    private String name;
    private int icon;
    private double tasaPais;

    public Countries(String nombre, int icono, double tasa)
    {
        super();
        this.name = nombre;
        this.icon = icono;
        this.tasaPais = tasa;
    }

    public String getNombre()
    {
        return name;
    }

    public void setNombre(String nombre)
    {
        this.name = nombre;
    }

    public int getIcono()
    {
        return icon;
    }

    public void setIcono(int icono)
    {
        this.icon = icono;
    }

    public double getTasa() { return tasaPais;}

    public void setTasa(double tasa) {this.tasaPais = tasa;}

}
