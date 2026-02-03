import com.google.gson.Gson;

import java.lang.reflect.Type;

public class TransJson {
    private final Gson gson;

    public TransJson() {
        this.gson = new Gson();
    }

    public String toJsonString(Object obj) {
        return this.gson.toJson(obj);
    }

    public Object toObject(String str, Type type) {
        return this.gson.fromJson(str, type);
    }
}
