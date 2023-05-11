package Model;

import java.util.ArrayList;

public class Respuesta{
    public String status;
    public double generationTime;
    public int id;
    public ArrayList<String> output;
    public Meta meta;
    public String tip;
    public String message;
    public String fetch_result;

    public Respuesta(String status, String tip, double generationTime, String message, String fetch_result, int id, ArrayList<String> output, Meta meta) {
        this.status = status;
        this.generationTime = generationTime;
        this.id = id;
        this.message = message;
        this.tip = tip;
        this.fetch_result = fetch_result;
        this.output = output;
        //this.meta = meta;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFetch_result() {
        return fetch_result;
    }

    public void setFetch_result(String fetch_result) {
        this.fetch_result = fetch_result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(double generationTime) {
        this.generationTime = generationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String imprimeRespuesta(){

        return getMeta().getModel();
    }
}
