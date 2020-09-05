package avaliacaocontinuada1.avaliacaocontinuada1;

public class Inimigo extends Personagem implements Derrotável {
    public Inimigo(int hp, int dano, String nome, int exp) {
        super(hp, dano, nome, exp);
    }

    public String receberDano(int danoRecebido, Inimigo quemCausou) {
        return String.format("Um inimigo não pode causar dando a outro inimigo.", quemCausou.getNome(), danoRecebido, getNome(), getHp());
    }

    public String receberDano(int danoRecebido, Jogador quemCausou) {
        setHp(getHp() - danoRecebido);

        if (getHp() <= 0) {
            morrer(quemCausou);
        }

        return String.format("O jogador %s causou %d de dano em %s. HP atual: %d.", quemCausou.getNome(), danoRecebido, getNome(), getHp());
    }

    public String morrer(Inimigo quemDerrotou) {
        return "";
    }

    public String morrer(Jogador quemDerrotou) {
        quemDerrotou.receberExp(getExp());

        return String.format("%s foi derrotado por %s, concedendo %d de EXP.", getNome(), quemDerrotou.getNome(), getExp());
    }
}
