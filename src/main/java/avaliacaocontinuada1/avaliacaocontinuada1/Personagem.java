package avaliacaocontinuada1.avaliacaocontinuada1;

public abstract class Personagem {
    private int hp;
    private int dano;
    private String nome;
    private int exp;

    public Personagem(int hp, int dano, String nome, int exp) {
        this.hp = hp;
        this.dano = dano;
        this.nome = nome;
        this.exp = exp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }
}
