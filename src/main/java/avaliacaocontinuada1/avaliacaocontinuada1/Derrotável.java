package avaliacaocontinuada1.avaliacaocontinuada1;

public interface Derrotável {
    public String morrer(Inimigo quemDerrotou);
    public String morrer(Jogador quemDerrotou);
    public String receberDano(int danoRecebido, Inimigo quemCausou);
    public String receberDano(int danoRecebido, Jogador quemCausou);
}
