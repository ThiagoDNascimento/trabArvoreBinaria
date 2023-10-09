package lib;

public class No<T> {
    
    private T valor;
    private No<T> filhoDireita;
    private No<T> filhoEsquerda;

    
    public No(T valor){
        this.valor = valor;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
    }

    public int obterAltura(){
        return obterAltura(this);
    }

    private int obterAltura(No<T> raiz){
        if(raiz == null){ //se a raiz for nula retorna -1
            return -1;
        }else{
            int hd = obterAltura(raiz.getFilhoDireita());
            int he = obterAltura(raiz.getFilhoEsquerda());
            if(hd > he){
                return hd+1;
            }else{
                return he+1;
            }
        }
    }

    public int fatorBalanceamento(){
        return obterAltura(this.filhoDireita) - obterAltura(this.filhoEsquerda);
    }
    
    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the filhoDireita
     */
    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    /**
     * @return the filhoEsquerda
     */
    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }
    
    
}
