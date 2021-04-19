package situacoes;

import objetos.Pessoa;

public class TomouPrimeiraDose extends Situacao{
    
	@Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new SegundaDose());
        System.out.print(pessoa.getNome() + " está habilitada para tomar a segunda dose.\n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não pode tomar a segunda dose agora.\n\n");    
    }

    @Override
    public String toString(){
        return "Tomou a primeira dose e está em espera para tomar a segunda dose.";
    }
}
