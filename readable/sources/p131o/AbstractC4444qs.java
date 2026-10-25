package p131o;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: o.qs */
/* loaded from: classes.dex */
public abstract class AbstractC4444qs implements Iterator {

    /* renamed from: AZxh */
    public int f16243AZxh = 2;

    /* renamed from: mjFkc */
    public Object f16244mjFkc;

    /* renamed from: AZxh */
    public abstract Object mo8801AZxh();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f16243AZxh;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.f16243AZxh = 4;
            this.f16244mjFkc = mo8801AZxh();
            if (this.f16243AZxh != 3) {
                this.f16243AZxh = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f16243AZxh = 2;
        Object obj = this.f16244mjFkc;
        this.f16244mjFkc = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: wA */
    public final Object m13308wA() {
        this.f16243AZxh = 3;
        return null;
    }
}
