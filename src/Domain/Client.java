package Domain;

public class Client {
    private String idClient;
    private String nume;
    private String prenume;
    private String CNP;
    private String dataNasterii;
    private String dataInregistrarii;
    private int  puncteFidelitate;

    public Client(String idClient, String nume, String prenume, String CNP, String dataNasterii, String dataInregistrarii, int puncteFidelitate) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.dataNasterii = dataNasterii;
        this.dataInregistrarii = dataInregistrarii;
        this.idClient = idClient;
        this.puncteFidelitate = puncteFidelitate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getDataInregistrarii() {
        return dataInregistrarii;
    }

    public void setDataInregistrarii(String dataInregistrarii) {
        this.dataInregistrarii = dataInregistrarii;
    }


    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public int getPuncteFidelitate() {
        return puncteFidelitate;
    }

    public void setPuncteFidelitate(int puncteFidelitate) {
        this.puncteFidelitate = puncteFidelitate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dataNasterii='" + dataNasterii + '\'' +
                ", dataInregistrarii='" + dataInregistrarii + '\'' +
                ", idClient=" + idClient +
                ", puncteFidelitate=" + puncteFidelitate +
                '}';
    }
}