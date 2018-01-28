package com.example.user.kinematicsolverv2;

/**
 * Created by user on 2018-01-27.
 */
import java.lang.Math;
import java.lang.Exception;
import java.lang.Throwable;


public class Calculation{

    public static double DisplacementA(double vi, double t, double a){
        return (vi * t + 0.5 * a * Math.pow(t, 2));
    }

    public static double FinalVelocityD(double vi, double a, double d){
        return (Math.sqrt(Math.pow(vi, 2) + 2 * a * d));
    }

    public static double FinalVelocityT(double vi, double t, double a){
        return (vi + a * t);
    }

    public static double DisplacementV(double vi, double vf, double t){
        return ((vi + vf)/2)*t;
    }

    public static double InitialVelocityT(double d, double a, double t){
        if((a == 0) && (t == 0)){
            return 0;
        }
        if(a == 0){
            return d/t;
        }
        else{
            return (d - 0.5 * a * Math.pow(t, 2))/t;
        }
    }

    public static double InitialVelocityD(double vf, double a, double d){
        return Math.sqrt(Math.pow(vf, 2) - 2 * a * d);
    }

    public static double TimeD(double vi, double d, double a){
        if(a == 0){
            return d/vi;
        }
        else{
            return (-vi + Math.sqrt(Math.pow(vi, 2) - (2 * a * d)))/a;
        }
    }

    public static double TimeA(double vf, double vi, double a){
              return (vf - vi)/a;
        }


    public static double AccelerationT(double vi, double d, double t) {



            return (d - vi * t)/(0.5 * Math.pow(t, 2));


    }

    public static double AccelerationVf(double vi, double vf, double t) {
           return (vf - vi)/t;


    }
}