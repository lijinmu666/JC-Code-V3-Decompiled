package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.wA */
/* loaded from: classes.dex */
public abstract class AbstractC4796wA implements Parcelable {

    /* renamed from: AZxh */
    public static final AbstractC4796wA f17169AZxh = new mjFkc();

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<AbstractC4796wA> f17170CREATOR = new AZxh();

    /* renamed from: mjFkc */
    public final Parcelable f17171mjFkc;

    /* renamed from: o.wA$AZxh */
    public class AZxh implements Parcelable.ClassLoaderCreator {
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public AbstractC4796wA createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC4796wA.f17169AZxh;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public AbstractC4796wA createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public AbstractC4796wA[] newArray(int i) {
            return new AbstractC4796wA[i];
        }
    }

    /* renamed from: o.wA$mjFkc */
    public class mjFkc extends AbstractC4796wA {
        public mjFkc() {
            super((mjFkc) null);
        }
    }

    public /* synthetic */ AbstractC4796wA(mjFkc mjfkc) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: mjFkc */
    public final Parcelable m13824mjFkc() {
        return this.f17171mjFkc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17171mjFkc, i);
    }

    public AbstractC4796wA() {
        this.f17171mjFkc = null;
    }

    public AbstractC4796wA(Parcelable parcelable) {
        if (parcelable != null) {
            this.f17171mjFkc = parcelable == f17169AZxh ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbstractC4796wA(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f17171mjFkc = parcelable == null ? f17169AZxh : parcelable;
    }
}
