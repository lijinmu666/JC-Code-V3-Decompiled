package p131o;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: o.As */
/* loaded from: classes.dex */
public final class C1654As {

    /* renamed from: mjFkc */
    public final String f7408mjFkc = "\n";

    public C1654As(String str) {
    }

    /* renamed from: mjFkc */
    public static C1654As m7636mjFkc(String str) {
        return new C1654As("\n");
    }

    /* renamed from: wA */
    public static final CharSequence m7637wA(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    /* renamed from: AZxh */
    public final String m7638AZxh(Iterable iterable) throws IOException {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                sb.append(m7637wA(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f7408mjFkc);
                    sb.append(m7637wA(it.next()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
