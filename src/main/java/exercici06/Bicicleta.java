package exercici06;

public class Bicicleta {
    private int referencia;
    private String marca;
    private String model;
    private float pes;
    private float grandariaRodes;
    private boolean teMotor;
    private String dataFabricació;
    private float preu;
    private int nombreExistencies;

    public Bicicleta(int referencia, String marca, String model, float pes, float grandariaRodes
            , boolean teMotor, String dataFabricació, float preu, int nombreExistencies) {
        this.referencia = referencia;
        this.marca = marca;
        this.model = model;
        this.pes = pes;
        this.grandariaRodes = grandariaRodes;
        this.teMotor = teMotor;
        this.dataFabricació = dataFabricació;
        this.preu = preu;
        this.nombreExistencies = nombreExistencies;
    }

    public Bicicleta() {
        referencia = 0;
        marca = "";
        model = "";
        pes = 0f;
        grandariaRodes = 0f;
        teMotor = false;
        dataFabricació ="";
        preu = 0f;
        nombreExistencies = 0;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "referencia=" + referencia +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", pes=" + pes +
                ", grandariaRodes=" + grandariaRodes +
                ", teMotor=" + teMotor +
                ", dataFabricació='" + dataFabricació + '\'' +
                ", preu=" + preu +
                ", nombreExistencies=" + nombreExistencies +
                '}';
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public float getGrandariaRodes() {
        return grandariaRodes;
    }

    public void setGrandariaRodes(float grandariaRodes) {
        this.grandariaRodes = grandariaRodes;
    }

    public boolean isTeMotor() {
        return teMotor;
    }

    public void setTeMotor(boolean teMotor) {
        this.teMotor = teMotor;
    }

    public String getDataFabricació() {
        return dataFabricació;
    }

    public void setDataFabricació(String dataFabricació) {
        this.dataFabricació = dataFabricació;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getNombreExistencies() {
        return nombreExistencies;
    }

    public void setNombreExistencies(int nombreExistencies) {
        this.nombreExistencies = nombreExistencies;
    }
}
