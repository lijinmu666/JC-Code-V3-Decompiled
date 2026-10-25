package p131o;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import p131o.C2709QfniOH;

/* renamed from: o.HL */
/* loaded from: classes.dex */
public abstract class AbstractC2092HL extends BaseAdapter implements Filterable, C2709QfniOH.mjFkc {

    /* renamed from: AZxh */
    public boolean f8580AZxh;

    /* renamed from: JHa */
    public mjFkc f8581JHa;

    /* renamed from: KLFTb */
    public int f8582KLFTb;

    /* renamed from: ZfxDd */
    public Context f8583ZfxDd;

    /* renamed from: lgHUyS */
    public C2709QfniOH f8584lgHUyS;

    /* renamed from: mjFkc */
    public boolean f8585mjFkc;

    /* renamed from: wA */
    public Cursor f8586wA;

    /* renamed from: xJ */
    public DataSetObserver f8587xJ;

    /* renamed from: o.HL$AZxh */
    public class AZxh extends DataSetObserver {
        public AZxh() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC2092HL abstractC2092HL = AbstractC2092HL.this;
            abstractC2092HL.f8585mjFkc = true;
            abstractC2092HL.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC2092HL abstractC2092HL = AbstractC2092HL.this;
            abstractC2092HL.f8585mjFkc = false;
            abstractC2092HL.notifyDataSetInvalidated();
        }
    }

    /* renamed from: o.HL$mjFkc */
    public class mjFkc extends ContentObserver {
        public mjFkc() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AbstractC2092HL.this.m8542qdMbNW();
        }
    }

    public AbstractC2092HL(Context context, Cursor cursor, boolean z) {
        m8538JHa(context, cursor, z ? 1 : 2);
    }

    @Override // p131o.C2709QfniOH.mjFkc
    /* renamed from: AZxh */
    public Cursor mo8536AZxh() {
        return this.f8586wA;
    }

    /* renamed from: Dt */
    public Cursor m8537Dt(Cursor cursor) {
        Cursor cursor2 = this.f8586wA;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            mjFkc mjfkc = this.f8581JHa;
            if (mjfkc != null) {
                cursor2.unregisterContentObserver(mjfkc);
            }
            DataSetObserver dataSetObserver = this.f8587xJ;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f8586wA = cursor;
        if (cursor != null) {
            mjFkc mjfkc2 = this.f8581JHa;
            if (mjfkc2 != null) {
                cursor.registerContentObserver(mjfkc2);
            }
            DataSetObserver dataSetObserver2 = this.f8587xJ;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f8582KLFTb = cursor.getColumnIndexOrThrow("_id");
            this.f8585mjFkc = true;
            notifyDataSetChanged();
        } else {
            this.f8582KLFTb = -1;
            this.f8585mjFkc = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* renamed from: JHa */
    public void m8538JHa(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f8580AZxh = true;
        } else {
            this.f8580AZxh = false;
        }
        boolean z = cursor != null;
        this.f8586wA = cursor;
        this.f8585mjFkc = z;
        this.f8583ZfxDd = context;
        this.f8582KLFTb = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f8581JHa = new mjFkc();
            this.f8587xJ = new AZxh();
        } else {
            this.f8581JHa = null;
            this.f8587xJ = null;
        }
        if (z) {
            mjFkc mjfkc = this.f8581JHa;
            if (mjfkc != null) {
                cursor.registerContentObserver(mjfkc);
            }
            DataSetObserver dataSetObserver = this.f8587xJ;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: KLFTb */
    public abstract void mo8539KLFTb(View view, Context context, Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f8585mjFkc || (cursor = this.f8586wA) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f8585mjFkc) {
            return null;
        }
        this.f8586wA.moveToPosition(i);
        if (view == null) {
            view = mo8544xJ(this.f8583ZfxDd, this.f8586wA, viewGroup);
        }
        mo8539KLFTb(view, this.f8583ZfxDd, this.f8586wA);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f8584lgHUyS == null) {
            this.f8584lgHUyS = new C2709QfniOH(this);
        }
        return this.f8584lgHUyS;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f8585mjFkc || (cursor = this.f8586wA) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f8586wA;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f8585mjFkc && (cursor = this.f8586wA) != null && cursor.moveToPosition(i)) {
            return this.f8586wA.getLong(this.f8582KLFTb);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f8585mjFkc) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f8586wA.moveToPosition(i)) {
            if (view == null) {
                view = mo8540lgHUyS(this.f8583ZfxDd, this.f8586wA, viewGroup);
            }
            mo8539KLFTb(view, this.f8583ZfxDd, this.f8586wA);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    /* renamed from: lgHUyS */
    public abstract View mo8540lgHUyS(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // p131o.C2709QfniOH.mjFkc
    /* renamed from: mjFkc */
    public void mo8541mjFkc(Cursor cursor) {
        Cursor cursorM8537Dt = m8537Dt(cursor);
        if (cursorM8537Dt != null) {
            cursorM8537Dt.close();
        }
    }

    /* renamed from: qdMbNW */
    public void m8542qdMbNW() {
        Cursor cursor;
        if (!this.f8580AZxh || (cursor = this.f8586wA) == null || cursor.isClosed()) {
            return;
        }
        this.f8585mjFkc = this.f8586wA.requery();
    }

    @Override // p131o.C2709QfniOH.mjFkc
    /* renamed from: wA */
    public abstract CharSequence mo8543wA(Cursor cursor);

    /* renamed from: xJ */
    public abstract View mo8544xJ(Context context, Cursor cursor, ViewGroup viewGroup);
}
