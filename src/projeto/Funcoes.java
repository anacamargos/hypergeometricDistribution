/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.math.BigInteger;

/**
 *
 * @author Ana
 */
public class Funcoes {
    
    private double[] probabilidade;
    private double[] acumulada;
    
    public BigInteger fatorial ( int valor ) {
        BigInteger fatorial = new BigInteger("1");
        for ( int i = 2; i <= valor; i ++ ) {
            fatorial = fatorial.multiply(new BigInteger(i + ""));
        }
        return fatorial;
    }
    
    public BigInteger combinacao (int n, int p) {
        
        BigInteger resultado = new BigInteger("-1");
        
        if ( n >= p) {
            BigInteger numerador = fatorial(n);
            BigInteger denominador = fatorial(p).multiply(fatorial(n-p));
            resultado = numerador.divide(denominador);
        } 
        return resultado;
        
    }
    
    public double resultadoFormula (String populacao, String amostra, String caracteristica, String ponto) {
        int N = Integer.parseInt(populacao);
        int n = Integer.parseInt(amostra);
        int r = Integer.parseInt(caracteristica);
        int x = Integer.parseInt(ponto);
        return resultadoFormula(N, n, r, x);
    }
    
    public double resultadoFormula (int N, int n, int r, int x) {
        double numerador = combinacao(r,x).multiply(combinacao(N - r, n - x)).doubleValue();
        double denominador = combinacao(N,n).doubleValue();
        double resultado = numerador/denominador;
        return resultado;
    }
    
    public double resultadoProbabilidadeAcumulada ( String populacao, String amostra, String caracteristica, String ponto) {
        int N = Integer.parseInt(populacao);
        int n = Integer.parseInt(amostra);
        int r = Integer.parseInt(caracteristica);
        int x = Integer.parseInt(ponto);
        return resultadoProbabilidadeAcumulada(N, n, r, x);
    }
    
    public double resultadoProbabilidadeAcumulada( int N, int n, int r, int x) {
        preencheVetorProbabilidade(N,n,r,x);
        preencheVetorAcumulada(N,n,r,x);
        return acumulada[x];
    }
    
    public void preencheVetorProbabilidade (int N, int n, int r, int x ) {
        probabilidade = new double [r+1];
        for ( int i = 0; i < probabilidade.length; i ++ ) {
            probabilidade[i] = resultadoFormula(N,n,r,i);
            System.out.println("A probailidade no ponto " + i + " é: " + probabilidade[i]);
        }
    }
    
    public void preencheVetorAcumulada(int N, int n, int r, int x) {
        acumulada = new double [r+1];
        acumulada[0] = probabilidade[0];
        for ( int i = 1; i < acumulada.length; i ++ ) {
            acumulada[i] = acumulada[i-1] + probabilidade[i];
        }
        System.out.println();
    }
    
}
