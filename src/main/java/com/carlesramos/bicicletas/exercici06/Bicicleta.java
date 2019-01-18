package com.carlesramos.bicicletas.exercici06;
public class Bicicleta {
    public enum Model{MONTAÑA,CARRETERA,HIBRIDA,INFANTIL}
    private int referencia;
    private String marca;
    private Model model;
    private float pes;
    private float grandariaRodes;
    private boolean teMotor;
    private String dataFabricacio;
    private float preu;
    protected int nombreExistencies;

    public Bicicleta(int referencia, String marca,  Model model, float pes, float grandariaRodes
            , boolean teMotor, String dataFabricacio, float preu, int nombreExistencies) {
        this.referencia = referencia;
        this.marca = marca;
        this.model = model;
        this.pes = pes;
        this.grandariaRodes = grandariaRodes;
        this.teMotor = teMotor;
        this.dataFabricacio = dataFabricacio;
        this.preu = preu;
        this.nombreExistencies = nombreExistencies;
    }

    public Bicicleta() {
        referencia = 0;
        marca = "";
        model=Model.MONTAÑA;
        pes = 0f;
        grandariaRodes = 0f;
        teMotor = false;
        dataFabricacio ="";
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
                ", dataFabricació='" + dataFabricacio + '\'' +
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

    public Model getModel() {
        Model model = this.model;
        return model;
    }

    public void setModel(Model model) {
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

    public String getDataFabricacio() {
        return dataFabricacio;
    }

    public void setDataFabricacio(String dataFabricacio) {
        this.dataFabricacio = dataFabricacio;
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
