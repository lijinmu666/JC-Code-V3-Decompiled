package androidx.p020emoji2.p021text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import p131o.AbstractC2280K3;
import p131o.AbstractC2352L8;
import p131o.AbstractC3600e2;
import p131o.C3536d2;
import p131o.C4742vL;

/* renamed from: androidx.emoji2.text.JHa */
/* loaded from: classes.dex */
public final class C0080JHa {

    /* renamed from: AZxh */
    public final char[] f998AZxh;

    /* renamed from: ZfxDd */
    public final Typeface f999ZfxDd;

    /* renamed from: mjFkc */
    public final C3536d2 f1000mjFkc;

    /* renamed from: wA */
    public final mjFkc f1001wA = new mjFkc(1024);

    /* renamed from: androidx.emoji2.text.JHa$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public C4742vL f1002AZxh;

        /* renamed from: mjFkc */
        public final SparseArray f1003mjFkc;

        public mjFkc() {
            this(1);
        }

        /* renamed from: AZxh */
        public final C4742vL m646AZxh() {
            return this.f1002AZxh;
        }

        /* renamed from: mjFkc */
        public mjFkc m647mjFkc(int i) {
            SparseArray sparseArray = this.f1003mjFkc;
            if (sparseArray == null) {
                return null;
            }
            return (mjFkc) sparseArray.get(i);
        }

        /* renamed from: wA */
        public void m648wA(C4742vL c4742vL, int i, int i2) {
            mjFkc mjfkcM647mjFkc = m647mjFkc(c4742vL.m13769AZxh(i));
            if (mjfkcM647mjFkc == null) {
                mjfkcM647mjFkc = new mjFkc();
                this.f1003mjFkc.put(c4742vL.m13769AZxh(i), mjfkcM647mjFkc);
            }
            if (i2 > i) {
                mjfkcM647mjFkc.m648wA(c4742vL, i + 1, i2);
            } else {
                mjfkcM647mjFkc.f1002AZxh = c4742vL;
            }
        }

        public mjFkc(int i) {
            this.f1003mjFkc = new SparseArray(i);
        }
    }

    public C0080JHa(Typeface typeface, C3536d2 c3536d2) {
        this.f999ZfxDd = typeface;
        this.f1000mjFkc = c3536d2;
        this.f998AZxh = new char[c3536d2.m11644ETF() * 2];
        m643mjFkc(c3536d2);
    }

    /* renamed from: AZxh */
    public static C0080JHa m638AZxh(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            AbstractC2352L8.m9358mjFkc("EmojiCompat.MetadataRepo.create");
            return new C0080JHa(typeface, AbstractC3600e2.m11792AZxh(byteBuffer));
        } finally {
            AbstractC2352L8.m9357AZxh();
        }
    }

    /* renamed from: JHa */
    public mjFkc m639JHa() {
        return this.f1001wA;
    }

    /* renamed from: KLFTb */
    public int m640KLFTb() {
        return this.f1000mjFkc.m11646VA();
    }

    /* renamed from: ZfxDd */
    public C3536d2 m641ZfxDd() {
        return this.f1000mjFkc;
    }

    /* renamed from: lgHUyS */
    public void m642lgHUyS(C4742vL c4742vL) {
        AbstractC2280K3.m9122lgHUyS(c4742vL, "emoji metadata cannot be null");
        AbstractC2280K3.m9118AZxh(c4742vL.m13778wA() > 0, "invalid metadata codepoint length");
        this.f1001wA.m648wA(c4742vL, 0, c4742vL.m13778wA() - 1);
    }

    /* renamed from: mjFkc */
    public final void m643mjFkc(C3536d2 c3536d2) {
        int iM11644ETF = c3536d2.m11644ETF();
        for (int i = 0; i < iM11644ETF; i++) {
            C4742vL c4742vL = new C4742vL(this, i);
            Character.toChars(c4742vL.m13772JHa(), this.f998AZxh, i * 2);
            m642lgHUyS(c4742vL);
        }
    }

    /* renamed from: wA */
    public char[] m644wA() {
        return this.f998AZxh;
    }

    /* renamed from: xJ */
    public Typeface m645xJ() {
        return this.f999ZfxDd;
    }
}
