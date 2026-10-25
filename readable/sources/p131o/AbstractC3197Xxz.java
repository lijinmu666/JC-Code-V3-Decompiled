package p131o;

/* renamed from: o.Xxz */
/* loaded from: classes.dex */
public abstract class AbstractC3197Xxz {

    /* renamed from: o.Xxz$mjFkc */
    public enum mjFkc {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    /* renamed from: KLFTb */
    public static AbstractC3197Xxz m10998KLFTb() {
        return new C3043Vgyli(mjFkc.TRANSIENT_ERROR, -1L);
    }

    /* renamed from: ZfxDd */
    public static AbstractC3197Xxz m10999ZfxDd(long j) {
        return new C3043Vgyli(mjFkc.OK, j);
    }

    /* renamed from: mjFkc */
    public static AbstractC3197Xxz m11000mjFkc() {
        return new C3043Vgyli(mjFkc.FATAL_ERROR, -1L);
    }

    /* renamed from: AZxh */
    public abstract long mo10703AZxh();

    /* renamed from: wA */
    public abstract mjFkc mo10705wA();
}
