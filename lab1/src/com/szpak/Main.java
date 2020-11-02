package com.szpak;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Main {

    private static void collatz_sequence(int argument){
        while(argument != 1) {
            if (argument % 2 == 0) {
                argument /= 2;
            } else {
                argument = argument * 3 + 1;
            }
            System.out.println(argument);
        }
        System.out.println("Algorithm ended");
    }

    private static void find_max(double A,double B,double C,double D) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Map<Double, String> list_of_results = new TreeMap<Double, String>();
        List<String> list_of_operators = new ArrayList<String>(4);
        list_of_operators.add("*");
        list_of_operators.add("-");
        list_of_operators.add("+");
        list_of_operators.add("/");
        String statement = new String();
//        System.out.println(A");
        for(String first_operator : list_of_operators){
            for (String second_operator : list_of_operators){
                for (String third_operator : list_of_operators) {
                    statement = "((((";
                    statement += String.valueOf(A);
                    statement += ")";
                    statement += first_operator;
                    statement += "(";
                    statement += String.valueOf(B);
                    statement += "))";
                    statement += second_operator;
                    statement += "(";
                    statement += String.valueOf(C);
                    statement += "))";
                    statement += third_operator;
                    statement += "(";
                    statement += String.valueOf(D);
                    statement += "))";
                    System.out.println(statement);
                    Object result = engine.eval(statement);
                    System.out.println(result);
                    Double result_double = (Double)result;
                    list_of_results.put(Double.valueOf(result_double),statement);
                }
            }
        }
        System.out.println("Max value: "+ ((TreeMap<Double, String>) list_of_results).lastKey() + "   " + ((TreeMap<Double, String>) list_of_results).lastEntry());
    }


    public static void main(String[] args) throws ScriptException{
        System.out.print("Enter a positive natural number: ");
        Scanner scanner = new Scanner(System.in);
        int argument = scanner.nextInt();
        collatz_sequence(argument);
        Double A,B,C,D;
        System.out.print("Enter A: ");
        A = scanner.nextDouble();
        System.out.print("Enter B: ");
        B = scanner.nextDouble();
        System.out.print("Enter C: ");
        C = scanner.nextDouble();
        System.out.print("Enter D: ");
        D = scanner.nextDouble();
//        System.out.println(A + B + C + D);
        find_max(A,B,C,D);

    }
}
