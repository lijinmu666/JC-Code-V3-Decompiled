package p131o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: o.XVrPFt */
/* loaded from: classes.dex */
public class C3167XVrPFt extends BaseAdapter {

    /* renamed from: ZfxDd */
    public static final int f11626ZfxDd = 4;

    /* renamed from: AZxh */
    public final int f11627AZxh;

    /* renamed from: mjFkc */
    public final Calendar f11628mjFkc;

    /* renamed from: wA */
    public final int f11629wA;

    public C3167XVrPFt() {
        Calendar calendarM8116lgHUyS = AbstractC1870E9.m8116lgHUyS();
        this.f11628mjFkc = calendarM8116lgHUyS;
        this.f11627AZxh = calendarM8116lgHUyS.getMaximum(7);
        this.f11629wA = calendarM8116lgHUyS.getFirstDayOfWeek();
    }

    /* renamed from: AZxh */
    public final int m10939AZxh(int i) {
        int i2 = i + this.f11629wA;
        int i3 = this.f11627AZxh;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11627AZxh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC2007G4.f8314MiMN, viewGroup, false);
        }
        this.f11628mjFkc.set(7, m10939AZxh(i));
        textView.setText(this.f11628mjFkc.getDisplayName(7, f11626ZfxDd, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(AbstractC2481N4.f9651qdMbNW), this.f11628mjFkc.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    @Override // android.widget.Adapter
    /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        if (i >= this.f11627AZxh) {
            return null;
        }
        return Integer.valueOf(m10939AZxh(i));
    }

    public C3167XVrPFt(int i) {
        Calendar calendarM8116lgHUyS = AbstractC1870E9.m8116lgHUyS();
        this.f11628mjFkc = calendarM8116lgHUyS;
        this.f11627AZxh = calendarM8116lgHUyS.getMaximum(7);
        this.f11629wA = i;
    }
}
