package situacoes;

import objetos.Pessoa; 

public class SegundaDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não pode passar para a próxima fase sem ter tomado a segunda dose.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new Finalizada());
        System.out.println(pessoa.getNome() + " tomou a segunda dose da vacina e est� imunizada.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a dose 2 da vacina";
    }
    
}
