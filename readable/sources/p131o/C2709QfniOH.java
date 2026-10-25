package p131o;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: o.QfniOH */
/* loaded from: classes.dex */
public class C2709QfniOH extends Filter {

    /* renamed from: mjFkc */
    public mjFkc f10202mjFkc;

    /* renamed from: o.QfniOH$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        Cursor mo8536AZxh();

        /* renamed from: ZfxDd */
        Cursor mo10016ZfxDd(CharSequence charSequence);

        /* renamed from: mjFkc */
        void mo8541mjFkc(Cursor cursor);

        /* renamed from: wA */
        CharSequence mo8543wA(Cursor cursor);
    }

    public C2709QfniOH(mjFkc mjfkc) {
        this.f10202mjFkc = mjfkc;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f10202mjFkc.mo8543wA((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo10016ZfxDd = this.f10202mjFkc.mo10016ZfxDd(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo10016ZfxDd != null) {
            filterResults.count = cursorMo10016ZfxDd.getCount();
            filterResults.values = cursorMo10016ZfxDd;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo8536AZxh = this.f10202mjFkc.mo8536AZxh();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorMo8536AZxh) {
            return;
        }
        this.f10202mjFkc.mo8541mjFkc((Cursor) obj);
    }
}
