package objetos;

import java.util.*;

import situacoes.*;

public class DataVacina {
    private Map<String, Pessoa> pessoasCadastradas;

    private Set<String> comorbidades;

    private Set<String> profissoes;

    private int idadeMinima;

    public DataVacina(){
        this.pessoasCadastradas = new HashMap<String, Pessoa>();
        this.comorbidades = new TreeSet<String>();
        this.profissoes = new TreeSet<String>();
        this.idadeMinima = 90;
    }

    public void adicionarPessoa(String nome, String cpf, int idade,String endereco,
    String cartaoDoSUS, String email, String telefone, String profissao, String comorbidades){
        if(pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com cpf " + cpf + " ja cadastrada..\n\n");
        }
        else{
            
            Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoDoSUS,  email,  telefone,  profissao, comorbidades);
            atualizarSituacoes(pessoa);
            pessoasCadastradas.put(cpf, pessoa);
        }
    }

    public void adicionarComorbidadeHabilitada(String comorbidade){
        this.comorbidades.add(comorbidade);
        atualizarSituacoes();
    }
    
    public void adicionarProfissaoHabilitada(String profissao){
        this.profissoes.add(profissao);
        atualizarSituacoes();
    }
    
    public void setIdadeMinimaHabilitada(int idade){
        this.idadeMinima = idade;
        atualizarSituacoes();
    }

    public void setPessoaComorbidades(String cpf, String comorbidades){
        this.pessoasCadastradas.get(cpf).setComorbidades(comorbidades);
    }

    public void setProfissaoPessoa(String cpf, String profissao){
        this.pessoasCadastradas.get(cpf).setProfissao(profissao);
    }
    
    public void avancarEtapa(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com cpf: " + cpf +" não cadastrada.");
        }else if(verificarHabilitado(this.pessoasCadastradas.get(cpf))){
            this.pessoasCadastradas.get(cpf).avancarEtapa();
        }else{
            System.out.println("Pessoa não habilitada para vacinação.");
        }
    }
    
    public void tomarVacina(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com cpf: " + cpf +" nao está cadastrada.");
        }else{
            this.pessoasCadastradas.get(cpf).tomarVacina();
        }
    }

    public void listarPessoasHabilitadasDose1(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof PrimeiraDose)result += pessoa.toString();
        }
        System.out.print(result);
    }

    public void listarPessoasHabilitadasDose2(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof SegundaDose)result += pessoa.toString();
        }
        System.out.print(result);
    }

    public void listarPessoasNaoHabilitadas(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof NaoHabilitado)result += pessoa.toString();
        }
        System.out.print(result);
    }
    
    public void listarPessoasTomaramDose1(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof TomouPrimeiraDose)result += pessoa.toString();
        }
        System.out.print(result);
    }
    
    public void listarPessoasImunizadas(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof Finalizada)result += pessoa.toString();
        }
        System.out.print(result);
    }

    public void pegarSituacaoPessoa(String cpf) {
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa não está cadastrada.\n\n");
        }else{
            System.out.println(this.pessoasCadastradas.get(cpf).toString() + " \n\n");
        }
    }

    public void listarComorbidadesHabiltiadas(){
        String result = "Comorbidades que garantem o recebimento da vacina: \n";
        for(String comorbidade : this.comorbidades){
            result += comorbidade + "\n";
        }
        System.out.print(result);
    }

    public void listarProfissoesHabiltiadas(){
        String result = "Profissõees que permitem vacinação: \n";
        for(String profissao : this.profissoes){
            result += profissao + "\n";
        }
        System.out.print(result);
    }

    public void getIdadeMinimaVacinacao(){
        System.out.println("Idade mínima para vacinação : " + this.idadeMinima + " anos.");
    }

    public void getDetalhes(){
        listarComorbidadesHabiltiadas();
        listarProfissoesHabiltiadas();
        getIdadeMinimaVacinacao();
    }

    private void atualizarSituacoes() {
        for (Pessoa pessoa : this.pessoasCadastradas.values()){
            atualizarSituacoes(pessoa);
        }
    }
    
    private void atualizarSituacoes(Pessoa pessoa) {
        if (pessoa.getSituacao() instanceof NaoHabilitado && verificarHabilitado(pessoa)){
            pessoa.getSituacao().mudaSituacao(pessoa);
        }
    }
    
    private boolean verificarHabilitado(Pessoa pessoa) {
        if (pessoa.getIdade() >= idadeMinima) return true;
        if ( this.profissoes.contains(pessoa.getProfissao()))return true;
        for(String comorbidade : pessoa.getComorbidades()){
            if(comorbidades.contains(comorbidade))return true;
        }
        return false;
        
    }
    
    public Map<String, Pessoa> getPessoasCadastradas() {
        return this.pessoasCadastradas;
    }

    public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }

    public void setComorbidades(Set<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public Set<String> getProfissoes() {
        return this.profissoes;
    }

    public void setProfissoes(Set<String> profissoes) {
        this.profissoes = profissoes;
    }

    public int getIdadeMinima() {
        return this.idadeMinima;
    }
}
