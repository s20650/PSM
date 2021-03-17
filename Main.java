package com.company;
//Michal Okreglicki s20650 22c
public class Main{
    public static void main(String [] args){
        //w argumentach programu nalezy wpisac wartosc oraz po spacji S jak podajemy stopnie lub R jak podajemy radiany.
        if(args[1].equals("S")) {
            System.out.println("Wywołano program dla sinusa z " + args[0] + " stopni");
            dlaStopni(Double.parseDouble(args[0]));
        }
        if(args[1].equals("R")) {
            System.out.println("Wywołano program dla sinusa z " + args[0] + " radianow");
            dlaRadianow(Double.parseDouble(args[0]));
        }

    }

    public static void dlaStopni(double stopnie) {
        double radiany = skonwertujDoRadianow(stopnie);
        print(skonwertujDoPierwszejCwiartki(radiany));
    }

    public static void dlaRadianow(double radiany) {
        print(skonwertujDoPierwszejCwiartki(radiany));
    }

    public static double skonwertujDoRadianow(double stopnie) {
        return stopnie / 180.0 * Math.PI;
    }

    public static double skonwertujDoPierwszejCwiartki(double radiany)
    {
        radiany = radiany % (2*Math.PI);
        if(radiany<0)
            radiany = radiany + 2*Math.PI;

        if(radiany <= Math.PI /2 ) return radiany;
        if(radiany > Math.PI/2 && radiany<= Math.PI ) return Math.PI - radiany;
        if(radiany > Math.PI && radiany <= 3* Math.PI/2) return -radiany + Math.PI;
        return -2*Math.PI + radiany;
    }

    public static void print(double radiany)
    {
        int dokladnosc = 1;
        for (int i = 0; i <10 ; i++) {
            // System.out.println("Math.sin = " + Math.sin(radiany));
            // System.out.println("Sinus Taylorem	= " + TaylorSinus(radiany, dokladnosc));
            System.out.println("Wartosc bezwzgledna różnicy pomiedzy wynikami = " + Math.abs(Math.sin(radiany) - TaylorSinus(radiany, dokladnosc)));
            dokladnosc = dokladnosc + 2;
        }
    }
    public static  double TaylorSinus(double x , int dokladnosc)
    {

        int n = 3;
        double wartoscPotegi = x;
        double wartoscSilni = 1;
        double sin = x;
        int znak = -1;
        while(n<=dokladnosc)
        {
           wartoscPotegi = wartoscPotegi * x * x;
           wartoscSilni = wartoscSilni * (n-1) * n;
           sin = sin + znak * (wartoscPotegi / wartoscSilni);
           znak = znak * (-1);
           n = n + 2;
        }
        return sin;
    }
}
