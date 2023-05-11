package Model;

public class ImageRequest {
    private String fileName;
    private String contentType;
    private String base64Image;
    // Constructor, getters y setters


    public ImageRequest(String fileName, String contentType, String base64Image) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.base64Image = base64Image;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
