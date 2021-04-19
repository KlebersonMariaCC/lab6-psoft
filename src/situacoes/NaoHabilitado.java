package situacoes;

import objetos.Pessoa;

public class NaoHabilitado extends Situacao{
    @Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new PrimeiraDose());
        System.out.println(pessoa.getNome() + " habilitada para a primeira dose. \n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome()+ " ainda não habilitada para a primeira dose.\n\n");
        
    }
    @Override
    public String toString() {
        return "Não habilitada para a primeira dose.";
    }
}
