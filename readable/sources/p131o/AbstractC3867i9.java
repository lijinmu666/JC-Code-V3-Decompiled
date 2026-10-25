package p131o;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: o.i9 */
/* loaded from: classes.dex */
public abstract class AbstractC3867i9 {

    /* renamed from: o.i9$mjFkc */
    public class mjFkc extends AbstractC3867i9 {
        public mjFkc() {
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: read */
        public Object mo3481read(C4587t0 c4587t0) throws IOException {
            if (c4587t0.mo13542CqaNbM() != EnumC4786w0.NULL) {
                return AbstractC3867i9.this.mo3481read(c4587t0);
            }
            c4587t0.mo13569wJVbdd();
            return null;
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: write */
        public void mo3482write(C1598A0 c1598a0, Object obj) throws IOException {
            if (obj == null) {
                c1598a0.mo7531Ucbh();
            } else {
                AbstractC3867i9.this.mo3482write(c1598a0, obj);
            }
        }
    }

    public final Object fromJson(Reader reader) {
        return mo3481read(new C4587t0(reader));
    }

    public final Object fromJsonTree(AbstractC4187n0 abstractC4187n0) {
        try {
            return mo3481read(new C4853x0(abstractC4187n0));
        } catch (IOException e) {
            throw new C4252o0(e);
        }
    }

    public final AbstractC3867i9 nullSafe() {
        return new mjFkc();
    }

    /* renamed from: read */
    public abstract Object mo3481read(C4587t0 c4587t0);

    /* renamed from: toJson */
    public final void m12288toJson(Writer writer, Object obj) {
        mo3482write(new C1598A0(writer), obj);
    }

    public final AbstractC4187n0 toJsonTree(Object obj) {
        try {
            C4921y0 c4921y0 = new C4921y0();
            mo3482write(c4921y0, obj);
            return c4921y0.m13979xrEuO();
        } catch (IOException e) {
            throw new C4252o0(e);
        }
    }

    /* renamed from: write */
    public abstract void mo3482write(C1598A0 c1598a0, Object obj);

    public final Object fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    /* renamed from: toJson */
    public final String m12287toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            m12288toJson(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
