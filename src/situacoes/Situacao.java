package situacoes;

import objetos.Pessoa;

public abstract class Situacao {
    
    public abstract void mudaSituacao(Pessoa pessoa);
    public abstract void tomaVacina(Pessoa pessoa);

}
