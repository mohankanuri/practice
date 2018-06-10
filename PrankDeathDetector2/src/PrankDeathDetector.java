import java.util.Scanner;
//import java.awt.*;
public class PrankDeathDetector {
public static void main(String[]arguments) {
Scanner input=new Scanner(System.in);


//NAME COLLECTION
System.out.println("Whats your name?and welcome to the Death Predector");
String name=input.next();
System.out.println(name+" Welcome to how your death will be..muhahahaha!!!");
System.out.println(name+" how old are you?");
int age=input.nextInt();
if(age<10) {
System.out.println(name+" Your too young");
}
else {
System.out.println(name+" Welcome to your death");
}
System.out.println("***************************************************");


//CONTINENT COLLECTOR
System.out.println(name+" What continent did your mum give birth to you?");
String country=input.next();
if(country.equals("africa")) {
System.out.println("Damn!!!thats a harsh place to grow up in");
}
if(country.equals("north america")) {
System.out.println("Wow,thats one great place to grow up in");
}
if(country.equals("asia")) {
System.out.println("Wow,thats one great place to grow up in");
}
if(country.equals("south america")) {
System.out.println("Wow,thats one great place to grow up in");
}
if(country.equals("austrilla")) {
System.out.println("Wow,thats one great place to grow up in");
}
System.out.println("***************************************************");


//DOB COLLECTOR
System.out.println(name+" What year did your mama give birth to you?");
Double DOB=input.nextDouble();
if(DOB==1997) {
System.out.println(name+" your gonna die of an autocrash!!!");
}
if(DOB==1998) {
System.out.println(name+" your gonna die on your way to work");
}
if(DOB==1999) {
System.out.println(name+" your gonna die of a natural death/sleep");
}
if(DOB==2000) {
System.out.println(name+" the devil longs for your soul");
}
if(DOB==2001) {
System.out.println(name+" your gonna die of food posining");
}
if(DOB==2002) {
System.out.println(name+" watch out for the cops your on their list");
}
if(DOB==2003) {
System.out.println(name+" you will die at the hospital");
}
if(DOB==2004) {
System.out.println(name+" you will die while going to school");
}
if(DOB==2005) {
System.out.println(name+" the buggyman wants your soul");
}
System.out.println("***************************************************");

//else {
// System.out.println("if your death wasent produced your either to old or too young for the death detector"+" maybe you dead already,muhahahahah!!!!");
//}


//OUTRO MESSAGE
System.out.println(name+" Thank you for using the Death Predector");
System.out.println("***************************************************");
/*System.out.println("Would you like to play again? (y/n)");
String answer=input.next();
while(answer.equals("y")) {
answer=input.next();*/
input.close();
}

}