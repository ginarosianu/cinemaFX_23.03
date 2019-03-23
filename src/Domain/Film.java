package Domain;

public class Film {
    private int anAparitie;
    private double pretBilet;
    private String idFilm, titlu;
    private boolean inProgram;
    private int puncte;
    //pretBilet > 0
    //1950 <= anAparitie <= 2020


    public Film(String idFilm, int anAparitie, double pretBilet, String titlu, boolean inProgram) {
        this.idFilm = idFilm;
        this.anAparitie = anAparitie;
        this.pretBilet = pretBilet;
        this.titlu = titlu;
        this.inProgram = inProgram;
        this.puncte = (int)(this.pretBilet / 10);
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", anAparitie=" + anAparitie +
                ", pretBilet=" + pretBilet +
                ", titlu='" + titlu + '\'' +
                ", inProgram=" + inProgram +
                '}';
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    public double getPretBilet() {
        return pretBilet;
    }

    public void setPretBilet(double pretBilet) {
        this.pretBilet = pretBilet;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public boolean isInProgram() {
        return inProgram;
    }

    public void setInProgram(boolean inProgram) {
        this.inProgram = inProgram;
    }

    public int getPuncte() {
        return puncte;
    }
}
