package situacoes;

import objetos.Pessoa;

public class Finalizada extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println("Pessoa com vacinação concluída.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println("Pessoa com vacinação concluída.\n\n");
    }

    @Override
    public String toString(){
        return "Pessoa já tomou as 2 doses da vacina e está imunizada";
    }
    
}
