package situacoes;

import objetos.Pessoa;

public class PrimeiraDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não pode avançar de fase sem tomar a primeira dose.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new TomouPrimeiraDose());
        System.out.println(pessoa.getNome() + " tomou a primeira dose e está em espera para a segunda dose.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a primiera dose.;";
    }
    
}
