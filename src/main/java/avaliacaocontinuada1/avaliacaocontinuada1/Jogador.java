package avaliacaocontinuada1.avaliacaocontinuada1;

public class Jogador extends Personagem implements Derrotável, Evoluível {
    private int nível;

    public Jogador(int hp, int dano, String nome, int nível, int exp) {
        super(hp, dano, nome, exp);

        this.nível = nível;
    }

    public String morrer(Inimigo quemDerrotou) {
        return String.format("%s foi derrotado por %s.", getNome(), quemDerrotou.getNome());
    }

    public String morrer(Jogador quemDerrotou) {
        return String.format("%s foi derrotado em um duelo por %s.", getNome(), quemDerrotou.getNome());
    }

    public String receberDano(int danoRecebido, Inimigo quemCausou) {
        setHp(getHp() - danoRecebido);

        if (getHp() <= 0) {
            morrer(quemCausou);
        }

        return String.format("%s causou %d de dano em %s. HP atual é de %d.", quemCausou.getNome(), danoRecebido, getNome(), getHp());
    }

    public String receberDano(int danoRecebido, Jogador quemCausou) {
        setHp(getHp() - danoRecebido);

        if (getHp() <= 0) {
            morrer(quemCausou);
        }

        return String.format("%s causou %d de dano em %s. HP atual é de %d.", quemCausou.getNome(), danoRecebido, getNome(), getHp());
    }

    public String evoluir() {
        nível++;

        return String.format("%s subiu para o nível %d!", getNome(), nível);
    }

    public String receberExp(int expRecebida) {
        setExp(getExp() + expRecebida);

        if (getExp() >= 100) {
            int diferença = getExp() - 100;
            evoluir();
            setExp(diferença);
        }

        return String.format("%s recebeu %d de EXP.", getNome(), expRecebida);
    }

    public void setNível(int nível) {
        this.nível = nível;
    }

    public int getNível() {
        return nível;
    }
}
