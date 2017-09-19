/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.util.*;
/**
 *
 * @author Stefan
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] testNumberSets = {
            {32,16},
            {672,3360},
            {145314,168468},
            {500,100},
            {500,10},
            {500,5},
            {36960,330960}
        };
        for (int i = 0; i < testNumberSets.length; i++) {
            int[] numbers = testNumberSets[i];
            System.out.printf("1. number: %d\n2. number: %d\n", numbers[0], numbers[1]);
            int primeResult = gcdPrimeFactors(numbers[0], numbers[1]);
            int eucledianResult = gcdEucledian(numbers[0], numbers[1]);
            System.out.printf("Prime: %d\nEuclidean: %d\n\n", primeResult, eucledianResult);
        }
    }
    
    public static int gcdEucledian(int a, int b){
        if(a == 0||b == 0)  //if both are zero
            return a+b;
        return gcdEucledian(b,a%b);
    }
    
    public static int gcdPrimeFactors(int a,int b){
        ArrayList<Integer> aPrimefactors = primeFactorization(a);
        ArrayList<Integer> bPrimefactors = primeFactorization(b);
        ArrayList<Integer> mutual = new ArrayList();
        
        //int indexToRemove = 0;
        for(int i = 0; i < aPrimefactors.size(); i++){
            int helper = aPrimefactors.get(i);
            if(bPrimefactors.contains(helper)){
                mutual.add(helper);
                bPrimefactors.remove(bPrimefactors.indexOf(helper));
            }
        }
        return mutual.stream().reduce(1,(m, n) -> m*n);
        //int result = 0; 
    }
    
    public static ArrayList<Integer> primeFactorization(int a){
        ArrayList<Integer> result = new ArrayList();
        int helper = 2;
        while(a > 1){
            if(a % helper == 0){
                result.add(helper);
                a /= helper;
            }else{
                do{
                    helper++;
                }while(!isPrime(helper));
            }
        }
        return result;
    }
    
    public static boolean isPrime(int a){
        for(int i = a/2; i < 1;i--){
            if(a%i == 0)
                return false;
        }
        return true;
    }
}
