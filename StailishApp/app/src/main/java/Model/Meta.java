package Model;

public class Meta{
    public int h;
    public int w;
    public String enable_attention_slicing;
    public String file_prefix;
    public double guidance_scale;
    public String model;
    public int n_samples;
    public String negative_prompt;
    public String outdir;
    public String prompt;
    public String revision;
    public String safety_checker;
    public long seed;
    public int steps;

    public Meta(int h, int w, String enable_attention_slicing, String file_prefix, double guidance_scale, String model, int n_samples, String negative_prompt, String outdir, String prompt, String revision, String safety_checker, int seed, int steps, String vae) {
        this.h = h;
        this.w = w;
        this.enable_attention_slicing = enable_attention_slicing;
        this.file_prefix = file_prefix;
        this.guidance_scale = guidance_scale;
        this.model = model;
        this.n_samples = n_samples;
        this.negative_prompt = negative_prompt;
        this.outdir = outdir;
        this.prompt = prompt;
        this.revision = revision;
        this.safety_checker = safety_checker;
        this.seed = seed;
        this.steps = steps;
        this.vae = vae;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public String getEnable_attention_slicing() {
        return enable_attention_slicing;
    }

    public void setEnable_attention_slicing(String enable_attention_slicing) {
        this.enable_attention_slicing = enable_attention_slicing;
    }

    public String getFile_prefix() {
        return file_prefix;
    }

    public void setFile_prefix(String file_prefix) {
        this.file_prefix = file_prefix;
    }

    public double getGuidance_scale() {
        return guidance_scale;
    }

    public void setGuidance_scale(double guidance_scale) {
        this.guidance_scale = guidance_scale;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getN_samples() {
        return n_samples;
    }

    public void setN_samples(int n_samples) {
        this.n_samples = n_samples;
    }

    public String getNegative_prompt() {
        return negative_prompt;
    }

    public void setNegative_prompt(String negative_prompt) {
        this.negative_prompt = negative_prompt;
    }

    public String getOutdir() {
        return outdir;
    }

    public void setOutdir(String outdir) {
        this.outdir = outdir;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSafety_checker() {
        return safety_checker;
    }

    public void setSafety_checker(String safety_checker) {
        this.safety_checker = safety_checker;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getVae() {
        return vae;
    }

    public void setVae(String vae) {
        this.vae = vae;
    }

    public String vae;
}