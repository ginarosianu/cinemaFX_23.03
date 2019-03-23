package Domain;

public class Rezervare {

    private String id, idFilm, idClient;
    //private int puncteFidelitate;
    private String data, ora;
    //private final Double reducere = 0.1;

    public Rezervare(String id, String idFilm, String idClient, String data, String ora) {
        this.id = id;
        this.idFilm = idFilm;
        this.idClient = idClient;
        this.data = data;
        this.ora = ora;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "id='" + id + '\'' +
                ", idFilm='" + idFilm + '\'' +
                ", idClient='" + idClient + '\'' +
                ", data='" + data + '\'' +
                ", ora='" + ora + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    /*public int getPuncteFidelitate() {
        return puncteFidelitate;
    }*/

    /*public void setPuncteFidelitate(int puncteFidelitate) {
        this.puncteFidelitate = puncteFidelitate;
    }*/

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    /*public Double getReducere() {
        return reducere;
    }*/
}