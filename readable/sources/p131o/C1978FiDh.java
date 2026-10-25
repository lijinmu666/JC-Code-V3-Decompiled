package p131o;

/* renamed from: o.FiDh */
/* loaded from: classes.dex */
public final class C1978FiDh extends IllegalStateException {
    public C1978FiDh(String str, Throwable th) {
        super(str, th);
    }

    /* renamed from: mjFkc */
    public static IllegalStateException m8318mjFkc(AbstractC1670B7 abstractC1670B7) {
        if (!abstractC1670B7.mo7667lgHUyS()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excMo7665KLFTb = abstractC1670B7.mo7665KLFTb();
        return new C1978FiDh("Complete with: ".concat(excMo7665KLFTb != null ? "failure" : abstractC1670B7.mo7669qdMbNW() ? "result ".concat(String.valueOf(abstractC1670B7.mo7664JHa())) : abstractC1670B7.mo7671xJ() ? "cancellation" : "unknown issue"), excMo7665KLFTb);
    }
}
