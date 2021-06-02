import com.google.gson.Gson;

public class Robson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        gson.toJson(1);
        int one = gson.fromJson("1", int.class);
        System.out.println(one);
    }
}
