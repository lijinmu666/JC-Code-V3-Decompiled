package p131o;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: o.HT */
/* loaded from: classes.dex */
public final class C2102HT {

    /* renamed from: AZxh */
    public Queue f8601AZxh;

    /* renamed from: mjFkc */
    public final Object f8602mjFkc = new Object();

    /* renamed from: wA */
    public boolean f8603wA;

    /* renamed from: AZxh */
    public final void m8574AZxh(AbstractC1670B7 abstractC1670B7) {
        InterfaceC3432bT interfaceC3432bT;
        synchronized (this.f8602mjFkc) {
            if (this.f8601AZxh != null && !this.f8603wA) {
                this.f8603wA = true;
                while (true) {
                    synchronized (this.f8602mjFkc) {
                        try {
                            interfaceC3432bT = (InterfaceC3432bT) this.f8601AZxh.poll();
                            if (interfaceC3432bT == null) {
                                this.f8603wA = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    interfaceC3432bT.mo7600mjFkc(abstractC1670B7);
                }
            }
        }
    }

    /* renamed from: mjFkc */
    public final void m8575mjFkc(InterfaceC3432bT interfaceC3432bT) {
        synchronized (this.f8602mjFkc) {
            try {
                if (this.f8601AZxh == null) {
                    this.f8601AZxh = new ArrayDeque();
                }
                this.f8601AZxh.add(interfaceC3432bT);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
