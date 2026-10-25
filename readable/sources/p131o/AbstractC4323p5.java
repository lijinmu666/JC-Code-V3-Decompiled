package p131o;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: o.p5 */
/* loaded from: classes.dex */
public abstract class AbstractC4323p5 extends AbstractC2092HL {

    /* renamed from: Dt */
    public int f15897Dt;

    /* renamed from: ETF */
    public LayoutInflater f15898ETF;

    /* renamed from: qdMbNW */
    public int f15899qdMbNW;

    public AbstractC4323p5(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f15897Dt = i;
        this.f15899qdMbNW = i;
        this.f15898ETF = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // p131o.AbstractC2092HL
    /* renamed from: lgHUyS */
    public View mo8540lgHUyS(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15898ETF.inflate(this.f15899qdMbNW, viewGroup, false);
    }

    @Override // p131o.AbstractC2092HL
    /* renamed from: xJ */
    public View mo8544xJ(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15898ETF.inflate(this.f15897Dt, viewGroup, false);
    }
}
