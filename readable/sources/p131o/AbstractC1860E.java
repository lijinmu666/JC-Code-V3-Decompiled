package p131o;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: o.E */
/* loaded from: classes.dex */
public abstract class AbstractC1860E {
    /* renamed from: mjFkc */
    public static void m8100mjFkc(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
