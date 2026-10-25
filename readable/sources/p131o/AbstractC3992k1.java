package p131o;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* renamed from: o.k1 */
/* loaded from: classes.dex */
public abstract class AbstractC3992k1 {
    /* renamed from: AZxh */
    public static AbstractC3992k1 m12460AZxh(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? m12461mjFkc(Long.parseLong(jsonReader.nextString())) : m12461mjFkc(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    /* renamed from: mjFkc */
    public static AbstractC3992k1 m12461mjFkc(long j) {
        return new C2771Rc(j);
    }

    /* renamed from: wA */
    public abstract long mo10085wA();
}
