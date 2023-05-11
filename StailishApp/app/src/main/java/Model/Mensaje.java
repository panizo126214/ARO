package Model;

public class Mensaje {

    String prompt;
    String img_src;

    public Mensaje(String prompt, String img_src) {
        this.prompt = prompt;
        this.img_src = img_src;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }
}
