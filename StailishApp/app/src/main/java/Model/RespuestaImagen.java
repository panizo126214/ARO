package Model;

import java.util.ArrayList;

public class RespuestaImagen {

    public String status;
    public int id;
    public ArrayList<String> output;

    public RespuestaImagen(String status, int id, ArrayList<String> output) {
        this.status = status;
        this.id = id;
        this.output = output;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
