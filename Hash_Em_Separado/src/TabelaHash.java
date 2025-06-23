import java.util.NoSuchElementException;

public class TabelaHash<K, V> implements IMapeamento<K, V> {

    private Lista<Entrada<K, V>> [] tabelaHash;
    private  int capacidade;

    public TabelaHash(int capacidade){

        if(capacidade < 1) throw new IllegalStateException("Capacidade não pode ser menor do que 1");
        tabelaHash = (Lista<Entrada<K, V>> []) new Lista[capacidade];

        this.capacidade = capacidade;
        for(int i = 0; i < capacidade; i++)
            tabelaHash[i] = new Lista<>();
    }

    private int funcaoHash(K chave){
        return (((int)chave) % 11);
    }


    @Override
    public int inserir(K chave, V item) {
        int pos = funcaoHash(chave);

        Entrada<K, V> entrada = new Entrada<K,V>(chave, item);
        try{
            tabelaHash[pos].pesquisar(entrada);
            throw new IllegalStateException("O item já foi adicionado");
        }catch(NoSuchElementException e){
            tabelaHash[pos].inserirFinal(entrada);
        }
        return pos;
    }

    @Override
    public V pesquisar(K chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public V remover(K chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    @Override
    public String percorrer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'percorrer'");
    }
    
}
