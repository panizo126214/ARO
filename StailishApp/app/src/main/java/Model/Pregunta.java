package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pregunta {

    public final ArrayList<String> key_array = new ArrayList<String>(Arrays.asList(
            "28jHQsD1h0O4Y2GS085LEiyprU60vq4QL3H5pKyEHtMNEcNZtJy7NwaIBwy3",
            "5vjbXitgCvH2uLUbF5hfePIdO9SheS5q7OGN6N3C6NwVS9BUbtUH8mNYnmqb",
            "C0Mbe4ha5Qat5ZUA1oTBPDQ3XV3rhCQSSb9FJwyGyRMpvXttgdCD81DTld7z",
            "jQXiyN5mgKaSb6B0JujTlabHqy5WKqv2d4fs75bfmhu1sQHD1qfwhQoeda9Z",
            "qCGEI3QRvmqzUT06iJzl1A07yF5PNXqZT7uGueaNhRr1FILvIcrZJNCM5euc"
    ));
    public final int min = 0;
    public final int max = key_array.size();
    public final int random = new Random().nextInt((max - min) + 1) + min;

    public String key;
    public String prompt;
    public String negative_prompt;
    public String width;
    public String height;
    public String samples;
    public String num_inference_steps;
    public Object seed;
    public double guidance_scale;
    public String safety_checker;
    public Object webhook;
    public Object track_id;

    public Pregunta(String prompt) {
        this.prompt = prompt;
        this.key = key_array.get(this.random);
        this.negative_prompt = "mutated hands";
        this.width = "512";
        this.height = "512";
        this.samples = "1";
        this.num_inference_steps = "20";
        this.seed = null;
        this.guidance_scale = 7.5;
        this.safety_checker = "yes";
        this.webhook = null;
        this.track_id = null;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getNegative_prompt() {
        return negative_prompt;
    }

    public void setNegative_prompt(String negative_prompt) {
        this.negative_prompt = negative_prompt;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSamples() {
        return samples;
    }

    public void setSamples(String samples) {
        this.samples = samples;
    }

    public String getNum_inference_steps() {
        return num_inference_steps;
    }

    public void setNum_inference_steps(String num_inference_steps) {
        this.num_inference_steps = num_inference_steps;
    }

    public Object getSeed() {
        return seed;
    }

    public void setSeed(Object seed) {
        this.seed = seed;
    }

    public double getGuidance_scale() {
        return guidance_scale;
    }

    public void setGuidance_scale(double guidance_scale) {
        this.guidance_scale = guidance_scale;
    }

    public String getSafety_checker() {
        return safety_checker;
    }

    public void setSafety_checker(String safety_checker) {
        this.safety_checker = safety_checker;
    }

    public Object getWebhook() {
        return webhook;
    }

    public void setWebhook(Object webhook) {
        this.webhook = webhook;
    }

    public Object getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Object track_id) {
        this.track_id = track_id;
    }
}


