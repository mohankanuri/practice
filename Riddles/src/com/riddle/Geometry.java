package com.riddle;

import java.util.Scanner;

public class Geometry {
	public static double cubeVolume(double h) {
		double Volume = (h*h*h);
		return Volume;
	}
	public static double cubeSurface(double h) {
		double SurfaceArea = (6*h*h);
		return SurfaceArea;
	}
	public static double sphereVolume(double r) {
		double Volume = ((4*Math.PI*r*r*r)/3);
		return Volume;
	}
	public static double sphereSurface(double r) {
		double SurfaceArea = (4*Math.PI*r*r); 
		return SurfaceArea;
	}
	public static double cylinderVolume(double r, double h) {
		double Volume = (Math.PI*r*r*h);
		return Volume;
	}
	public static double cylinderSurface(double r, double h) {
		double SurfaceArea = ((2*Math.PI*r*h)+(2*Math.PI*r*r));
		return SurfaceArea;
	}
	public static double coneVolume(double r, double h) {
		double Volume = (Math.PI*r*r*h)/3;
		return Volume;
	}
	public static double coneSurface(double r, double h) {
		double SurfaceArea = (Math.PI*r*(r + Math.sqrt((h*h)+(r*r))));
		return SurfaceArea;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the height,h: ");
		double h = in.nextDouble();
		System.out.println("Enter the radius,r: ");
		double r = in.nextDouble();
		Geometry obj = new Geometry();
		
		System.out.println("The surface Area of cube with height, " + h + " is: " +obj.cubeSurface(h) );
		System.out.println("The volume of cube with height, " + h + " is: " + obj.cubeVolume(h));
		
		System.out.println();
		
		System.out.println("The surface Area of sphere with radius, " + r + " is: " +obj.sphereSurface(r));
		System.out.println("The volume of cube with radius, " + r + " is: " + obj.sphereVolume(r));
		
		System.out.println();
		
		System.out.println("The surface Area of cylinder with height, " + h + " and radius, "+ r+ " is: " +obj.cylinderSurface(r, h));
		System.out.println("The Volume of cylinder with height, " + h+ " and radius, "+ r + " is: " + obj.cylinderVolume(r, h));
		
		System.out.println();
		
		System.out.println("The surface Area of cone with height, " + h + " and radius, "+ r+ " is: " +obj.coneSurface(r, h));
		System.out.println("The Volume of cone with height, " + h + " and radius, " + r + " is: " + obj.coneVolume(r, h));
		
			
	}
}
