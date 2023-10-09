
package lib;

import java.util.ArrayList;
import java.util.Comparator;

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
    
    protected No<T> atual = null;
    private ArrayList<No<T>> pilhaNavegacao = null;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }
    

    @Override
    public void adicionar(T novoValor) {
        No<T> novoNo = new No<T>(novoValor);
        if(this.raiz == null){
            this.raiz = novoNo;
        }
        else{
            this.raiz = adicionar(this.raiz,novoNo);
        }
    }
    private No<T> adicionar(No<T> atual, No<T> novoNo){
        if(comparador.compare(novoNo.getValor(), atual.getValor()) < 0){ // se for menor vai pra esquerda
            if(atual.getFilhoEsquerda() == null){
                atual.setFilhoEsquerda(novoNo);
            }
            else{
                atual.setFilhoEsquerda(adicionar(atual.getFilhoEsquerda(), novoNo));
            }
        }
        else{ // se for maior vai pra direita
            if(atual.getFilhoDireita() == null){
                atual.setFilhoDireita(novoNo);
            }
            else{
                atual.setFilhoDireita(adicionar(atual.getFilhoDireita(), novoNo));
            }
        }
        return atual;
    }


    @Override
    public T pesquisar(T valor) {
        No<T> atual = this.raiz;
        while(atual != null){
            if(atual.getValor().equals(valor)){
                return atual.getValor();
            }
            else if(comparador.compare(atual.getValor(), valor) < 0){ // se for menor vai pra esquerda
                atual.getFilhoEsquerda();
            }
            else{ // se for maior vai pra direita
                atual.getFilhoDireita();
            }
        }
        return null;
    }


    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return this.raiz.obterAltura();
    }
       
    
    @Override
    public int quantidadeNos() {
        return quantidadeNos(this.raiz);
    }
    
    private int quantidadeNos(No<T> no){
        if(no == null){
            return 0;
        }else{
            return 1 + quantidadeNos(no.getFilhoEsquerda()) + quantidadeNos(no.getFilhoDireita());
        }        

    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    
    @Override
    public T obterProximo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void reiniciarNavegacao(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
