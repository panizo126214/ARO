package API;

import android.media.Image;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.ImageRequest;
import Model.Pregunta;
import Model.Respuesta;
import Model.RespuestaImagen;
import Model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("registro.php")
    Call<Integer> registro(@Field("nombre") String nombre, @Field("usuario") String usuario, @Field("email") String email, @Field("contraseña") String contraseña);
    @GET("login.php")
    Call<Integer> login(@Query("usuario") String usuario, @Query("contraseña") String contraseña);

    @POST("https://stablediffusionapi.com/api/v3/text2img")
    Call<Respuesta> generateImageByPrompt(@Body Pregunta request);

    @POST("{link}")
    Call<RespuestaImagen> getFinalImage(@Path("link") String id, @Body String key);

    @GET("{link}")
    Call<RespuestaImagen> getGeneratedImage(@Path("link") String link);

    @GET("addImg.php")
    Call<Integer> addImg(@Query("prompt") String prompt, @Query("idusuario") int idusuario, @Query("url") String url);

    @GET("getUrls.php")
    Call<ArrayList<String>> getUrls();


    /*@POST("upload")
    Call<Void> uploadImage(@Body ImageRequest imageRequest);
    */



}
