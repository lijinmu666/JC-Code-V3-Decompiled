package p131o;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: o.e9 */
/* loaded from: classes.dex */
public abstract class AbstractC3607e9 implements Closeable {

    /* renamed from: o.e9$mjFkc */
    public interface mjFkc {
        /* renamed from: build */
        AbstractC3607e9 mo11818build();

        /* renamed from: mjFkc */
        mjFkc mo11819mjFkc(Context context);
    }

    /* renamed from: KLFTb */
    public abstract C3543d9 mo11816KLFTb();

    /* renamed from: ZfxDd */
    public abstract InterfaceC4829wfQA mo11817ZfxDd();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        mo11817ZfxDd().close();
    }
}
